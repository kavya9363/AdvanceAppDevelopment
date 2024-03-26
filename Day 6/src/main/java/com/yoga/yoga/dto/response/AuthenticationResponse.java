package com.yoga.yoga.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.yoga.yoga.model.enumerate.Role;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationResponse {
    private String token;
    private String email;
    private Long uid;
    private String name;
    private Role role;
}

