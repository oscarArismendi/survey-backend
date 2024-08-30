package com.survey_app.survey_backend.infrastructure.repositories.role;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.survey_app.survey_backend.domain.entity.Role;

public interface RoleRepository  extends CrudRepository<Role,Long>{
    Optional<Role> findByName(String name);
}
