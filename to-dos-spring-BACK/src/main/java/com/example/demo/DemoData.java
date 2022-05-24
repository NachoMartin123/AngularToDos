package com.example.demo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.example.demo.helloworld.model.ToDo;
import com.example.demo.helloworld.model.User;
import com.example.demo.helloworld.service.impl.UserServiceImpl;
import com.example.demo.util.Link;

@Component
public class DemoData {

	@Autowired
	private static UserServiceImpl userServiceImpl;

    @EventListener
    public void appReady(ApplicationReadyEvent event) {
//		User user1 = new User();
//		user1.setUsername("user1");
//		user1.setPassword("user1");
//		
//		ToDo t1_1 = new ToDo("Learn thing 1_1", new Date(), false);
//		ToDo t1_2 = new ToDo("Learn thing 1_2", new Date(), false);
//		ToDo t1_3 = new ToDo("Learn thing 1_3", new Date(), false);
//		ToDo t1_4 = new ToDo("Learn thing 1_4", new Date(), false);
//		
//		Link.linkToDoUSer(user1, t1_1);
//		Link.linkToDoUSer(user1, t1_2);
//		Link.linkToDoUSer(user1, t1_3);
//		Link.linkToDoUSer(user1, t1_4);
//		
//		userServiceImpl.save(user1);
//		
//		
//		User user2 = new User();
//		user1.setUsername("user1");
//		user1.setPassword("user1");
//		
//		ToDo t2_1 = new ToDo("Learn thing 2_1", new Date(), false);
//		ToDo t2_2 = new ToDo("Learn thing 2_2", new Date(), false);
//		ToDo t2_3 = new ToDo("Learn thing 2_3", new Date(), false);
//		ToDo t2_4 = new ToDo("Learn thing 2_4", new Date(), false);
//		
//		Link.linkToDoUSer(user2, t2_1);
//		Link.linkToDoUSer(user2, t2_2);
//		Link.linkToDoUSer(user2, t2_3);
//		Link.linkToDoUSer(user2, t2_4);
//		
//		userServiceImpl.save(user2);
    }
}