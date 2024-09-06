package com.survey_app.survey_backend.infrastructure.repositories.role;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.survey_app.survey_backend.domain.entity.Role;

import java.util.List;

@Repository
public interface RoleRepository  extends CrudRepository<Role,Long>{
    Optional<Role> findByName(String name);
    
    @Query("SELECT r FROM Role r WHERE r.name IN :roleNames")
    List<Role> findRoleEntitiesByName(@Param("roleNames") List<String> roleNames);
}
