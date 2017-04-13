package com.cooksys.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooksys.entity.User;
import com.cooksys.repository.UserRepository;

@Service
public class ValidateService {
	
	@Autowired
	UserRepository userRepository;

	public Boolean getUsernameAvailable(String username) {
		User user = userRepository.findByCredentialsUsername(username);
		if(user == null) {
			return true;
		}
		
		return false;
	}

	public Boolean getUsernameExists(String username) {
		User user = userRepository.findByCredentialsUsername(username);
		if(user != null && user.getDeleted() != true) {
			return true;
		}
		
		return false;
	}

}
