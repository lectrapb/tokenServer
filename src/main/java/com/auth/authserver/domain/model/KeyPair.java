package com.auth.authserver.domain.model;



import lombok.Data;

import java.security.PrivateKey;
import java.security.PublicKey;

@Data
public class KeyPair {

    private PrivateKey privateKey;
    private PublicKey publicKey;
}
