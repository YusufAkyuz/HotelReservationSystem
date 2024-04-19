package com.Proje.demo.email;

import com.Proje.demo.model.MailStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

@Service
public class MailService {


    @Value("$(spring.mail.username)")
    private String fromMail;

    public void sendMail(String mail, MailStructure mailStructure) {

        JavaMailSenderImpl mailSender;


        mailSender = new JavaMailSenderImpl();

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(fromMail);
        simpleMailMessage.setSubject(mailStructure.getSubject());
        simpleMailMessage.setText(mailStructure.getMessage());
        simpleMailMessage.setTo(mail);
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);
        mailSender.setUsername("yusufakyus47@gmail.com");
        mailSender.setPassword("vqzydcqwoyyrlgzz");

        java.util.Properties props = mailSender.getJavaMailProperties();

        props.put("mail.transport.protocol", "smtp");

        props.put(
                "mail.smtp.starttls.enable"
                ,
                "true"
        );         props.put(
                "mail.debug"
                ,
                "true"
        );


        mailSender.send(simpleMailMessage);
    }
}
