package com.survey_app.survey_backend.infrastructure.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.survey_app.survey_backend.application.services.SurveyService;
import com.survey_app.survey_backend.domain.entity.Survey;
import com.survey_app.survey_backend.domain.entity.dto.SurveyDTO;

@RestController
@RequestMapping("/surveys")
public class SurveyController {

     private final SurveyService surveyService;

    @Autowired
    public SurveyController(SurveyService surveyService) {
        this.surveyService = surveyService;
    }

    @PostMapping("/create")
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Survey> createSurvey(@RequestBody SurveyDTO surveyDTO) {
        Survey createdSurvey = surveyService.createSurvey(surveyDTO);
        return new ResponseEntity<>(createdSurvey, HttpStatus.CREATED);
    }

}
