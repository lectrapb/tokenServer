package com.auth.authserver.config;


import com.auth.authserver.domain.model.gateways.PasswordEncryptService;
import com.auth.authserver.domain.model.gateways.TokenService;
import com.auth.authserver.domain.model.util.Constants;
import com.auth.authserver.domain.usecases.loginusecase.LoginUseCase;
import com.auth.authserver.domain.usecases.registeruser.RegisterUserUseCase;
import com.auth.authserver.infraestructure.drivenadapters.database.adapter.UserAdapter;
import com.auth.authserver.infraestructure.drivenadapters.security.adapter.PasswordAdapter;
import com.auth.authserver.infraestructure.helpers.TokenServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    public TokenService tokenService(){
         return new TokenServiceImpl();
    }

    @Bean
    public PasswordEncryptService passwordEncryptService(){
        return new PasswordAdapter(Constants.ALG_BYCRYPT);
    }

    @Bean
    public RegisterUserUseCase registerUserUseCase(UserAdapter userAdapter, TokenService tokenService, PasswordEncryptService pwdEcy){

         return new RegisterUserUseCase(userAdapter, tokenService, pwdEcy);
    }

    @Bean
    public LoginUseCase loginUseCase(UserAdapter userAdapter,  PasswordEncryptService pwdEncy , TokenService tokenService){
        return new LoginUseCase(userAdapter,  pwdEncy, tokenService);
    }

}
