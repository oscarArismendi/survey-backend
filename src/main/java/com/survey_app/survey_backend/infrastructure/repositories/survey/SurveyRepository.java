package com.survey_app.survey_backend.infrastructure.repositories.survey;


import com.survey_app.survey_backend.domain.entity.Survey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyRepository  extends JpaRepository<Survey, Long>{

}
