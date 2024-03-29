package com.example.demo.helloworld.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.helloworld.model.User;

@Repository
public interface UserJpaRepository extends JpaRepository<User, Long>{

	User findByUsername(String username);
	
}
