package com.isco.aduana.domain.service;

import com.isco.aduana.application.ports.input.CreateUserUserCase;
import com.isco.aduana.application.ports.output.UserOutputPort;
import com.isco.aduana.domain.model.User;
import lombok.AllArgsConstructor;

// @AllArgsConstructor
public class UserService implements CreateUserUserCase
{
    private final UserOutputPort userOutputPort;

    public UserService(UserOutputPort userOutputPort)
    {
        this.userOutputPort = userOutputPort;
    }

    @Override
    public User createUser(User user)
    {
        System.out.println("Creando usuario");
        return userOutputPort.saveUser(user);
    }
}
