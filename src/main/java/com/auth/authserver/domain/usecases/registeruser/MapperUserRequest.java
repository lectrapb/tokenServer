package com.auth.authserver.domain.usecases.registeruser;

import com.auth.authserver.domain.model.gateways.TokenService;
import com.auth.authserver.domain.model.user.User;
import com.auth.authserver.domain.model.user.UserRequestDTO;
import com.auth.authserver.domain.model.user.UserResponseDTO;

public class MapperUserRequest {
    public static User toModel(UserRequestDTO requestDTO) {
             User user = new User();
            if(requestDTO != null ){
                user.setName(requestDTO.getName());
                user.setEmail(requestDTO.getEmail());
                user.setRole(requestDTO.getEmail());
                user.setImage(requestDTO.getImage());
                user.setPassword(requestDTO.getPassword());
            }
            return user;
    }

    public static UserResponseDTO toDTO(User user, TokenService tokenService) {

           UserResponseDTO responseDTO = new UserResponseDTO();

           if(user != null){
               responseDTO.setName(user.getName());
               responseDTO.setEmail(user.getEmail());
               responseDTO.setRole(user.getRole());
               responseDTO.setImage(user.getImage());
               responseDTO.setGoogle(user.isGoogle());
               responseDTO.setToken(tokenService.createToken(user.getUid()));
           }
           return responseDTO;
    }
}
