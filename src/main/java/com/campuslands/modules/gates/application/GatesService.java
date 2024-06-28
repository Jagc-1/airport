package com.campuslands.modules.gates.application;

import java.util.List;
import java.util.Optional;
import com.campuslands.modules.gates.domain.models.Gates;
import com.campuslands.modules.gates.domain.repository.GatesRepository;

public class GatesService {
    private final GatesRepository gatesRepository;

    public GatesService(GatesRepository gatesRepository) {
        this.gatesRepository = gatesRepository;
    }

    public void createGate(Gates gate) {
        gatesRepository.save(gate);
    }

    public void updateGate(Gates gate) {
        gatesRepository.update(gate);
    }

    public Optional<Gates> getGateById(int id) {
        return gatesRepository.findById(id);
    }

    public void deleteGate(int id) {
        gatesRepository.delete(id);
    }

    public List<Gates> getAllGates() {
        return gatesRepository.findAll();
    }
}
