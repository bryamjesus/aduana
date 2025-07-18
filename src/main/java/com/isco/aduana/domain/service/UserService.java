package com.isco.aduana.domain.service;

import com.isco.aduana.application.ports.input.CreateUserUseCase;
import com.isco.aduana.application.ports.input.GetUserUseCase;
import com.isco.aduana.application.ports.input.UpdateUserUseCase;
import com.isco.aduana.application.ports.output.UserOutputPort;
import com.isco.aduana.domain.model.User;

// @AllArgsConstructor
public class UserService
        implements CreateUserUseCase, GetUserUseCase, UpdateUserUseCase
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

    @Override
    public User getUserById(Long id)
    {
        System.out.println("Retornando Usuario por ID: " + id);
        return userOutputPort.getUserById(id).orElseThrow(
                () -> new RuntimeException("No se encontro el usuario " + id));
    }

    @Override
    public User updateUserById(User user)
    {
        return userOutputPort.updateUserById(user).orElseThrow(
                () -> new RuntimeException(
                        "No se encontro el usuario " + user.getId()));
    }
}
