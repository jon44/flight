package com.cooksys.dto;

import java.util.Set;

import com.cooksys.entity.Itinerary;

public class ItinerariesDto {
	
	private Set<FlightEntityDto> flightEntityDtos;
	
	private Long flightTime;
	
	private Long delay;
	
	public ItinerariesDto() {
		
	}
	
	public ItinerariesDto(Itinerary itinerary) {
		this.flightTime = itinerary.getFlightTime();
		this.delay = itinerary.getLayover();
	}

	public Set<FlightEntityDto> getFlightEntityDtos() {
		return flightEntityDtos;
	}

	public void setFlightEntityDtos(Set<FlightEntityDto> flightEntityDtos) {
		this.flightEntityDtos = flightEntityDtos;
	}

	public Long getFlightTime() {
		return flightTime;
	}

	public void setFlightTime(Long flightTime) {
		this.flightTime = flightTime;
	}

	public Long getDelay() {
		return delay;
	}

	public void setDelay(Long delay) {
		this.delay = delay;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((delay == null) ? 0 : delay.hashCode());
		result = prime * result + ((flightEntityDtos == null) ? 0 : flightEntityDtos.hashCode());
		result = prime * result + ((flightTime == null) ? 0 : flightTime.hashCode());
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
		ItinerariesDto other = (ItinerariesDto) obj;
		if (delay == null) {
			if (other.delay != null)
				return false;
		} else if (!delay.equals(other.delay))
			return false;
		if (flightEntityDtos == null) {
			if (other.flightEntityDtos != null)
				return false;
		} else if (!flightEntityDtos.equals(other.flightEntityDtos))
			return false;
		if (flightTime == null) {
			if (other.flightTime != null)
				return false;
		} else if (!flightTime.equals(other.flightTime))
			return false;
		return true;
	}
	
}
