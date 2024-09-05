package com.survey_app.survey_backend.domain.entity;

import java.sql.Timestamp;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "categories_catalog")
public class Category {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    private String name;

    @OneToMany(mappedBy = "category")
    private List<SurveyCategory> surveyCategories;

    @OneToMany(mappedBy = "category")
    private List<QuestionCategory> questionCategories;

    // Getters and Setters
}
