package com.yoga.yoga.service.impl;

import java.util.Optional;
import java.util.UUID;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.yoga.yoga.dto.request.AuthenticationRequest;
import com.yoga.yoga.dto.request.RegisterRequest;
import com.yoga.yoga.dto.request.VerificationCodeRequest;
import com.yoga.yoga.dto.response.AuthenticationResponse;
import com.yoga.yoga.model.User;
import com.yoga.yoga.model.enumerate.Role;
import com.yoga.yoga.repository.UserRepository;
import com.yoga.yoga.service.AuthService;
import com.yoga.yoga.util.JwtUtil;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class AuthServiceImpl implements AuthService{
    
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final EmailSenderService senderService;

    @Override
    public boolean userRegistration(RegisterRequest request) {
        Optional<User> isUserExists = userRepository.findByEmail(request.getEmail());
        if (!isUserExists.isPresent()) {
            var user = User.builder()
                    .name(request.getName())
                    .email(request.getEmail())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .confirmPassword(passwordEncoder.encode(request.getConfirmPassword()))
                //    .isEnabled(true)
                    .role(Role.valueOf(request.getRole().toUpperCase()))
//                    .address(request.getAddress())
//                    .phone(request.getPhone())
                    .build();
            userRepository.save(user);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public AuthenticationResponse userAuthentication(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        var user = userRepository.findByEmail(request.getEmail()).orElseThrow();
        var token = jwtUtil.generateToken(user);
        return AuthenticationResponse.builder()
                .token(token)
                .uid(user.getUid())
                .email(user.getEmail())
                .name(user.getName())
                .role(user.getRole())
                .build();
    }
    
    @Override
    public void sendVerificationCode(VerificationCodeRequest request) {
        // Generate and send verification code via email
        // You can use emailSenderService to send the verification code
        String verificationCode = generateVerificationCode();
        String email = request.getEmail();

    // Send the verification code to the user via email
    String subject = "Verification Code";
    String body = "Your verification code is: " + verificationCode;
    senderService.sendSimpleEmail(email, subject, body);
        // senderService.sendVerificationCode(request.getEmail(), verificationCode);
    }

    private String generateVerificationCode() {
        // Generate a random verification code (e.g., using UUID.randomUUID())
        String verificationCode = UUID.randomUUID().toString().substring(0, 6); // Generating a 6-character code
        return verificationCode;   
    }

}
