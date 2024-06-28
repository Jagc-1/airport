package com.campuslands.modules.planes.domain.repository;

import java.util.List;
import java.util.Optional;
import com.campuslands.modules.planes.domain.models.Planes;

public interface PlanesRepository {
    void save(Planes planes);
    void update(Planes planes);
    Optional<Planes> findById(int id);
    void delete(int id);
    List<Planes> findAll();
}