package com.isco.aduana.application.ports.input;

import com.isco.aduana.domain.model.User;

public interface UpdateUserUseCase
{
    User updateUserById(User user);
}
