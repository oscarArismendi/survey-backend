package com.survey_app.survey_backend.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "surveys")
@Getter @Setter
public class Survey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    
    @Column(name = "componenthtml", length = 20)
    private String componentHtml;
    
    @Column(name = "componentreact", length = 20)
    private String componentReact;
    
    @Column(columnDefinition = "TEXT")
    private String description;
    
    @Column(columnDefinition = "TEXT")
    private String name;
    
    @OneToMany(mappedBy = "survey")
    private List<Chapter> chapters;
    
    @OneToMany(mappedBy = "survey")
    private List<SurveyCategory> surveyCategories;
}
