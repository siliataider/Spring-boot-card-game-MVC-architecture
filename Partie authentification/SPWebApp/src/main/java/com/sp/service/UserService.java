package com.sp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.model.Hero;
import com.sp.model.User;
import com.sp.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository uRepository;
	public void addUser(User user) {
		User createdUser=uRepository.save(user);
		System.out.println(createdUser);
	}
	
	public User getUser(int id) {
		Optional<User> uOpt =uRepository.findById(id);
		if (uOpt.isPresent()) {
			return uOpt.get();
		}else {
			return null;
		}
	}

}


