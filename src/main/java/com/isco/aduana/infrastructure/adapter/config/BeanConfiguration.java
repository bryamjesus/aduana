package com.isco.aduana.infrastructure.adapter.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.isco.aduana.domain.service.UserService;
import com.isco.aduana.infrastructure.adapter.ouput.persistence.UserPersistenceAdapter;
import com.isco.aduana.infrastructure.adapter.ouput.persistence.mapper.UserMapper;
import com.isco.aduana.infrastructure.adapter.ouput.persistence.repository.UserRepository;

@Configuration
public class BeanConfiguration
{
    @Bean
    public ModelMapper modelMapper()
    {
        return new ModelMapper();
    }

    @Bean
    public UserMapper userMapper()
    {
        return new UserMapper();
    }

    @Bean
    public UserPersistenceAdapter userPersistenceAdapter(
            UserRepository userRepository, UserMapper userMapper)
    {
        return new UserPersistenceAdapter(userRepository, userMapper);
    }

    @Bean
    public UserService userService(
            UserPersistenceAdapter userPersistenceAdapter)
    {
        return new UserService(userPersistenceAdapter);
    }
}
