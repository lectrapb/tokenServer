package com.auth.authserver.infraestructure.drivenadapters.security.algoritms;

import com.auth.authserver.domain.model.gateways.PasswordEncryptService;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class Pbkdf2Sha1Impl implements PasswordEncryptService {
    @Override
    public String encryptPassword(String password) {
        String encryptPassword = null;
        try {
            encryptPassword = Pbkdf2Sha1.generatePassword(password);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }
        return encryptPassword ;
    }

    @Override
    public boolean checkPassword(String currentPass, String encryptPass) {
        boolean match = false;
        try {
            match = Pbkdf2Sha1.validatePassword(currentPass, encryptPass);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }
        return match;
    }
}
