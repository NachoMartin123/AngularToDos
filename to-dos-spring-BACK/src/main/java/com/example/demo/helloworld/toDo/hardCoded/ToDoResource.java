package com.example.demo.helloworld.toDo.hardCoded;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.helloworld.toDo.ToDo;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class ToDoResource {
	
	@Autowired
	private ToDoHardcodedService todoService;
	
	@GetMapping("/users/{username}/toDos")
	public List<ToDo> getAllToDos(@PathVariable String username){
		return todoService.findAll();
	}
	
	@DeleteMapping("/users/{username}/toDos/{id}")
	public ResponseEntity<Void> deleteToDo(@PathVariable String username, 
			@PathVariable long id){
		ToDo t = todoService.deleteById(id);
		if(t!=null)
			return ResponseEntity.noContent().build();
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/users/{username}/toDos/{id}")
	public ToDo getToDo(@PathVariable String username, @PathVariable long id){
		return todoService.findById(id);
	}
	
	@PutMapping("/users/{username}/toDos/{id}")
	public ResponseEntity<ToDo> updateToDo(@PathVariable String username, 
			@PathVariable long id, @RequestBody ToDo t){
		ToDo toDoUpdated = todoService.save(t);
		if(t!=null)
			return ResponseEntity.noContent().build();
		return new ResponseEntity<ToDo>(toDoUpdated, HttpStatus.OK);
	}
	
	@PostMapping("/users/{username}/toDos")
	public ResponseEntity<Void> updateToDo(@PathVariable String username, @RequestBody ToDo t){
		
		ToDo toDoCreated = todoService.save(t);
		
		//coge la url y le añade al final el {id}
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
			.buildAndExpand(toDoCreated.getId()).toUri();

		return ResponseEntity.created(uri).build();//returns uri of the created toDo
	}
	
	

}
