package com.survey_app.survey_backend.domain.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "users_roles")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class UserRole {
    @EmbeddedId
    private UserRolePk id;

    @ManyToOne
    @JoinColumn(name = "role_id", insertable = false, updatable = false)
    private Role roles;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User users;

}
