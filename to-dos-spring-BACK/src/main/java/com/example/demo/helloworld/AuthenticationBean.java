package com.example.demo.helloworld;

public class AuthenticationBean {
	
	private String message;
	
	public AuthenticationBean(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
