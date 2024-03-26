package com.yoga.yoga.service;

import org.springframework.stereotype.Service;

import com.yoga.yoga.dto.request.AuthenticationRequest;
import com.yoga.yoga.dto.request.RegisterRequest;
import com.yoga.yoga.dto.request.VerificationCodeRequest;
import com.yoga.yoga.dto.response.AuthenticationResponse;

@Service
public interface AuthService {
    boolean userRegistration(RegisterRequest request);

    AuthenticationResponse userAuthentication(AuthenticationRequest request);
    void sendVerificationCode(VerificationCodeRequest request);
}
