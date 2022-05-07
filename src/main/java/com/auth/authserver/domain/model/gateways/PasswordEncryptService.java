package com.auth.authserver.domain.model.gateways;

public interface PasswordEncryptService {

    String encryptPassword(String password);
    boolean checkPassword(String currentPass, String encryptPass);

}
