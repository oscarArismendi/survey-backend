package com.survey_app.survey_backend.application.services;

import java.util.List;

import com.survey_app.survey_backend.domain.entity.UserEntity;

public interface IUserService {
    List<UserEntity> findAll();
    UserEntity save(UserEntity user);
}
