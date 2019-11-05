package com.org.adp.onlinecart.utils;

public enum ErrorCodes {
	
	CUSTOMER_ALREADY_EXISTS(100,"Customer with that ID Already Exists"),
	CUSTOMER_DOESNOT_EXISTS(101,"Customer does not exists"),
	PRODUCT_CATEGORY_ALREADY_EXISTS(200,"Product Category with that ID Already Exists"),
	PRODUCT_CATEGORY_DOESNOT_EXISTS(201,"Product Category does not exists"),
	PRODUCT_ALREADY_EXISTS(300,"Product with that ID Already Exists"),
	PRODUCT_DOESNOT_EXISTS(301,"Product does not exists");
	private int errorCode;
	private String message;
	
	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	private ErrorCodes(int erroCode, String message){
		this.errorCode = erroCode;
		this.message = message;
	}
	
	public String toString(){
		return ""+this.errorCode+ " : "+this.message;
	}
}
