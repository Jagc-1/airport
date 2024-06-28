package com.campuslands.modules.flightfares.application;

import java.util.List;
import java.util.Optional;
import com.campuslands.modules.flightfares.domain.models.Flightfares;
import com.campuslands.modules.flightfares.domain.repository.FlightfaresRepository;

public class FlightfaresService {
    private final FlightfaresRepository flightfaresRepository;

    public FlightfaresService(FlightfaresRepository flightfaresRepository) {
        this.flightfaresRepository = flightfaresRepository;
    }

    public void createFlightfare(Flightfares flightfare) {
        flightfaresRepository.save(flightfare);
    }

    public void updateFlightfare(Flightfares flightfare) {
        flightfaresRepository.update(flightfare);
    }

    public Optional<Flightfares> getFlightfareById(int id) {
        return flightfaresRepository.findById(id);
    }

    public void deleteFlightfare(int id) {
        flightfaresRepository.delete(id);
    }

    public List<Flightfares> getAllFlightfares() {
        return flightfaresRepository.findAll();
    }
}
