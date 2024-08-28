package com.survey_app.survey_backend.domain.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class Audit {
    @Column(name = "create_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist

    public void prePersistAudit() {
        createdAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdateAudit() {
        updatedAt = LocalDateTime.now();
    }
}
