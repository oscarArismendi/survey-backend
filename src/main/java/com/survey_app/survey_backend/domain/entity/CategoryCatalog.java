package com.survey_app.survey_backend.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name = "categories_catalog")
@Getter @Setter
public class CategoryCatalog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    
    @Column(length = 255)
    private String name;
    
    @OneToMany(mappedBy = "categoryCatalog")
    private List<CategoryOption> categoryOptions;

    @OneToMany(mappedBy = "category")
    private List<SurveyCategory> surveyCategories;
}
