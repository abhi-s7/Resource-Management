package com.abhi.model;

public class Employee {

	int employeeId;

	String employeeName;

	String password;

	public Employee() {

		super();

	}

	public Employee(int employeeId, String employeeName, String password) {

		super();

		this.employeeId = employeeId;

		this.employeeName = employeeName;

		this.password = password;

	}

	public int getEmployeeId() {

		return employeeId;

	}

	public void setEmployeeId(int employeeId) {

		this.employeeId = employeeId;

	}

	public String getEmployeeName() {

		return employeeName;

	}

	public void setEmployeeName(String employeeName) {

		this.employeeName = employeeName;

	}

	public String getPassword() {

		return password;

	}

	public void setPassword(String password) {

		this.password = password;

	}

	@Override

	public String toString() {

		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", password=" + password + "]";

	}

}