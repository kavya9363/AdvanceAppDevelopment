package com.yoga.yoga.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
@Service
public class EmailSenderService {
    
    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String fromEmail;
    
    public void sendSimpleEmail(String toEmail,
                                String subject,
                                String body
    ) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("m18256644@gmail.com");
        message.setTo(toEmail);
        message.setText(body);
        message.setSubject(subject);
        mailSender.send(message);
        System.out.println("Mail Send successfully to "+toEmail);
}
public void sendMimeEmail(String toEmail, String subject, String body) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(fromEmail);
        helper.setTo(toEmail);
        helper.setSubject(subject);
        helper.setText(body, true); // true indicates HTML format if needed
        mailSender.send(message);
        System.out.println("Mime Mail Sent successfully to " + toEmail);
    }
}
