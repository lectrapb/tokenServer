package com.auth.authserver.domain.usecases;

import com.auth.authserver.domain.model.Token;
import org.jose4j.lang.JoseException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import static org.junit.jupiter.api.Assertions.*;

class CreateTokenUseCaseTest {

    private CreateUserUseCase useCase;

    @BeforeEach
    void setUp() {
        useCase = new CreateUserUseCase();
    }

    @Test
    void create_user_test()  {

        var result = useCase.createUser();
        assertNull(result);
    }
}