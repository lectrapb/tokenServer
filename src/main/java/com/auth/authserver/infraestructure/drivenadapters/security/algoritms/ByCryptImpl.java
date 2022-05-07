package com.auth.authserver.infraestructure.drivenadapters.security.algoritms;

import com.auth.authserver.domain.model.gateways.PasswordEncryptService;

public class ByCryptImpl implements PasswordEncryptService {
    @Override
    public String encryptPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt(12));
    }

    @Override
    public boolean checkPassword(String currentPass, String encryptPass) {
        return BCrypt.checkpw(currentPass, encryptPass);
    }
}
