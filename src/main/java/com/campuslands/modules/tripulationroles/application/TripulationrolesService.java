package com.campuslands.modules.tripulationroles.application;

import java.util.List;
import java.util.Optional;
import com.campuslands.modules.tripulationroles.domain.models.Tripulationroles;
import com.campuslands.modules.tripulationroles.domain.repository.TripulationRolesRepository;

public class TripulationrolesService {
    private final TripulationRolesRepository tripulationRolesRepository;

    public TripulationrolesService(TripulationRolesRepository tripulationRolesRepository) {
        this.tripulationRolesRepository = tripulationRolesRepository;
    }

    public void createTripulationroles(Tripulationroles tripulationroles) {
        tripulationRolesRepository.save(tripulationroles);
    }

    public void updateTripulationroles(Tripulationroles tripulationroles) {
        tripulationRolesRepository.update(tripulationroles);
    }

    public Optional<Tripulationroles> getTripulationrolesById(int id) {
        return tripulationRolesRepository.findById(id);
    }

    public void deleteTripulationroles(int id) {
        tripulationRolesRepository.delete(id);
    }

    public List<Tripulationroles> getAllTripulationroles() {
        return tripulationRolesRepository.findAll();
    }
}
