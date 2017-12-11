package com.appdesign.dao.exceptions;

public class DAOException extends Exception {


	private static final long serialVersionUID = 1874548L;
	private String message;

	public DAOException() {
	}

	public DAOException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "DAOException [message=" + message + "]";
	}
}
