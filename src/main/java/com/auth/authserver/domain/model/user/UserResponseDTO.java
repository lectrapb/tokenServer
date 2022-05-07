package com.auth.authserver.domain.model.user;

import lombok.Data;

@Data
public class UserResponseDTO {

    private String name;
    private String email;
    private String image;
    private String role;
    private boolean google;
    private String token;
}
