package com.cts.hrms.entity;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class Employee {
	
	@Min(value = 1)
	private Integer id;
	@Size(min = 3, max = 10, message = "Minimum 3 and max 10")
	private String firstName;
	private String lastName;
	private Double salary;
	public Employee(Integer id, String firstName, String lastName, Double salary) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
	}
	
	public Employee() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
}
