package com.cooksys.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Itinerary {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@OneToMany
	private List<FlightEntity> flights;
	
	private Long flightTime;
	
	private Long layover;

	public Itinerary() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<FlightEntity> getFlights() {
		return flights;
	}

	public void setFlights(List<FlightEntity> flights) {
		this.flights = flights;
	}

	public Long getFlightTime() {
		return flightTime;
	}

	public void setFlightTime(Long flightTime) {
		this.flightTime = flightTime;
	}

	public Long getLayover() {
		return layover;
	}

	public void setLayover(Long layover) {
		this.layover = layover;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Itinerary other = (Itinerary) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
