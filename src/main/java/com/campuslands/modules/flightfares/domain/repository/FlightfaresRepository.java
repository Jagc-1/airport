package com.campuslands.modules.flightfares.domain.repository;

import java.util.List;
import java.util.Optional;
import com.campuslands.modules.flightfares.domain.models.Flightfares;

public interface FlightfaresRepository {
    void save(Flightfares flightFares);
    void update(Flightfares flightFares);
    Optional<Flightfares> findById(int id);
    void delete(int id);
    List<Flightfares> findAll();
}