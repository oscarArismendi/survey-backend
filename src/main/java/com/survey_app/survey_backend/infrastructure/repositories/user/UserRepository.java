package com.survey_app.survey_backend.infrastructure.repositories.user;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.survey_app.survey_backend.domain.entity.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity,Long> {

    Optional<UserEntity> findUserByUsername(String username);
}
