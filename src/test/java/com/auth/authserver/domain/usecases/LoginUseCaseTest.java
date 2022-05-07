package com.auth.authserver.domain.usecases;

import com.auth.authserver.domain.model.gateways.PasswordEncryptService;
import com.auth.authserver.domain.model.gateways.TokenService;
import com.auth.authserver.domain.model.gateways.UserRepository;
import com.auth.authserver.domain.model.login.LoginRequestDTO;
import com.auth.authserver.domain.model.user.User;
import com.auth.authserver.domain.usecases.loginusecase.LoginUseCase;
import com.auth.authserver.infraestructure.helpers.TokenServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class LoginUseCaseTest {

    private TokenService tokenService;
    private PasswordEncryptService encryptService;
    private UserRepository userRepository;
    private LoginUseCase useCase;


    @BeforeEach
    void setUp() {
        userRepository = mock(UserRepository.class);
        encryptService = mock(PasswordEncryptService.class);
        tokenService = new TokenServiceImpl();
        useCase = new LoginUseCase(userRepository,encryptService,tokenService);
    }

    @Test
    void login_validte_user_ok_test(){

        //Given
        LoginRequestDTO requestDTO = new LoginRequestDTO();
        requestDTO.setEmail("user@email.com");
        requestDTO.setEmail("123456");
        User user = new User();
        user.setPassword("123456");
        user.setEmail("mail@mail.com");
        var response = useCase.validateUser(requestDTO);
        //When
        when(userRepository.findUserByEmail(anyString())).thenReturn(user);
        when(encryptService.checkPassword(anyString(), anyString())).thenReturn(true);
        //Then
        assertNotNull(response);
    }
}