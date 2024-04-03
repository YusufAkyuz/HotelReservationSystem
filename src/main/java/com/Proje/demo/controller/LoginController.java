package com.Proje.demo.controller;

import com.fasterxml.jackson.annotation.JsonAlias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import com.Proje.demo.email.MailService;
import com.Proje.demo.entity.LocationInfo;
import com.Proje.demo.entity.UserInfo;
import com.Proje.demo.model.MailStructure;
import com.Proje.demo.services.LocationService;
import com.Proje.demo.services.UserService;

@Controller
    @RequestMapping("/login")
public class LoginController {

    private final MailService emailService;
    private final UserService userService;
    private final LocationService locationService;

    @Autowired
    public LoginController(MailService emailService, UserService userService, LocationService locationService) {
        this.emailService = emailService;
        this.userService = userService;
        this.locationService = locationService;
    }

    @PostMapping("reservation/{mail}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> createReservation(@PathVariable String mail, @RequestBody LocationInfo locationInfo) {


        String password = userService.createPassword();
        UserInfo userInfo = new UserInfo(mail, password, "USER");
        userService.saveUser(userInfo);
        locationService.saveLocation(locationInfo);
        userService.loadUserByUsername(mail);

        MailStructure mailStructure = new MailStructure();
        mailStructure.setMessage("Reservation Successfully\nYour Password : " + password);
        mailStructure.setSubject("Reservation");

        emailService.sendMail(mail, mailStructure);
        return ResponseEntity.ok("Successful Process");
    }

}
