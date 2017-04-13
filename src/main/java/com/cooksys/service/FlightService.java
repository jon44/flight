package com.cooksys.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.cooksys.component.FlightGenerator;
import com.cooksys.entity.FlightEntity;
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
	@Scheduled(fixedDelay=5000)
	private void refreshFlights()
	{
		flightList = generator.generateNewFlightList();
	}

	public Itinerary getPath(PathEndpoints endpoints) {
		String origin = endpoints.getOrigin();
		String destination = endpoints.getDestination();
		Set<Itinerary> itineraries = new HashSet<Itinerary>();
		
		for(Flight flight : flightList) {
			if(flight.getOrigin().equals(origin) && flight.getDestination().equals(destination)) {
				FlightEntity flightEntity = new FlightEntity(flight);
				Itinerary itinerary = new Itinerary();
				Set<FlightEntity> tempFlightEntities = itinerary.getFlights();
				if(tempFlightEntities == null) {
					tempFlightEntities = new HashSet<FlightEntity>();
				}
				tempFlightEntities.add(flightEntity);
				itinerary.setFlights(tempFlightEntities);
				return itinerary;
			} else if(flight.getOrigin().equals(origin)) {
//				List<Flight> remaining = flightList;
//				remaining.remove(flight);
//				itineraries = getPaths(itineraries, remaining, flight, destination);
			}
		}
		
		return null;
	}
	
	public Set<Itinerary> getPaths(Set<Itinerary> itineraries, List<Flight> remaining, Flight previous, String destination) {
		if(remaining.size() == 0) {
			if(previous.getDestination().equals(destination)) {
				return itineraries;
			} else {
				return null;
			}
		}
		
		return null;
	}
}
