package com.example.demo.helloworld.toDo;

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

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class ToDoJpaResource {
	
	@Autowired
	private ToDoJpaRepository toDoJpaRepository;
	
	@GetMapping("/jpa/users/{username}/toDos")
	public List<ToDo> getAllToDos(@PathVariable String username){
		return toDoJpaRepository.findByUsername(username);
	}
	
	@GetMapping("/jpa/users/{username}/toDos/{id}")
	public ToDo getToDo(@PathVariable String username, @PathVariable long id){
		return toDoJpaRepository.findById(id).get();
	}
	
	@DeleteMapping("/jpa/users/{username}/toDos/{id}")
	public ResponseEntity<Void> deleteToDo(@PathVariable String username, @PathVariable long id){
		toDoJpaRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/jpa/users/{username}/toDos/{id}")
	public ResponseEntity<ToDo> updateToDo(@PathVariable String username, @PathVariable long id, @RequestBody ToDo t){
		ToDo toDoUpdated = toDoJpaRepository.save(t);
		return new ResponseEntity<ToDo>(toDoUpdated, HttpStatus.OK);
	}
	
	@PostMapping("/jpa/users/{username}/toDos")
	public ResponseEntity<Void> createToDo(@PathVariable String username, @RequestBody ToDo t){
		
		t.setUsername(username);
		ToDo toDoCreated = toDoJpaRepository.save(t);
		
		//coge la url y le añade al final el {id}
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
			.buildAndExpand(toDoCreated.getId()).toUri();

		return ResponseEntity.created(uri).build();//returns uri of the created toDo
	}
	
	

}