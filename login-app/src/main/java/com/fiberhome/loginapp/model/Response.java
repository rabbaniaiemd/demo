package com.fiberhome.loginapp.model;

import org.springframework.http.ResponseEntity;

public class Response {
	ResponseEntity<String>  status;

	public ResponseEntity<String> getStatus() {
		return status;
	}

	public void setStatus(ResponseEntity<String> status) {
		this.status = status;
	}
	

}
