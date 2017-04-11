package com.cooksys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.dto.UserDto;
import com.cooksys.dto.UserRequestDto;
import com.cooksys.service.UserService;

@RestController
@RequestMapping("users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(method = RequestMethod.POST)
	public UserDto postUser(@RequestBody UserRequestDto userRequestDto) {
		return userService.postUser(userRequestDto);
	}
	
	@RequestMapping(value = "/{username}", method = RequestMethod.GET)
	public UserDto getUser(@PathVariable String username) {
		return userService.getUser(username);
	}
	
	@RequestMapping(value = "/{username}", method = RequestMethod.PATCH)
	public UserDto patchUser(@RequestBody UserRequestDto userRequestDto, @PathVariable String username) {
		return userService.patchUser(userRequestDto, username);
	}

}
