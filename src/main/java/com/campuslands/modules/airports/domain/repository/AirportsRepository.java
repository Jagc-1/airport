package com.campuslands.modules.airports.domain.repository;

import java.util.List;
import java.util.Optional;

import com.campuslands.modules.airports.domain.models.Airport;

/**
 * AirportsRepository
 */
public interface AirportsRepository {
    void save(Airport airport);
    void update(Airport airport);
    Optional<Airport> findById(int id);
    void delete(int id);
    List<Airport> findAll();
    
}