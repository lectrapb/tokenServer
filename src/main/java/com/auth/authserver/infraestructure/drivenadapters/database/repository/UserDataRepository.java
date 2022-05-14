package com.auth.authserver.infraestructure.drivenadapters.database.repository;

import com.auth.authserver.infraestructure.drivenadapters.database.data.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDataRepository extends JpaRepository<UserData, String> {



    UserData findByEmail(String email);
}
