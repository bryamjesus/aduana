package com.isco.aduana.infrastructure.adapter.ouput.persistence;

import com.isco.aduana.application.ports.output.UserOutputPort;
import com.isco.aduana.domain.model.User;
import com.isco.aduana.infrastructure.adapter.ouput.persistence.mapper.UserMapper;
import com.isco.aduana.infrastructure.adapter.ouput.persistence.repository.UserRepository;
import com.isco.aduana.infrastructure.adapter.ouput.persistence.entity.UserEntity;
import lombok.RequiredArgsConstructor;

public class UserPersistenceAdapter implements UserOutputPort
{
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserPersistenceAdapter(UserRepository userRepository,
            UserMapper userMapper)
    {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user)
    {
        UserEntity userEntity = userMapper.toEntity(user);
        System.out.println("Antes del save userEntity = " + userEntity);
        UserEntity saveUser = userRepository.save(userEntity);
        System.out.println("Despues del save userEntity = " + userEntity);

        return userMapper.toUser(saveUser);
    }
}
