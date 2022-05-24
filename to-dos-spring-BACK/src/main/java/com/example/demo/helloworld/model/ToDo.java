package com.example.demo.helloworld.model;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ToDo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id; 
	@Column
	private String description;
	@Column
	private Date targetDate;
	@Column
	private boolean isDone;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
    private User user;
	
	
	public ToDo() {}
	
	public ToDo(Long id, String description, Date targetDate, boolean isDone, User user) {
		super();
		this.id = id;
		this.description = description;
		this.targetDate = targetDate;
		this.isDone = isDone;
		this.user = user;
	}
	
	

	public ToDo(String description, Date targetDate, boolean isDone) {
		super();
		this.description = description;
		this.targetDate = targetDate;
		this.isDone = isDone;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getTargetDate() {
		return targetDate;
	}
	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}
	public boolean isDone() {
		return isDone;
	}
	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
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
		ToDo other = (ToDo) obj;
		return id == other.id;
	}
	
	

}
