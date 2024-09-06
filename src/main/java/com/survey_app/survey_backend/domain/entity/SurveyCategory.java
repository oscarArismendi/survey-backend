package com.survey_app.survey_backend.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Entity
@Table(name = "survey_category")
@Getter @Setter
public class SurveyCategory {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    
    @ManyToOne
    @JoinColumn(name = "survey_id")
    private Survey survey;
    
    @OneToMany(mappedBy = "surveyCategory")
    private List<QuestionCategory> questionCategories;

}
