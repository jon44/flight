package com.cooksys.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cooksys.entity.FlightEntity;

public interface FlightEntityRepository extends JpaRepository<FlightEntity, Long> {

}
