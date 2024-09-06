package com.survey_app.survey_backend.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "questions")
@Getter @Setter
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    
    @Column(name = "question_number", length = 10)
    private String questionNumber;
    
    @Column(name = "response_type", length = 10)
    private String responseType;
    
    @Column(name = "comment_question", columnDefinition = "TEXT")
    private String commentQuestion;
    
    @Column(name = "question_text", columnDefinition = "TEXT")
    private String questionText;
    
    @OneToMany(mappedBy = "question")
    private List<QuestionChapter> questionChapters;
    
    @OneToMany(mappedBy = "question")
    private List<OptionQuestion> optionQuestions;
    
    @OneToMany(mappedBy = "question")
    private List<QuestionCategory> questionCategories;
}