package com.abhi.db;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.abhi.model.Employee;

public class EmployeeRowMapper implements RowMapper<Employee> {

	public Employee mapRow(ResultSet rs, int rn) throws SQLException {

		Employee employee = new Employee();

		employee.setEmployeeId(rs.getInt(1));

		employee.setEmployeeName(rs.getString(2));

		employee.setPassword(rs.getString(3));

		return employee;

	}

}
