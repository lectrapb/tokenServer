package com.auth.authserver.domain.model.user;

import lombok.Data;

@Data
public class UserRequestDTO {

    private String name;
    private String email;
    private String password;
    private String image;
    private String role;
    private boolean google;
}
