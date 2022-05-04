package com.example.diplomprojectmanagementprogramc51.service;

import com.example.diplomprojectmanagementprogramc51.dto.RegisteringUserDTO;
import com.example.diplomprojectmanagementprogramc51.entity.Role;
import com.example.diplomprojectmanagementprogramc51.entity.User;
import com.example.diplomprojectmanagementprogramc51.enums.RoleName;
import com.example.diplomprojectmanagementprogramc51.mapper.UserMapper;
import com.example.diplomprojectmanagementprogramc51.repository.RoleRepository;
import com.example.diplomprojectmanagementprogramc51.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@Transactional
public class UserService implements UserDetailsService {


    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserService(UserRepository userRepository,
                       RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public boolean registration(RegisteringUserDTO registeringUserDTO) {
        User user = UserMapper.mapFromRegisteringUser(registeringUserDTO);
        if (existByUsername(user.getUsername())) {
            return false;
        } else {
            Optional<Role> roleUser = roleRepository.findByName(RoleName.USER.name());
            user.addRole(roleUser.get());
            userRepository.save(user);
            return true;

            //log.info("IN register - user: {} successfully registered");
        }
    }

    public boolean existByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    public boolean existByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    public String getAuthenticationUserName() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

    public User findByUsername(String username) {
        User byUsername = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User with username: " + username + " not found"));
        return byUsername;
    }

//    public boolean deleteUser(User user) {
//        User deleted = userRepository.delete(user);
//        if
//        log.info("IN deleteUser - user: {} successfully deleted", deleted);
//        return true;
//    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new UsernameNotFoundException("User with this username doesn't exist!");
        }
    }

    public String getCurrentUsername() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getName();
    }

    public User getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return userRepository.findByUsername(auth.getName()).get();
    }

    public Optional<User> findById(long id){
        return userRepository.findById(id);
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }
}
