package com.auth.authserver.infraestructure.drivenadapters.database.data;





import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Data
@Table(name = "users")
@Entity
public class UserData {

    @Id
    @Column(name = "user_uid")
    private String uid;
    @Column(name = "user_name")
    private String name;
    @Column(name = "user_email")
    private String email;
    @Column(name = "user_password")
    private String password;
    @Column(name = "user_image")
    private String image;
    @Column(name = "user_role")
    private String role;

    @Column(name = "user_google")
    private Boolean google = false;


    @PrePersist
    public void initId(){
        this.uid = UUID.randomUUID().toString();
    }
}
