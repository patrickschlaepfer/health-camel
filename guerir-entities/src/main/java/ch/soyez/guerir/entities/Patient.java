package ch.soyez.guerir.entities;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Patient implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String lastName;
	private String firstName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Override
	public String toString() 
	{ 
	    return ToStringBuilder.reflectionToString(this); 
	}

}
