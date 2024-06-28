package com.campuslands.modules.trips.application;

import java.util.List;
import java.util.Optional;
import com.campuslands.modules.trips.domain.models.Trips;
import com.campuslands.modules.trips.domain.repository.TripsRepository;

public class TripsService {
    private final TripsRepository tripsRepository;

    public TripsService(TripsRepository tripsRepository) {
        this.tripsRepository = tripsRepository;
    }

    public void createTrip(Trips trip) {
        tripsRepository.save(trip);
    }

    public void updateTrip(Trips trip) {
        tripsRepository.update(trip);
    }

    public Optional<Trips> getTripById(int id) {
        return tripsRepository.findById(id);
    }

    public void deleteTrip(int id) {
        tripsRepository.delete(id);
    }

    public List<Trips> getAllTrips() {
        return tripsRepository.findAll();
    }
}
