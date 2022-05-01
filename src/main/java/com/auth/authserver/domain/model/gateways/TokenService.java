package com.auth.authserver.domain.model.gateways;

public interface TokenService {

    String createToken(String uid);
    boolean validateToken(String token);
}
