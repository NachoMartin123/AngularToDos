package com.example.demo.helloworld.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.helloworld.model.User;
import com.example.demo.helloworld.repository.UserJpaRepository;


@Service
public class UserServiceImpl {
	
	@Autowired
	private UserJpaRepository userJpaRepository;

	public User findByUsername(String username) {
		return userJpaRepository.findByUsername(username);
	}

	public User save(User u) {
		return userJpaRepository.save(u);
	}

}
