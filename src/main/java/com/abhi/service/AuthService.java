package com.abhi.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.abhi.db.ResourceDao;
import com.abhi.model.Employee;


public class AuthService {

	ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");

//check whether the customer is already present or not 

	ResourceDao dao = (ResourceDao) ctx.getBean("daoBean");

	public boolean registerEmployee(Employee employee) {

		boolean result = dao.saveEmployee(employee);

		return result;

	}

	public Employee findEmployeeById(int employeeId) {

		return dao.retrieveEmployee(employeeId);

	}

	public boolean authenticate(int employeeId, String password) {

		Employee employee = new Employee(employeeId, null, password);

		Employee find = dao.loginEmployee(employee);

		if (find == null) {

			return false;

		} else {

			return true;

		}

	}

}