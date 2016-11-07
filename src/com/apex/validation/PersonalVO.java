package com.apex.validation;

import java.io.Serializable;

import javax.validation.constraints.Size;

public class PersonalVO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Size(min=3,max=20)
	private String firstName;
	@Size(min=3,max=20)
	private String middleName;
	@Size(min=3,max=20)
	private String lastName;
	
	
	public PersonalVO() {
		super();
	}
	public PersonalVO(String firstName, String middleName, String lastName) {
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	

}
