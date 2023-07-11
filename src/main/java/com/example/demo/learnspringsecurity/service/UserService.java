package com.example.demo.learnspringsecurity.service;

import com.example.demo.learnspringsecurity.entity.Role;
import com.example.demo.learnspringsecurity.entity.UserTest;
import com.example.demo.learnspringsecurity.repository.RoleRepository;
import com.example.demo.learnspringsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public UserTest saveUser (UserTest userTest) {
        userTest.setPassword(passwordEncoder.encode(userTest.getPassword()));
        UserTest user = userRepository.save(userTest);
        return user;
    }

    public Role saveRole (Role role) {
        Role role1 = roleRepository.save(role);
        return role1;
    }

    public void addRoleToUser (String username, String roleName) {
        UserTest user = userRepository.findByEmail(username);
        Role role = roleRepository.findByName(roleName);
        user.getRoles().add(role);
        userRepository.save(user);
    }
}
