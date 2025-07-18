package com.isco.aduana.infrastructure.adapter.ouput.persistence.repository;

import com.isco.aduana.infrastructure.adapter.ouput.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository
        extends JpaRepository<UserEntity, Long>
{
}
