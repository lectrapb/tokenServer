package com.auth.authserver.domain.model.gateways;

import com.auth.authserver.domain.model.token.Token;

public interface TokenService {

    String createToken(String uid);
    Token validateToken(String token);
}
