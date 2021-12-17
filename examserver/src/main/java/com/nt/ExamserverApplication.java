package com.nt;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nt.model.Role;
import com.nt.model.User;
import com.nt.model.UserRole;
import com.nt.service.UserService;

@SpringBootApplication
public class ExamserverApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;
	
	public static void main(String[] args) {
		SpringApplication.run(ExamserverApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception{
		System.out.println("Code started");
		
//		User user=new User();
//		user.setFirstName("David");
//		user.setLastName("Beckham");
//		user.setUsername("david12");
//		user.setPassword("d@avid");
//		user.setEmail("david12@gmail.com");
//		user.setProfile("default.png");
//		
//		Role role = new Role();
//		role.setRoleId(43L);
//		role.setRoleName("ADMIN");
//		
//		Set<UserRole> userRoleSet=new HashSet<UserRole>();
//		UserRole userRole = new UserRole();
//		userRole.setRole(role);
//		userRole.setUser(user);
//		userRoleSet.add(userRole);
//		
//		User user1 = this.userService.createUser(user, userRoleSet);
//		System.out.println(user1.getUsername());
	}

}
