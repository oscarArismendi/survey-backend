package com.survey_app.survey_backend.domain.entity.dto;

import lombok.Data;


@Data
public class SurveyDTO {

    private String name;
    private String description;
    private String componentHtml;
    private String componentReact;

}
