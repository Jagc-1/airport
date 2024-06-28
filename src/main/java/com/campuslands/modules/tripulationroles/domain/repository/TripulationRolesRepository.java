package com.campuslands.modules.tripulationroles.domain.repository;

import java.util.List;
import java.util.Optional;


import com.campuslands.modules.tripulationroles.domain.models.Tripulationroles;

public interface TripulationRolesRepository {

    void save(Tripulationroles tripulationRoles);
    void update(Tripulationroles tripulationRoles);
    Optional<Tripulationroles> findById(int id);
    void delete(int id);
    List<Tripulationroles> findAll();


}