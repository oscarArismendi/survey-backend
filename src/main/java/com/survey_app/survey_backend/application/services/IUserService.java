package com.survey_app.survey_backend.application.services;

import java.util.List;

import com.survey_app.survey_backend.domain.entity.User;

public interface IUserService {
    List<User> findAll();
    User save(User user);
}
