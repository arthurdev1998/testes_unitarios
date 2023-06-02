package com.arthur.testes.exceptions;

import java.util.Date;
import java.util.Objects;


public class ExceptionResponse {
	
	private Date dateTime;
	private String message;
	private String details;
	private Integer error;
	
	
	
	
	
	
	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
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

	public Integer getError() {
		return error;
	}

	public void setError(Integer error) {
		this.error = error;
	}

	public ExceptionResponse(Date dateTime, String message, String details, Integer error) {
		
		this.dateTime = dateTime;
		this.message = message;
		this.details = details;
		this.error = error;
	}

	public ExceptionResponse() {
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(dateTime, details, error, message);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExceptionResponse other = (ExceptionResponse) obj;
		return Objects.equals(dateTime, other.dateTime) && Objects.equals(details, other.details)
				&& Objects.equals(error, other.error) && Objects.equals(message, other.message);
	}
	

}
