package com.campuslands.modules.flightconnections.domain.repository;

import java.util.List;
import java.util.Optional;

import com.campuslands.modules.flightconnections.domain.models.FlightConnection;

public interface FlightConnectionsRepository {
    void save(FlightConnection flightConnections);
    void update(FlightConnection flightConnections);
    Optional<FlightConnection> findById(int id);
    void delete(int id);
    List<FlightConnection> findAll();
}