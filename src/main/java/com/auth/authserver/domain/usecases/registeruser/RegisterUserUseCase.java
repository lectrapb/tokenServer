package com.auth.authserver.domain.usecases.registeruser;

import com.auth.authserver.domain.model.gateways.PasswordEncryptService;
import com.auth.authserver.domain.model.gateways.TokenService;
import com.auth.authserver.domain.model.gateways.UserRepository;
import com.auth.authserver.domain.model.user.User;
import com.auth.authserver.domain.model.user.UserRequestDTO;
import com.auth.authserver.domain.model.user.UserResponseDTO;

public class RegisterUserUseCase {

    private final UserRepository userRepository;
    private final TokenService tokenService;
    private final PasswordEncryptService passwordEncrypt;

    public RegisterUserUseCase(UserRepository userRepository,
                               TokenService tokenService,
                               PasswordEncryptService passwordEncrypt) {
        this.userRepository = userRepository;
        this.tokenService = tokenService;
        this.passwordEncrypt = passwordEncrypt;
    }

    public UserResponseDTO registerUser(UserRequestDTO requestDTO) throws Exception {

        User user =  MapperUserRequest.toModel(requestDTO);
        User userExist = userRepository.findUserByEmail(user.getEmail());
        if(userExist != null){
            throw new Exception("user exist!");
        }
        user.setPassword(passwordEncrypt
                .encryptPassword(user.getPassword()));
        User userNew = userRepository.createUser(user);
        UserResponseDTO responseDTO = MapperUserRequest.toDTO(userNew, tokenService);
        return responseDTO;
    }



}
