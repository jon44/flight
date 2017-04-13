package com.cooksys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.embeddable.Credentials;
import com.cooksys.service.UserService;
import com.cooksys.service.ValidateService;

@RestController
@RequestMapping("validate")
@CrossOrigin
public class ValidateController {
	
	@Autowired
	ValidateService validateService;
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/available/{username}", method = RequestMethod.GET)
	public Boolean getUsernameAvailable(@PathVariable String username) {
		return validateService.getUsernameAvailable(username);
	}
	
	@RequestMapping(value = "/exists/{username}", method = RequestMethod.GET)
	public Boolean getUsernameExists(@PathVariable String username) {
		return validateService.getUsernameExists(username);
	}
	
	@RequestMapping(value = "/valid", method = RequestMethod.POST)
	public Boolean getCredendtialsValid(@RequestBody Credentials credentials) {
		return userService.getCredentialsValid(credentials);
	}

}
