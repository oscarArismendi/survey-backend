package com.survey_app.survey_backend.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "enabled")
    private boolean enabled;

    @Column(columnDefinition = "VARCHAR(12)", nullable = false)
    private String username;

    @Column(columnDefinition = "VARCHAR(255)", nullable = false)
    private String password;
}
