package com.auth.authserver.infraestructure.drivenadapters.database.adapter;

import com.auth.authserver.domain.model.gateways.UserRepository;
import com.auth.authserver.domain.model.user.User;
import com.auth.authserver.infraestructure.drivenadapters.database.data.UserData;
import com.auth.authserver.infraestructure.drivenadapters.database.repository.UserDataRepository;
import com.auth.authserver.infraestructure.drivenadapters.database.util.MapperUser;
import org.springframework.stereotype.Repository;

@Repository
public class UserAdapter implements UserRepository {

    private final UserDataRepository  repository;


    public UserAdapter(UserDataRepository repository) {
        this.repository = repository;
    }

    @Override
    public User createUser(User user) {

        UserData userData = MapperUser.toData(user);
        return MapperUser.toModel(repository.save(userData));
    }

    @Override
    public User findUserById(String id) {

        return MapperUser.toModel(repository.findById(id).orElse(null));
    }

    @Override
    public User findUserByEmail(String email) {
        UserData userData = repository.findByEmail(email);
        return MapperUser.toModel(userData);
    }
}
