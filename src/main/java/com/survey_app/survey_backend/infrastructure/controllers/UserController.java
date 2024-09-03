package com.survey_app.survey_backend.infrastructure.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import com.survey_app.survey_backend.application.services.IUserService;
import com.survey_app.survey_backend.application.services.UserDetailServiceImpl;
import com.survey_app.survey_backend.domain.entity.UserEntity;
import com.survey_app.survey_backend.infrastructure.controllers.dto.AuthCreateUserRequest;
import com.survey_app.survey_backend.infrastructure.controllers.dto.AuthLoginRequest;
import com.survey_app.survey_backend.infrastructure.controllers.dto.AuthResponse;



@RestController
@RequestMapping("/users")
public class UserController {
    
    @Autowired
    private IUserService service;

    @Autowired
    private UserDetailServiceImpl userDetailService;

    @GetMapping("/list-all")
    public List<UserEntity> list() {
        return service.findAll();
    }

    @PostMapping("/sign-up")
    public ResponseEntity<AuthResponse> register(@RequestBody @Valid AuthCreateUserRequest userRequest){
        return new ResponseEntity<>(this.userDetailService.createUser(userRequest), HttpStatus.CREATED);
    }
    
    @PostMapping("/log-in")
    public ResponseEntity<AuthResponse> login(@RequestBody @Valid AuthLoginRequest userRequest){
        return new ResponseEntity<>(this.userDetailService.loginUser(userRequest), HttpStatus.OK);
    }

}
