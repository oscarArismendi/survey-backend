package com.survey_app.survey_backend.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name = "chapters")
@Getter @Setter
public class Chapter {
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
    
    @Column(name = "chapter_number", length = 50)
    private String chapterNumber;
    
    @Column(name = "chapter_title", length = 50)
    private String chapterTitle;
    
    @ManyToOne
    @JoinColumn(name = "survey_id")
    private Survey survey;
    
    @OneToMany(mappedBy = "chapter")
    private List<QuestionChapter> questionChapters;
}
