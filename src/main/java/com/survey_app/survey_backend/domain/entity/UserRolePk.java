package com.survey_app.survey_backend.domain.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
public class UserRolePk implements Serializable {
    @Column(name = "role_id")
    private Long rol;

    @Column(name = "user_id")
    private Long user;
}
