package com.auth.authserver.domain.usecases;

import com.auth.authserver.domain.model.gateways.PasswordEncryptService;
import com.auth.authserver.domain.model.gateways.TokenService;
import com.auth.authserver.domain.model.gateways.UserRepository;
import com.auth.authserver.domain.model.login.LoginRequestDTO;
import com.auth.authserver.domain.model.token.Token;
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
        tokenService =   mock(TokenService.class);
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
        //When
        when(userRepository.findUserByEmail(anyString())).thenReturn(user);
        when(encryptService.checkPassword(anyString(), anyString())).thenReturn(true);
        //Then
        var response = useCase.validateUser(requestDTO);
        assertNotNull(response);
    }
    @Test
    void login_validate_user_by_token_ok() throws Exception {
        //Given
        String token = "dummy-token";
        Token tokenData = new Token();
        tokenData.setValid(true);
        tokenData.setUid("147");
        User user = new User();
        //When
        when(tokenService.validateToken(anyString())).thenReturn(tokenData);
        when(userRepository.findUserById(anyString())).thenReturn(user);
        var response = useCase.validateUserByToken(token);
        //Then
        assertNotNull(response);

    }
}