package com.auth.authserver.domain.usecases.loginusecase;

import com.auth.authserver.domain.model.gateways.PasswordEncryptService;
import com.auth.authserver.domain.model.gateways.TokenService;
import com.auth.authserver.domain.model.gateways.UserRepository;
import com.auth.authserver.domain.model.login.Login;
import com.auth.authserver.domain.model.login.LoginRequestDTO;
import com.auth.authserver.domain.model.token.Token;
import com.auth.authserver.domain.model.user.User;
import com.auth.authserver.domain.model.user.UserRequestDTO;
import com.auth.authserver.domain.model.user.UserResponseDTO;
import com.auth.authserver.domain.usecases.registeruser.MapperUserRequest;

public class LoginUseCase {

    private final UserRepository userRepository;
    private final PasswordEncryptService encryptService;
    private final TokenService tokenService;

    public LoginUseCase(UserRepository userRepository,
                        PasswordEncryptService encryptService, TokenService tokenService) {
        this.userRepository = userRepository;
        this.encryptService = encryptService;
        this.tokenService = tokenService;
    }

    public Login validateUser(LoginRequestDTO requestDto){

        User user =  userRepository.findUserByEmail(requestDto.getEmail());
        Login login = new Login();
        boolean match = false;
        if(user != null){
            match = encryptService.checkPassword(requestDto.getPassword(), user.getPassword());
        }
        if(match){
            login.setOk(true);
            login.setToken(tokenService.createToken(user.getUid()));
            login.setMjs("User authorized");
        }else{
            login.setOk(false);
            login.setToken("");
            login.setMjs("unauthorized User");
        }
        return login;
    }

    public UserResponseDTO validateUserByToken(String  token ) throws Exception {

        Token tokenData = tokenService.validateToken(token);
        User user = null;
        if(tokenData.isValid()){
            user = userRepository.findUserById(tokenData.getUid());
        }else {
            throw new Exception("token doesn't exist!");
        }
        UserResponseDTO responseDTO = MapperUserRequest.toDTO(user, tokenService);
        return responseDTO;
    }
}
