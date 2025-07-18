package com.isco.aduana.infrastructure.adapter.ouput.persistence;

import com.isco.aduana.application.ports.output.UserOutputPort;
import com.isco.aduana.domain.model.User;
import com.isco.aduana.infrastructure.adapter.ouput.persistence.mapper.UserMapper;
import com.isco.aduana.infrastructure.adapter.ouput.persistence.repository.UserRepository;
import com.isco.aduana.infrastructure.adapter.ouput.persistence.entity.UserEntity;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

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

    @Override
    public Optional<User> getUserById(Long id)
    {
        Optional<UserEntity> userFind = userRepository.getUserEntityById(id);

        if (userFind.isEmpty())
        {
            return Optional.empty();
        }

        User user = userMapper.toUser(userFind.get());

        return Optional.of(user);
    }
}
