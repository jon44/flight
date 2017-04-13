package com.cooksys.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.cooksys.component.FlightGenerator;
import com.cooksys.entity.Itinerary;
import com.cooksys.pojo.Flight;
import com.cooksys.pojo.PathEndpoints;

@Service
public class FlightService {

	@Autowired
	FlightGenerator generator;

	private ArrayList<Flight> flightList = new ArrayList<Flight>();
	
	public ArrayList<Flight> getDailyFlightList()
	{
		return flightList;
	}
	
	//The fixedDelay parameter determines how often a new day is generated as expressed in milliseconds
	@Scheduled(fixedDelay=15000)
	private void refreshFlights()
	{
		flightList = generator.generateNewFlightList();
	}

	public List<Itinerary> getPaths(PathEndpoints endpoints) {
		List<Itinerary> itineraries = new ArrayList<Itinerary>();
		String origin = endpoints.getOrigin();
		String destination = endpoints.getDestination();
		
		for(Flight i : flightList) {
			if(i.getOrigin().equals(origin)) {
				List<Itinerary> paths = getPath(i, origin, destination);
				if(paths.size() != 0) {
					System.out.println("paths.size is not 0!");
				}
			}
		}
		
		return null;
	}
	
	public List<Itinerary> getPath(Flight first, String origin, String destination) {
		System.out.println(origin);
		
		return null;
	}
	
}
