package com.example.demo.helloworld.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.helloworld.model.ToDo;
import com.example.demo.helloworld.model.User;
import com.example.demo.helloworld.repository.ToDoJpaRepository;
import com.example.demo.helloworld.repository.UserJpaRepository;
import com.example.demo.helloworld.service.impl.ToDoServiceImpl;
import com.example.demo.helloworld.service.impl.UserServiceImpl;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class UserJpaController {
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@PostMapping("/jpa/users/{username}")
	public ResponseEntity<Void> createToDo(@PathVariable String username, @RequestBody User u){
//		
		User userCreated = userServiceImpl.save(u);
//		
//		//coge la url y le añade al final el {id}
////		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
////			.buildAndExpand(toDoCreated.getId()).toUri();
//
//		return ResponseEntity.created(uri).build();
		return null;
	}

}
