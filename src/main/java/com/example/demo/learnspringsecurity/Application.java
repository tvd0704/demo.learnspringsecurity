package com.example.demo.learnspringsecurity;

import com.example.demo.learnspringsecurity.entity.Role;
import com.example.demo.learnspringsecurity.entity.UserTest;
import com.example.demo.learnspringsecurity.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;

@SpringBootApplication
@EnableWebSecurity
@EnableJpaRepositories
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	BCryptPasswordEncoder bCryptPasswordEncoder () {
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner runner (UserService userService) {
		return args -> {
			userService.saveRole(new Role(null,"ROLE_USER"));
			userService.saveRole(new Role(null,"ROLE_MANAGER"));
			userService.saveRole(new Role(null,"ROLE_ADMIN"));
			userService.saveRole(new Role(null,"ROLE_SUPER_ADMIN"));

			userService.saveUser(new UserTest(null,"duc tran","tran van duc","duc@gmail.com","123456", new HashSet<>()));
			userService.saveUser(new UserTest(null,"tran duc","tran van duc","duc2@gmail.com","123456", new HashSet<>()));

			userService.addRoleToUser("duc@gmail.com","ROLE_USER");
			userService.addRoleToUser("duc@gmail.com", "ROLE_MANAGER");

			userService.addRoleToUser("duc@gmail.com","ROLE_ADMIN");
			userService.addRoleToUser("duc@gmail.com","ROLE_SUPER_ADMIN");





		};
	}

}
