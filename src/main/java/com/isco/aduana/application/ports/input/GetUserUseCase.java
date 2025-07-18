package com.isco.aduana.application.ports.input;

import com.isco.aduana.domain.model.User;

public interface GetUserUseCase
{
    User getUserById(Long id);
}
