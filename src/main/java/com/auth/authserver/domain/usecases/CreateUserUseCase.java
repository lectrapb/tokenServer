package com.auth.authserver.domain.usecases;

import com.auth.authserver.domain.model.gateways.TokenService;
import com.auth.authserver.domain.model.user.User;
import com.auth.authserver.infraestructure.helpers.TokenServiceImpl;

public class CreateUserUseCase {


    public User createUser()  {


        TokenService tokenService = new TokenServiceImpl();
        User user = new User();
        return null;
    }
}
