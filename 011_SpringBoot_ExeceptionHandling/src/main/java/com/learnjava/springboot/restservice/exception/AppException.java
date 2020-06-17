package com.learnjava.springboot.restservice.exception;

public class AppException extends  RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AppException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AppException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public AppException(String message,int errorcode) {
		super(message);
		// TODO Auto-generated constructor stub
	}
		
	

}
