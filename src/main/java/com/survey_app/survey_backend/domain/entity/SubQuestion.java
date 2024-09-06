package com.survey_app.survey_backend.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;



@Entity
@Table(name = "sub_questions")
@Getter @Setter
public class SubQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    
    @Column(name = "subquestiontext", columnDefinition = "TEXT")
    private String subQuestionText;
    
    @ManyToOne
    @JoinColumn(name = "subquestion_id")
    private Question parentQuestion;
}   