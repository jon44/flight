package com.cooksys.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.entity.Itinerary;
import com.cooksys.pojo.Flight;
import com.cooksys.pojo.PathEndpoints;
import com.cooksys.service.FlightService;
import com.cooksys.service.LocationService;

@RestController
@RequestMapping("flights")
@CrossOrigin
public class FlightsController {
	
	@Autowired
	LocationService locationService;
	
	@Autowired
	FlightService flightService;
	
	@RequestMapping
	public ArrayList<Flight> getFlightList()
	{
		return flightService.getDailyFlightList();
	}
	
	@RequestMapping(value = "/paths", method = RequestMethod.POST)
	public Itinerary findPaths(@RequestBody PathEndpoints endpoints) {
		return flightService.getPath(endpoints);
	}
	
}
