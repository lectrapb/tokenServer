package com.auth.authserver.domain.model.login;

import lombok.Data;

@Data
public class LoginRequestDTO {

    private String email;
    private String password;
}
