package com.fiberhome.loginapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.fiberhome.loginapp.model.Employee;


@Controller
public class HelloController {
	private static RestTemplate restTemplate = new RestTemplate();
	private static final String baseURL = "http://localhost:8082/employee/";

	@RequestMapping("/")
	public String login() {
		return "login";
	}
	@RequestMapping("/index")
	public String index() {
		return "index";
	}

	@PostMapping("/hello")
	public String sayHello(@RequestParam("name") String name, Model model) {
		model.addAttribute("name", name);
		return "hello";
	}

	@RequestMapping("/getEmp")
	public String getEmployeeInfo(Model model) {
		Employee employee = restTemplate.getForObject(baseURL, Employee.class);
		model.addAttribute(employee);
		System.out.println("" + employee.getName());
		return "employee";
	}

}
