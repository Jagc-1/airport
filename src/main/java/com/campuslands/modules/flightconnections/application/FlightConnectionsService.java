package com.campuslands.modules.flightconnections.application;


import java.util.List;
import java.util.Optional;
import com.campuslands.modules.flightconnections.domain.models.FlightConnection;
import com.campuslands.modules.flightconnections.domain.repository.FlightConnectionsRepository;

public class FlightConnectionsService {
    private final FlightConnectionsRepository flightConnectionsRepository;

    public FlightConnectionsService(FlightConnectionsRepository flightConnectionsRepository) {
        this.flightConnectionsRepository = flightConnectionsRepository;
    }

    public void createFlightConnection(FlightConnection flightConnection) {
        flightConnectionsRepository.save(flightConnection);
    }

    public void updateFlightConnection(FlightConnection flightConnection) {
        flightConnectionsRepository.update(flightConnection);
    }

    public Optional<FlightConnection> getFlightConnectionById(int id) {
        return flightConnectionsRepository.findById(id);
    }

    public void deleteFlightConnection(int id) {
        flightConnectionsRepository.delete(id);
    }

    public List<FlightConnection> getAllFlightConnections() {
        return flightConnectionsRepository.findAll();
    }
}
