package com.Proje.demo.controller;

import com.Proje.demo.email.MailService;
import com.Proje.demo.entity.AdminReservationInfo;
import com.Proje.demo.entity.LocationInfo;
import com.Proje.demo.entity.UserInfo;
import com.Proje.demo.model.MailStructure;
import com.Proje.demo.services.AdminReservationService;
import com.Proje.demo.services.LocationService;
import com.Proje.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/admin/reservations")
public class AdminReservationController {

    private final AdminReservationService adminReservationService;
    private final MailService emailService;
    private final UserService userService;
    private final LocationService locationService;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    public AdminReservationController(AdminReservationService adminReservationService, MailService emailService, UserService userService, LocationService locationService) {
        this.adminReservationService = adminReservationService;
        this.emailService = emailService;
        this.userService = userService;
        this.locationService = locationService;

    }

    @PostMapping("/create/{mail}")
    public String createReservation(@PathVariable String mail, @RequestBody LocationInfo locationInfo) {

        String password = userService.createPassword();
        UserInfo userInfo = new UserInfo(mail,password);
        userService.saveUser(userInfo);
        locationService.saveLocation(locationInfo);

        AdminReservationInfo adminReservationInfo = new AdminReservationInfo(userInfo.getId(), locationInfo.getId());

        adminReservationService.createReservation(adminReservationInfo);



        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("yusufakyus47@gmail.com");
        message.setTo("ozknsmz@hotmail.com");
        message.setText("body");
        message.setSubject("subject");
        mailSender.send(message);
        System.out.println("Mail Send...");



        /*
        MailStructure mailStructure = new MailStructure();
        mailStructure.setMessage("Reservation Successfully\nYour Password : " + password);
        mailStructure.setSubject("Reservation");

        emailService.sendMail(mail, mailStructure);
         */

        return "Successful Process";

    }
}

