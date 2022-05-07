package com.auth.authserver.domain.usecases;

import com.auth.authserver.domain.model.gateways.PasswordEncryptService;
import com.auth.authserver.domain.model.gateways.TokenService;
import com.auth.authserver.domain.model.gateways.UserRepository;
import com.auth.authserver.domain.model.user.User;
import com.auth.authserver.domain.model.user.UserRequestDTO;
import com.auth.authserver.domain.model.user.UserResponseDTO;
import com.auth.authserver.domain.usecases.registeruser.RegisterUserUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.print.attribute.standard.RequestingUserName;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class RegisterUseCaseTest {

    private UserRepository userRepository;
    private TokenService tokenService;

    private PasswordEncryptService encryptService;
    private RegisterUserUseCase useCase;

    @BeforeEach
    void setUp() {

        userRepository = mock(UserRepository.class);
        tokenService = mock(TokenService.class);
        encryptService = mock(PasswordEncryptService.class);
        useCase = new RegisterUserUseCase(userRepository, tokenService, encryptService);
    }


    @Test
    void create_user_test_ok()  {

        //Given
        UserRequestDTO request = new UserRequestDTO();
        request.setEmail("email@test");
        request.setGoogle(false);
        request.setImage("imagetest.jpg");
        request.setName("John Doe");
        request.setPassword("1234456");
        //When
        when(userRepository.createUser(any())).thenReturn(new User());
        when(encryptService.encryptPassword(any())).thenReturn("encryptPwd");
        var result = useCase.registerUser(request);
        //Then
        assertNotNull(result);
    }
}