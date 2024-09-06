package com.survey_app.survey_backend.application.services;

import com.survey_app.survey_backend.domain.entity.Survey;
import com.survey_app.survey_backend.domain.entity.dto.SurveyDTO;
import com.survey_app.survey_backend.infrastructure.repositories.survey.SurveyRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class SurveyService {

     private final SurveyRepository surveyRepository;

    public SurveyService(SurveyRepository surveyRepository) {
        this.surveyRepository = surveyRepository;
    }

    public Survey createSurvey(SurveyDTO surveyDTO) {
        Survey survey = new Survey();
        survey.setName(surveyDTO.getName());
        survey.setDescription(surveyDTO.getDescription());
        survey.setComponentHtml(surveyDTO.getComponentHtml());
        survey.setComponentReact(surveyDTO.getComponentReact());
        survey.setCreatedAt(LocalDateTime.now());
        survey.setUpdatedAt(LocalDateTime.now());

        return surveyRepository.save(survey);
    }
}
