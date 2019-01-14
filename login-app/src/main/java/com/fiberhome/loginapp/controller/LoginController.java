package com.fiberhome.loginapp.controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.fiberhome.loginapp.model.LoginForm;
import com.fiberhome.loginapp.model.Response;

@RestController
public class LoginController {
	@PostMapping("/login")
	public Response loginValidation(@RequestBody LoginForm emp) {
		ResponseEntity<String> loginStatus = null;
		Response response = new Response();
		String filePath = "src/main/resources/login.txt";
		String username = emp.getUsername();
		String password = emp.getPassword();
		BufferedReader bufferedReader;
		try {
			bufferedReader = new BufferedReader(new FileReader(filePath));
			String line;
			boolean usernameExists = false;
			while ((line = bufferedReader.readLine()) != null) {
				String[] sArray = line.split(",");
				if (username.equals(sArray[0]) && password.equals(sArray[1])) {
					usernameExists = true;
					break;
				}
			}
			if (usernameExists) {
				System.out.println("Username exists");
				HttpStatus status = HttpStatus.OK;
				loginStatus = ResponseEntity.status(status).body("You  successfully login dear " + username);
			} else {
				System.out.println("Username Not exists");
				HttpStatus status = HttpStatus.NOT_FOUND;
				loginStatus = ResponseEntity.status(status).body("You are not authorised Mr." + username);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		response.setStatus(loginStatus);
		return response;

	}

}
