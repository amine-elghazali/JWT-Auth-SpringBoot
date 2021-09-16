package com.jwtDemo.userservice;

import com.jwtDemo.userservice.Entity.Role;
import com.jwtDemo.userservice.Entity.User;
import com.jwtDemo.userservice.Service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class UserserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserserviceApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(UserService userService){
		return args -> {
			userService.saveRole(new Role(null,"ROLE_USER"));
			userService.saveRole(new Role(null,"ROLE_ADMIN"));
			userService.saveRole(new Role(null,"ROLE_MANAGER"));
			userService.saveRole(new Role(null,"ROLE_SUPER_ADMIN"));

			userService.saveUser(new User(null,"AMINE1","AMINE11","123456789",new ArrayList<>()));
			userService.saveUser(new User(null,"AMINE2","AMINE22","123456789",new ArrayList<>()));
			userService.saveUser(new User(null,"AMINE3","AMINE33","123456789",new ArrayList<>()));
			userService.saveUser(new User(null,"AMINE4","AMINE44","123456789",new ArrayList<>()));
			userService.saveUser(new User(null,"AMINE5","AMINE55","123456789",new ArrayList<>()));

			userService.addRoleToUser("AMINE11","ROLE_USER");
			userService.addRoleToUser("AMINE11","ROLE_MANAGER");

			userService.addRoleToUser("AMINE22","ROLE_MANAGER");

			userService.addRoleToUser("AMINE33","ROLE_ADMIN");

			userService.addRoleToUser("AMINE44","ROLE_ADMIN");
			userService.addRoleToUser("AMINE44","ROLE_MANAGER");
			userService.addRoleToUser("AMINE44","ROLE_SUPER_ADMIN");


			userService.addRoleToUser("AMINE55","ROLE_ADMIN");
			userService.addRoleToUser("AMINE55","ROLE_MANAGER");
			userService.addRoleToUser("AMINE55","ROLE_SUPER_ADMIN");
			userService.addRoleToUser("AMINE55","ROLE_USER");

		};
	}

}
