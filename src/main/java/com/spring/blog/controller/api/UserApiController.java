package com.spring.blog.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.blog.dto.ResponseDto;
import com.spring.blog.model.RoleType;
import com.spring.blog.model.User;
import com.spring.blog.service.UserService;

@RestController
public class UserApiController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/api/user")
	public ResponseDto<Integer> save(@RequestBody User user) {
		System.out.println("UserApiController: save called");
		
		user.setRole(RoleType.USER);
		userService.signup(user);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	}
}
