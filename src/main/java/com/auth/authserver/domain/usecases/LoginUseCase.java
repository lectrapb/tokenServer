package com.auth.authserver.domain.usecases;

import com.auth.authserver.domain.model.gateways.TokenService;
import com.auth.authserver.domain.model.login.Login;
import com.auth.authserver.domain.model.login.LoginRequestDTO;
import com.auth.authserver.domain.model.user.User;

public class LoginUseCase {

    private final TokenService tokenService;

    public LoginUseCase(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    public Login validateUser(LoginRequestDTO requestDto){

        User user = new User();
        Login login = new Login();
        login.setToken(tokenService.createToken(user.getUid()));
        login.setOk(true);
        login.setMjs("User is authenticated");
        return login;
    }
}
