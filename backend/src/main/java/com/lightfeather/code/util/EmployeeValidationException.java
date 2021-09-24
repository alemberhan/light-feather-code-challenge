package com.lightfeather.code.util;

public class EmployeeValidationException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EmployeeValidationException() {
		super("First Name, Last Name and Supervisor are required.");
	}
}
