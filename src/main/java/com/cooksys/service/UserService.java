package com.cooksys.service;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooksys.dto.FlightEntityDto;
import com.cooksys.dto.ItinerariesDto;
import com.cooksys.dto.UserDto;
import com.cooksys.dto.UserRequestDto;
import com.cooksys.embeddable.Credentials;
import com.cooksys.entity.FlightEntity;
import com.cooksys.entity.Itinerary;
import com.cooksys.entity.User;
import com.cooksys.mapper.UserMapper;
import com.cooksys.pojo.BookingRequest;
import com.cooksys.repository.FlightEntityRepository;
import com.cooksys.repository.ItineraryRepository;
import com.cooksys.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ItineraryRepository itineraryRepository;
	
	@Autowired
	FlightEntityRepository flightEntityRepository;
	
	@Autowired
	UserMapper userMapper;
	
	@Autowired
	EntityManager entityManager;

	public UserDto postUser(UserRequestDto userRequestDto) {
		if(userRepository.findByCredentialsUsername(userRequestDto.getCredentials().getUsername()) == null) {
			User user = userMapper.toUser(userRequestDto);
			user.setDeleted(false);
			user = userRepository.saveAndFlush(user);
			entityManager.detach(user);
			user = userRepository.findById(user.getId());
			return userMapper.toUserDto(user);
		}
		
		return null;
	}

	public UserDto getUser(String username) {
		if(userRepository.findByCredentialsUsername(username) != null) {
			User user = userRepository.findByCredentialsUsername(username);
			return userMapper.toUserDto(user);
		}
		
		return null;
	}
	
	public UserDto deleteUser(Credentials credentials, String username) {
		if(userRepository.findByCredentialsUsername(credentials.getUsername()) != null) {
			if(credentials.getUsername().equals(username)) {
				User user = userRepository.findByCredentialsUsername(credentials.getUsername());
				user.setDeleted(true);
				user = userRepository.save(user);
				return userMapper.toUserDto(user);
			}
		}
		
		return null;
	}

	public UserDto patchUser(UserRequestDto userRequestDto, String username) {
		if(userRepository.findByCredentialsUsername(username) != null) {
			if(userRequestDto.getCredentials().getUsername().equals(username)) {
				User updatedUser = userMapper.toUser(userRequestDto);
				User userToUpdate = userRepository.findByCredentialsUsername(username);
			
				if(updatedUser.getProfile().getFirstName() != null) {
					userToUpdate.getProfile().setFirstName(updatedUser.getProfile().getFirstName());
				}
				if(updatedUser.getProfile().getLastName() != null) {
					userToUpdate.getProfile().setLastName(updatedUser.getProfile().getLastName());
				}
				if(updatedUser.getProfile().getEmail() != null) {
					userToUpdate.getProfile().setEmail(updatedUser.getProfile().getEmail());
				}
				if(updatedUser.getProfile().getPhone() != null) {
					userToUpdate.getProfile().setPhone(updatedUser.getProfile().getPhone());
				}
				
				userToUpdate = userRepository.save(userToUpdate);
				return userMapper.toUserDto(userToUpdate);
			}
		}
		
		return null;
	}

	public Boolean getCredentialsValid(Credentials credentials) {
		if(userRepository.findByCredentialsUsername(credentials.getUsername()) != null) {
			return true;
		}
		
		return false;
	}

	public Itinerary bookItinerary(BookingRequest bookingRequest, String username) {
		if(userRepository.findByCredentialsUsername(username) != null) {
			if(bookingRequest.getCredentials().getUsername().equals(username)) {
				
				Itinerary itinerary = bookingRequest.getItinerary();
				for(FlightEntity entity : itinerary.getFlights()) {
					flightEntityRepository.save(entity);
				}
				
				itineraryRepository.save(itinerary);
				
				User user = userRepository.findByCredentialsUsername(username);
				Set<Itinerary> itineraries = user.getItineraries();
				if(itineraries == null) {
					itineraries = new HashSet<Itinerary>();
				}
				itineraries.add(bookingRequest.getItinerary());
				userRepository.save(user);
				return bookingRequest.getItinerary();
			}
		}
		
		return null;
	}

	public Set<ItinerariesDto> getItineraries(String username) {
		if(userRepository.findByCredentialsUsername(username) != null) {
			User user = userRepository.findByCredentialsUsername(username);
			Set<Itinerary> itineraries = user.getItineraries();
			Set<ItinerariesDto> itinerariesDtos = new HashSet<ItinerariesDto>();
			
			for(Itinerary i : itineraries) {
				
				Set<FlightEntityDto> tempFlightEntityDtos = new HashSet<FlightEntityDto>();
				for(FlightEntity f : i.getFlights()) {
					FlightEntityDto flightEntityDto = new FlightEntityDto(f);
					tempFlightEntityDtos.add(flightEntityDto);
				}
				ItinerariesDto itinerariesDto = new ItinerariesDto(i);
				itinerariesDto.setFlightEntityDtos(tempFlightEntityDtos);
				itinerariesDtos.add(itinerariesDto);
			}
			return itinerariesDtos;
		}
		return null;
	}

}
