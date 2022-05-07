package com.auth.authserver.infraestructure.drivenadapters.database.util;

import com.auth.authserver.domain.model.user.User;
import com.auth.authserver.infraestructure.drivenadapters.database.data.UserData;

public class MapperUser {

    public static UserData toData(User user){

        UserData userData = new UserData();
        userData.setName(user.getName());
        userData.setRole(user.getRole());
        userData.setEmail(user.getEmail());
        userData.setImage(user.getImage());
        userData.setGoogle(userData.getGoogle());
        userData.setPassword(user.getPassword());

        return userData;
    }

    public static  User toModel (UserData userData){

        User user = null;
        if(userData != null){
            user = new User();
            user.setName( userData.getName());
            user.setRole( userData.getRole());
            user.setEmail(userData.getEmail());
            user.setImage(userData.getImage());
            user.setGoogle(userData.getGoogle());
            user.setPassword(userData.getPassword());
        }
        return user;
    }
}
