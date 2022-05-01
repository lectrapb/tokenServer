package com.auth.authserver.domain.model.login;

import lombok.Data;

@Data
public class Login {

    private boolean ok;
    private String token;
    private String mjs;
}
