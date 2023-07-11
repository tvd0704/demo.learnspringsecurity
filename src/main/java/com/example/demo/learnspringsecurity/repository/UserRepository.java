package com.example.demo.learnspringsecurity.repository;

import com.example.demo.learnspringsecurity.entity.UserTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserTest, Long> {

    public UserTest findByEmail (String username);
}
