package com.auth.authserver.infraestructure.drivenadapters.security.adapter;

import com.auth.authserver.domain.model.gateways.PasswordEncryptService;
import com.auth.authserver.domain.model.util.Constants;
import com.auth.authserver.infraestructure.drivenadapters.security.algoritms.ByCryptImpl;
import com.auth.authserver.infraestructure.drivenadapters.security.algoritms.Pbkdf2Sha1Impl;

public class PasswordEncryptFactory {

    public PasswordEncryptService getPasswordEncrypt(String passwordEncryptTipe){

        PasswordEncryptService objPwd = null;
        switch (passwordEncryptTipe){

            case Constants.ALG_BYCRYPT:
                 objPwd = new ByCryptImpl();
                 break;
            case Constants.ALG_PBKDF2:
                 objPwd = new Pbkdf2Sha1Impl();
                 break;
            default:
                objPwd = new ByCryptImpl();
        }
        return objPwd;
    }
}
