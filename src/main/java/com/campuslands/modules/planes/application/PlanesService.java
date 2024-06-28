package com.campuslands.modules.planes.application;

import java.util.List;
import java.util.Optional;
import com.campuslands.modules.planes.domain.models.Planes;
import com.campuslands.modules.planes.domain.repository.PlanesRepository;

public class PlanesService {
    private final PlanesRepository planesRepository;

    public PlanesService(PlanesRepository planesRepository) {
        this.planesRepository = planesRepository;
    }

    public void createPlane(Planes plane) {
        planesRepository.save(plane);
    }

    public void updatePlane(Planes plane) {
        planesRepository.update(plane);
    }

    public Optional<Planes> getPlaneById(int id) {
        return planesRepository.findById(id);
    }

    public void deletePlane(int id) {
        planesRepository.delete(id);
    }

    public List<Planes> getAllPlanes() {
        return planesRepository.findAll();
    }
}
