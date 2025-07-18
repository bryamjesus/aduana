package com.isco.aduana.infrastructure.adapter.ouput.persistence.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.isco.aduana.domain.model.User;
import com.isco.aduana.infrastructure.adapter.ouput.persistence.entity.UserEntity;

public class UserMapper
{
    @Autowired
    private ModelMapper mapper;

    public User toUser(UserEntity entity){
        System.out.println("UserEntity = " + entity);
        return mapper.map(entity, User.class);
    }

    public UserEntity toEntity(User user){
        return mapper.map(user, UserEntity.class);
    }
}
