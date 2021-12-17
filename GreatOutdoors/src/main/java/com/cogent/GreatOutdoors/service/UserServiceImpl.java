package com.cogent.GreatOutdoors.service;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cogent.GreatOutdoors.dto.User;
import com.cogent.GreatOutdoors.repository.UserRepository;
import com.cogent.GreatOutdoors.security.service.JwtUserDetailsImpl;


@Service
public class UserServiceImpl implements UserService,UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public String addUser(User user) {
		// TODO Auto-generated method stub
		userRepository.save(user);
		return "User saved";
	}

	@Override
	public User getUserbyId(int id) {
		// TODO Auto-generated method stub
		User u1 = userRepository.getById(id);
		return u1;
	}

	@Override
	public String updateUser(int id, User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteUserById(int id) {
		// TODO Auto-generated method stub
		userRepository.deleteById(id);
		return "User deleted";
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		List<User> uList = new ArrayList<User>();
		uList = userRepository.findAll();
		return uList;
	}

	@Override
	public String deleteAllUsers() {
		// TODO Auto-generated method stub
		userRepository.deleteAll();
		return "Deleted all users";
	}

	@Override
	public User login(String email, String password) {
		// TODO Auto-generated method stub
		Optional<User> user = userRepository.findByEmail(email);
		User u1 = new User();
		if(user.isPresent())
			u1 = user.get();
		
		return u1;
	}

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = userRepository.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with email: " + email));
		return JwtUserDetailsImpl.build(user);
	}

	

}
