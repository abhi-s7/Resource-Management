package com.abhi.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.abhi.model.Employee;
import com.abhi.service.AuthService;

@Controller

@SessionAttributes("employeeId-session")

public class LoginAndRegisterController {

	AuthService service = new AuthService();

	private static List<Integer> revokedTokens = new ArrayList<>();

	@RequestMapping(value = "/", method = RequestMethod.GET)

	public ModelAndView showLoginPage1(HttpSession session) {

		if (null != session && null != session.getAttribute("employeeId-session")
				&& !revokedTokens.contains(session.getAttribute("employeeId-session"))) {

			System.out.println("Session is " + session.getAttribute("employeeId-session"));

			return new ModelAndView("home");

		}

		System.out.println("Session is " + session.getAttribute("employeeId-session"));

		return new ModelAndView("login");

	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)

	public String showLoginPage() {

		return "login";// this sends the request to the login page

	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)

	public ModelAndView performLogin(HttpSession session, @RequestParam("employeeId") int employeeId,
			@RequestParam("password") String password, Model model) {

		boolean authenticate = service.authenticate(employeeId, password);

		if (!authenticate) {

// employee not present 

			model.addAttribute("msg", "User not present. Register first...");

			return new ModelAndView("login");

		}

//check if the id present in revokedList , if present then remove it 

		Employee employee = service.findEmployeeById(employeeId);

		int index = revokedTokens.indexOf(employee.getEmployeeId());

//if index = -1 then the token doesn't exist 

		if (index != -1) {

//otherwise employeeId exist 

			revokedTokens.remove(index);

		}

		model.addAttribute("employeeId-session", employee.getEmployeeId());

		return new ModelAndView("redirect:home");// this sends the request to the login page

	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)

	public ModelAndView showHome(Model model) {
		model.addAttribute("msg", "Welcome to Resource Management Tool");
		return new ModelAndView("home");

	}

	@RequestMapping(value = "/table", method = RequestMethod.GET)

	public ModelAndView showTable() {

		return new ModelAndView("table");

	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)

	public String showRegister() {

		return "register";// this sends the request to the login page

	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)

	public ModelAndView performRegistration(@RequestParam("employeeId") int employeeId,
			@RequestParam("empName") String empName, @RequestParam("password") String password,

			@RequestParam("confirmPassword") String confirmPassword, Model model) {

// Step 1 - To check both the password matches 

		if (!password.equals(confirmPassword)) {

			model.addAttribute("msg", "Password didn't matched");

			return new ModelAndView("register");

		}

// Step 2 - Check whether the Employee is present in repository or not 

		Employee employee = service.findEmployeeById(employeeId);

		if (employee != null) {

//i.e. user already present  

			model.addAttribute("error_msg", "User already present");

			return new ModelAndView("register");

		}

// if the code get here this means the customer is null 

		employee = new Employee(employeeId, empName, password);

		boolean result = service.registerEmployee(employee);

		System.out.println("Result is *********" + result);

		if (!result) {

			model.addAttribute("error_msg", "Something went wrong. Try Again");

			return new ModelAndView("register");

		}

		return new ModelAndView("login");

	}

	@RequestMapping(path = "/logout", method = RequestMethod.POST)

	public ModelAndView getLogout(HttpSession session) throws Exception {

		if (session != null) {

			if (session.getAttribute("employeeId-session") != null) {

				revokedTokens.add((Integer) session.getAttribute("employeeId-session"));

				session.removeAttribute("employeeId-session");

				session.invalidate();

			}

			return new ModelAndView("login");

		}

		return new ModelAndView("login");

	}

}