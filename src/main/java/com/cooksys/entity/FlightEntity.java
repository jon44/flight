package com.cooksys.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.cooksys.pojo.Flight;

@Entity
@Table(name="flight")
public class FlightEntity {

	@Id
	@GeneratedValue
	private Long id;
	
	private String origin;
	
	private String destination;
	
	private Long delay;
	
	@ManyToMany(mappedBy = "flights")
	private Set<Itinerary> bookings;
	
	public FlightEntity() {
		
	}
	
	public FlightEntity(Flight flight) {
		this.origin = flight.getOrigin();
		this.destination = flight.getDestination();
		this.delay = flight.getOffset();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Long getDelay() {
		return delay;
	}

	public void setDelay(Long delay) {
		this.delay = delay;
	}

	public Set<Itinerary> getBookings() {
		return bookings;
	}

	public void setBookings(Set<Itinerary> bookings) {
		this.bookings = bookings;
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
		FlightEntity other = (FlightEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
