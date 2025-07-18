package com.isco.aduana.application.ports.output;

import com.isco.aduana.domain.model.User;

import java.util.Optional;

public interface UserOutputPort
{
    User saveUser(User user);

    Optional<User> getUserById(Long id);
}
