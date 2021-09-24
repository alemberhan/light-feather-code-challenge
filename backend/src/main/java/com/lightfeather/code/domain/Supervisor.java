package com.lightfeather.code.domain;

import java.util.Comparator;

public class Supervisor implements Comparable<Supervisor> {
	private Long id;
	private String phone;
	private String jurisdiction;
	private String identificationNumber;
	private String firstName;
	private String lastName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getJurisdiction() {
		return jurisdiction;
	}

	public void setJurisdiction(String jurisdiction) {
		this.jurisdiction = jurisdiction;
	}

	public String getIdentificationNumber() {
		return identificationNumber;
	}

	public void setIdentificationNumber(String identificationNumber) {
		this.identificationNumber = identificationNumber;
	}

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

	@Override
	public String toString() {
		return this.jurisdiction + " - " + this.lastName + ", " + this.firstName;
	}

	@Override
	public int compareTo(Supervisor o) {
		return Comparator.comparing(Supervisor::getJurisdiction).thenComparing(Supervisor::getLastName)
				.thenComparing(Supervisor::getFirstName).compare(this, o);
	}

}
