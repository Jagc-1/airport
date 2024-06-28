package com.campuslands.modules.trips.domain.repository;

import java.util.List;
import java.util.Optional;
import com.campuslands.modules.trips.domain.models.Trips;

public interface TripsRepository {
    void save(Trips trips);
    void update(Trips trips);
    Optional<Trips> findById(int id);
    void delete(int id);
    List<Trips> findAll();
}