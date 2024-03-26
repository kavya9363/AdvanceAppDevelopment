package com.yoga.yoga.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yoga.yoga.constant.Api;
import com.yoga.yoga.dto.request.AuthenticationRequest;
import com.yoga.yoga.dto.request.RegisterRequest;
import com.yoga.yoga.dto.request.VerificationCodeRequest;
import com.yoga.yoga.dto.response.AuthenticationResponse;
import com.yoga.yoga.service.AuthService;
import com.yoga.yoga.service.impl.EmailSenderService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(Api.AUTH)
@RequiredArgsConstructor
@Tag(name="Authentication")
public class AuthenticationController {

    private final AuthService authService;
    private final EmailSenderService senderService;
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest request) {
        boolean isRegistered = authService.userRegistration(request);
        // return isRegistered ? ResponseEntity.ok("User registered successfully")
        //         : ResponseEntity.badRequest().body("Something went wrong!");
        if (isRegistered) {
            // If registration is successful, send welcome email
            sendWelcomeEmail(request.getEmail());
            return ResponseEntity.ok("User registered successfully");
        } else {
            return ResponseEntity.badRequest().body("Something went wrong!");
        }
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(authService.userAuthentication(request));
    }

    private void sendWelcomeEmail(String userEmail) {
        String subject = "Welcome to Our Yoga Website!";
        String body = "Dear user, Welcome to our yoga community! We're thrilled to have you.";
        senderService.sendSimpleEmail(userEmail, subject, body);
    }

    @PostMapping("/sendverificationcode")
    public ResponseEntity<String> sendVerificationCode(@RequestBody VerificationCodeRequest request) {
        authService.sendVerificationCode(request);
        return ResponseEntity.ok("Verification code sent successfully");
    }

}
