package com.auth.authserver.domain.model.user;

import lombok.Data;

import java.util.UUID;

@Data
public class User {

   private String uid;
   private String name;
   private String email;
   private String image;
   private String role;
   private boolean google;

    public User() {
        this.uid = UUID.randomUUID().toString();
        this.name = "gio";
        this.email = "test@email";
        this.image = "userimage.jpg";
        this.role = "USER_ROLE";
    }
}
