package com.w2m.superheroes.dto;

public class ResponseDTO<T> {

	private Boolean success;
	private String message;
	private T data;

	public ResponseDTO(Boolean success, String message, T data) {
		super();
		this.success = success;
		this.message = message;
		this.data = data;
	}
	public Boolean getSuccess(){
		return this.success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public String getMessage(){
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData(){
		return this.data;
	}

	public void setData(T data) {
		this.data = data;
	}
}