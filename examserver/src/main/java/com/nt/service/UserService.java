package com.nt.service;

import java.util.Set;

import com.nt.model.User;
import com.nt.model.UserRole;

public interface UserService {
	
	public User createUser(User user, Set<UserRole> userRoles) throws Exception;
	public User getUser(String username);
	public void deleteUser(Long userId);
	
}
