package com.bhawnagunwani.SpringBootDemo.exceptions;

import java.time.LocalDateTime;

public class ErrorResponse {
	
	private LocalDateTime timestap;
	private String message;
	private String details;
	private int status;
	
	public ErrorResponse(LocalDateTime timestap, String message, String details, int status) {
		super();
		this.timestap = timestap;
		this.message = message;
		this.details = details;
		this.status = status;
	}

	public LocalDateTime getTimestap() {
		return timestap;
	}

	public void setTimestap(LocalDateTime timestap) {
		this.timestap = timestap;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	
	

}
