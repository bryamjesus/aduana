package com.isco.aduana.domain.service;

import com.isco.aduana.application.ports.input.CreateUserUseCase;
import com.isco.aduana.application.ports.input.GetUserUseCase;
import com.isco.aduana.application.ports.output.UserOutputPort;
import com.isco.aduana.domain.model.User;
import org.modelmapper.internal.bytebuddy.implementation.bytecode.Throw;

// @AllArgsConstructor
public class UserServiceUse implements CreateUserUseCase, GetUserUseCase
{
    private final UserOutputPort userOutputPort;

    public UserServiceUse(UserOutputPort userOutputPort)
    {
        this.userOutputPort = userOutputPort;
    }

    @Override
    public User createUser(User user)
    {
        System.out.println("Creando usuario");
        return userOutputPort.saveUser(user);
    }

    @Override
    public User getUserById(Long id)
    {
        System.out.println("Retornando Usuario por ID: " + id);
        return userOutputPort.getUserById(id).orElseThrow(
                () -> new RuntimeException("No se encontro el usuario " + id));
    }
}
