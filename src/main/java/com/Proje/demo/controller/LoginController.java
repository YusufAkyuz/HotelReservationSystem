package com.Proje.demo.controller;

import com.Proje.demo.entity.ReservationInfo;
import com.Proje.demo.services.ReservationService;
import com.sun.security.auth.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.Proje.demo.email.MailService;
import com.Proje.demo.entity.LocationInfo;
import com.Proje.demo.entity.UserInfo;
import com.Proje.demo.model.MailStructure;
import com.Proje.demo.services.LocationService;
import com.Proje.demo.services.UserService;

import java.util.List;

@Controller
    @RequestMapping("/login")
public class LoginController {

    private final MailService emailService;
    private final UserService userService;
    private final LocationService locationService;
    private final ReservationService reservationService;


    @Autowired
    public LoginController(MailService emailService, UserService userService, LocationService locationService, ReservationService reservationService) {
        this.emailService = emailService;
        this.userService = userService;
        this.locationService = locationService;
        this.reservationService = reservationService;
    }

    @PostMapping("reservation/{mail}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> createReservation(@PathVariable String mail, @RequestBody LocationInfo locationInfo) {


        String password = userService.createPassword();
        UserInfo user = new UserInfo(mail, password, "USER");
        userService.saveUser(user);
        locationService.saveLocation(locationInfo);
        ReservationInfo reservationInfo = new ReservationInfo(user.getId(), locationInfo.getId());
        reservationService.saveReservation(reservationInfo);

        MailStructure mailStructure = new MailStructure();
        mailStructure.setMessage("Reservation Successfully\nYour Password : " + password);
        mailStructure.setSubject("Reservation");

        emailService.sendMail(mail, mailStructure);
        return ResponseEntity.ok("Successful Process");
    }
    /*
    @GetMapping("/user/{userId}/reservations")
    @PreAuthorize("hasRole('USER') || hasRole('ADMIN')")
    public ResponseEntity<List<ReservationInfo>> getUserReservations(@PathVariable("userId") Long userId) {
        List<ReservationInfo> userReservations = reservationService.getUserReservations(userId);
        return ResponseEntity.ok(userReservations);
    }
*/


}
