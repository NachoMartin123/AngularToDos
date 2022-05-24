package com.example.demo.util;

import com.example.demo.helloworld.model.ToDo;
import com.example.demo.helloworld.model.User;

public class Link {
	
	public static void linkToDoUSer(User u, ToDo t) {
		u.getToDos().add(t);
		t.setUser(u);
	}

}
