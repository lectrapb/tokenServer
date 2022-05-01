package com.auth.authserver.domain.usecases;

import com.auth.authserver.domain.model.gateways.TokenService;
import com.auth.authserver.domain.model.login.LoginRequestDTO;
import com.auth.authserver.infraestructure.helpers.TokenServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginUseCaseTest {

    private LoginUseCase useCase;
    private TokenService tokenService;

    @BeforeEach
    void setUp() {
        tokenService = new TokenServiceImpl();
        useCase = new LoginUseCase(tokenService);
    }

    @Test
    void login_validte_user_ok_test(){

        LoginRequestDTO requestDTO = new LoginRequestDTO();
        requestDTO.setEmail("user@email.com");
        requestDTO.setEmail("123456");
        var response = useCase.validateUser(requestDTO);
        assertNotNull(response);
    }
}