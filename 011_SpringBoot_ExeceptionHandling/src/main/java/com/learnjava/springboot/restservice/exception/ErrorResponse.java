package com.learnjava.springboot.restservice.exception;

public class ErrorResponse {
	
	
	private String hhtpStatus;
	private String errorCode;
	
	private String errorMsg;

	

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getHhtpStatus() {
		return hhtpStatus;
	}

	public void setHhtpStatus(String hhtpStatus) {
		this.hhtpStatus = hhtpStatus;
	}
	

}
