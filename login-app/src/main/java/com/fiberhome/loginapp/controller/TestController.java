package com.fiberhome.loginapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.fiberhome.loginapp.model.Employee;


@RestController
public class TestController {

	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public ResponseEntity<String> firstPage() {
		ResponseEntity<String> loginStatus = null;
		Employee emp = new Employee();
		emp.setName("emp1");
		emp.setDesignation("manager");
		emp.setEmpId("1");
		emp.setSalary(3000);
		if (emp.getEmpId().equals("2")) {
			HttpStatus status = HttpStatus.OK;
			loginStatus = ResponseEntity.status(status).body("you  successfully login dear" + emp.getName());
		} else {
			HttpStatus status = HttpStatus.NOT_FOUND;

			loginStatus = ResponseEntity.status(status).body("sorry your credential not found: Mr " + "  " + emp.getName());

		}

		return loginStatus;

	}

}