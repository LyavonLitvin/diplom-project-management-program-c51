package com.example.diplomprojectmanagementprogramc51.service;

import com.example.diplomprojectmanagementprogramc51.entity.Role;
import com.example.diplomprojectmanagementprogramc51.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    private RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Role> findAll() {
        return roleRepository.findAll();
    }
}
