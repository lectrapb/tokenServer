package com.auth.authserver.domain.model.token;


import lombok.Data;

@Data
public class Token {

    private boolean valid;
    private String  uid;
}
