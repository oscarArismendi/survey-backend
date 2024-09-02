package com.survey_app.survey_backend.infrastructure.repositories.user;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.survey_app.survey_backend.domain.entity.UserEntity;


public interface UserRepository extends CrudRepository<UserEntity,Long> {

    Optional<UserEntity> findUserByUsername(String username);
}
