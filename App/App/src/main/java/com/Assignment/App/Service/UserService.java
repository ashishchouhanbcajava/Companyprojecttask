package com.Assignment.App.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Assignment.App.Model.User;
import com.Assignment.App.Repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User saveUser(User user) {
		return userRepository.save(user);

	}

	public List<User> getAll() {
		return userRepository.findAll();
	}

	

	public User getById(Long id) {
		return userRepository.findById(id).get();
	}
}
