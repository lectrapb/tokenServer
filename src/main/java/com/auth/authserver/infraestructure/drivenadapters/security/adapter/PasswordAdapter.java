package com.auth.authserver.infraestructure.drivenadapters.security.adapter;

import com.auth.authserver.domain.model.gateways.PasswordEncryptService;


public class PasswordAdapter implements PasswordEncryptService {

    private final PasswordEncryptFactory encryptFactory;
    private final PasswordEncryptService encrypt;

    public PasswordAdapter(String encryptAlg) {
        encryptFactory = new PasswordEncryptFactory();
        encrypt = encryptFactory.getPasswordEncrypt(encryptAlg);
    }

    @Override
    public String encryptPassword(String password) {
        return encrypt.encryptPassword(password);
    }

    @Override
    public boolean checkPassword(String currentPass, String encryptPass) {
        return encrypt.checkPassword(currentPass, encryptPass);
    }
}
