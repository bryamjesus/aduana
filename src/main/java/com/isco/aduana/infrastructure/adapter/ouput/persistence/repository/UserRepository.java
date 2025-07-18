package com.isco.aduana.infrastructure.adapter.ouput.persistence.repository;

import com.isco.aduana.domain.model.User;
import com.isco.aduana.infrastructure.adapter.ouput.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long>
{
    Optional<UserEntity> getUserEntityById(Long id);
    // UserEntity updateUserEntityById(Long id);
}
