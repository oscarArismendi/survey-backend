package com.survey_app.survey_backend.infrastructure.repositories.user;

import org.springframework.data.repository.CrudRepository;

import com.survey_app.survey_backend.domain.entity.User;

public interface UserRepository extends CrudRepository<User,Long> {

}
