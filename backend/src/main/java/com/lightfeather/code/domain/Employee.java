package com.lightfeather.code.domain;

public class Employee {

	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private boolean notifyByEmail;
	private boolean notifyByPhone;
	private String supervisor;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public boolean isNotifyByEmail() {
		return notifyByEmail;
	}

	public void setNotifyByEmail(boolean notifyByEmail) {
		this.notifyByEmail = notifyByEmail;
	}

	public boolean isNotifyByPhone() {
		return notifyByPhone;
	}

	public void setNotifyByPhone(boolean notifyByPhone) {
		this.notifyByPhone = notifyByPhone;
	}

	public String getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}

	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", phone=" + phone
				+ ", supervisor=" + supervisor + "]";
	}

	
}
