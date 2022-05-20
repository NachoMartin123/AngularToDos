package com.example.demo.helloworld.toDo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import org.springframework.stereotype.Service;

@Service
public class ToDoHardcodedService {
	
	private static List<ToDo> toDos = new ArrayList();
	private static Long idCounter=(long) 0;
	
	
	static {
		toDos.add(new ToDo(++idCounter, "hola", "Learn to dance", new Date(), false));
		toDos.add(new ToDo(++idCounter, "hola", "Learn Microservices", new Date(), false));
		toDos.add(new ToDo(++idCounter, "hola", "Go to supermarket", new Date(), false));
	}
	
	public List<ToDo> findAll(){
		return toDos;
	}
	
	public ToDo deleteById(long id) {
		ToDo t = findById(id);
		if(t==null)
			return null;
		if(toDos.remove(t))
			return t;
		return null;
	}

	public ToDo findById(long id) {
		for(ToDo t : toDos) {
			if(t.getId()==id)
				return t;
		}
		return null;
	}

	public ToDo save(ToDo toDo) {
		if(toDo.getId()==-1 || toDo.getId()==-0) {
			toDo.setId(idCounter++);
			toDos.add(toDo);
		}else {
			deleteById(toDo.getId());
			toDos.add(toDo);
		}
		return toDo; 
	}
}
