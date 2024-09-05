package com.survey_app.survey_backend.domain.entity;

import java.security.Timestamp;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "surveys")
public class Survey {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @Column(name = "component_html")
    private String componentHtml;

    @Column(name = "component_react")
    private String componentReact;

    private String description;
    private String name;

    @OneToMany(mappedBy = "survey")
    private List<Chapter> chapters;

    @OneToMany(mappedBy = "survey")
    private List<SurveyCategory> surveyCategories;

    // Getters and Setters
}
