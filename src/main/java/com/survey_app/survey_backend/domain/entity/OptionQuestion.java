package com.survey_app.survey_backend.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Table(name = "option_questions")
@Getter @Setter
public class OptionQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    
    @ManyToOne
    @JoinColumn(name = "option_id")
    private Option option;
    
    @ManyToOne
    @JoinColumn(name = "optionquestion_id")
    private Question question;
    
    @ManyToOne
    @JoinColumn(name = "subquestion_id")
    private SubQuestion subQuestion;
}
