package com.isco.aduana.application.ports.input;

import com.isco.aduana.domain.model.User;

public interface CreateUserUseCase
{
    User createUser(User user);
}
