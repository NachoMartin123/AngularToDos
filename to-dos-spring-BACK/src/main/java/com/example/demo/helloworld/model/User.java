package com.example.demo.helloworld.model;


import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id; 
	@Column(unique=true)
	private String username;
	@Column
	private String password;
	
	@OneToMany(mappedBy="user",cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<ToDo> toDos = new HashSet<ToDo>();
	
	
	public User() {}

	public User(Long id, String username, String password, Set<ToDo> toDos) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.toDos = toDos;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public Set<ToDo> getToDos() {
		return toDos;
	}
	public void setToDos(Set<ToDo> toDos) {
		this.toDos = toDos;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}

}
