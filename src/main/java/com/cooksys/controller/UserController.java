package com.cooksys.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.dto.ItinerariesDto;
import com.cooksys.dto.UserDto;
import com.cooksys.dto.UserRequestDto;
import com.cooksys.embeddable.Credentials;
import com.cooksys.entity.Itinerary;
import com.cooksys.pojo.BookingRequest;
import com.cooksys.service.UserService;

@RestController
@RequestMapping("users")
@CrossOrigin
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
	
	@RequestMapping(value = "/{username}", method = RequestMethod.DELETE)
	public UserDto deleteUser(@RequestBody Credentials credentials, @PathVariable String username) {
		return userService.deleteUser(credentials, username);
	}
	
	@RequestMapping(value = "/{username}", method = RequestMethod.PATCH)
	public UserDto patchUser(@RequestBody UserRequestDto userRequestDto, @PathVariable String username) {
		return userService.patchUser(userRequestDto, username);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/{username}/book", method = RequestMethod.POST)
	public Itinerary bookItinerary(@RequestBody BookingRequest bookingRequest, @PathVariable String username) {
		return userService.bookItinerary(bookingRequest, username);
	}
	
	@RequestMapping(value = "/{username}/bookings", method = RequestMethod.GET)
	public Set<ItinerariesDto> getItineraries(@PathVariable String username) {
		return userService.getItineraries(username);
	}

}
