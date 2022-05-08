package com.example.diplomprojectmanagementprogramc51.mapper;

import com.example.diplomprojectmanagementprogramc51.dto.RegisteringUserDTO;
import com.example.diplomprojectmanagementprogramc51.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;

public class UserMapper {
    private static final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    @Autowired
    private static DepartmentService departmentService;

    public static User mapFromRegisteringUser(RegisteringUserDTO registeringUserDTO) {
        if (registeringUserDTO == null) {
            return null;
        } else {
            return User.builder()
                    .firstName(registeringUserDTO.getFirstName())
                    .lastName(registeringUserDTO.getLastName())
                    .username(registeringUserDTO.getUsername())
                    .email(registeringUserDTO.getEmail())
                    .roles(new HashSet<>())
                    .password(bCryptPasswordEncoder.encode(registeringUserDTO.getPassword()))
//                    .department(departmentService.findByName(registeringUserDTO.getDepartment()).get())
                    .build();
        }
    }
}
