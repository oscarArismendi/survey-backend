package com.survey_app.survey_backend.infrastructure.repositories.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.survey_app.survey_backend.application.services.IUserService;
import com.survey_app.survey_backend.domain.entity.Role;
import com.survey_app.survey_backend.domain.entity.UserEntity;
import com.survey_app.survey_backend.infrastructure.repositories.role.RoleRepository;

@Service
public class UserAdapter implements IUserService {
    @Autowired
    private UserRepository repository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional(readOnly = true)
    public List<UserEntity> findAll() {
        return (List<UserEntity>) repository.findAll();
    }

    @Override
    @Transactional
    public UserEntity save(UserEntity user) {
        Optional<Role> optionalRoleUser = roleRepository.findByName("ROLE_USER");
        List<Role> roles = new ArrayList<>();

        optionalRoleUser.ifPresent(roles::add);

        if (user.isAdmin()) {
            Optional<Role> optionalRoleAdmin = roleRepository.findByName("ROLE_ADMIN");
            optionalRoleAdmin.ifPresent(roles::add);
        }

        user.setRoles(roles);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return repository.save(user);
    }

}
