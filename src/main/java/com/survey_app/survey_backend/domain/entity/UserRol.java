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
public class UserRol {
    @EmbeddedId
    private UserRolPk id;

    @ManyToOne
    @JoinColumn(name = "rol_id", insertable = false, updatable = false)
    private Rol roles;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User users;

}
