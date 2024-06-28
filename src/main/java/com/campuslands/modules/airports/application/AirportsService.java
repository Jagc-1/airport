package com.campuslands.modules.airports.application;

import java.util.List;
import java.util.Optional;
import com.campuslands.modules.airports.domain.models.Airport;
import com.campuslands.modules.airports.domain.repository.AirportsRepository;;

/**
 * AirportsService
 */
public class AirportsService {
    private final AirportsRepository airportsRepository;

    public AirportsService(AirportsRepository airportsRepository) {
        this.airportsRepository = airportsRepository;
    }

    public void createAirport(Airport airports) {
        airportsRepository.save(airports);
    }

    public void updateAirport(Airport airports) {
        airportsRepository.update(airports);
    }

    public Optional<Airport> getAirportById(int id) {
        return airportsRepository.findById(id);
    }

    public void deleteAirport(int id) {
        airportsRepository.delete(id);
    }

    public List<Airport> getAllAirports() {
        return airportsRepository.findAll();
    }

}