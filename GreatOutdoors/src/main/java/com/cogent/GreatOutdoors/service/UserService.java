package com.cogent.GreatOutdoors.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.cogent.GreatOutdoors.dto.User;

public interface UserService {
	public String addUser(User user);
	public User getUserbyId(int id);
	public String updateUser(int id, User user);
	public String deleteUserById(int id);
	public List<User> getAllUsers();
	public String deleteAllUsers();
	public User login(String email, String password);
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException;
}
