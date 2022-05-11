package com.example.diplomprojectmanagementprogramc51.mapper;

import com.example.diplomprojectmanagementprogramc51.dto.RegisteringUserDTO;
import com.example.diplomprojectmanagementprogramc51.dto.TaskDTO;
import com.example.diplomprojectmanagementprogramc51.dto.UserDTO;
import com.example.diplomprojectmanagementprogramc51.entity.Task;
import com.example.diplomprojectmanagementprogramc51.entity.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {
    private static final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();


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
                    .build();
        }
    }

public static UserDTO mapFromUserToUserDto(User user){
    UserDTO userDTO = new UserDTO();
    userDTO.setUsername(user.getUsername());
    return userDTO;
}

    public static List<UserDTO> mapFromUserDTOListFromUsers(List<User> userList) {
        if (userList == null || userList.isEmpty()) {
            return null;
        } else {
            return userList.stream()
                    .map(UserMapper::mapFromUserToUserDto)
                    .collect(Collectors.toList());
        }
    }
}
