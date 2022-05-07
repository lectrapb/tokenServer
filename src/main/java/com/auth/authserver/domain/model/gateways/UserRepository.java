package com.auth.authserver.domain.model.gateways;

import com.auth.authserver.domain.model.user.User;

public interface UserRepository {

       User createUser(User user);

       User findUserById(String id);

       User findUserByEmail(String email);
}
