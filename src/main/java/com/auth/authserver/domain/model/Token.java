package com.auth.authserver.domain.model;


import lombok.Data;

@Data
public class Token {

    private String exp;
    private String data;
}
