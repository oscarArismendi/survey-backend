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
@Table(name = "questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    private String questionNumber;
    private String responseType;
    private String commentQuestion;
    private String questionText;

    @OneToMany(mappedBy = "question")
    private List<SubQuestion> subQuestions;

    @OneToMany(mappedBy = "question")
    private List<QuestionChapter> questionChapters;

    // Getters and Setters

}
