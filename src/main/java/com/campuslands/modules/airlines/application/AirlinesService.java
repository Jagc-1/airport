package com.campuslands.modules.airlines.application;

import java.util.List;
import java.util.Optional;
import com.campuslands.modules.airlines.domain.models.Airlines;
import com.campuslands.modules.airlines.domain.repository.AirlinesRepository;


public class AirlinesService {
    private final AirlinesRepository airlinesRepository;

    public AirlinesService(AirlinesRepository airlinesRepository) {
        this.airlinesRepository = airlinesRepository;
    }

    
    public void createAirline(Airlines airlines) {
        airlinesRepository.save(airlines);
    }

    public void updateAirline(Airlines airlines) {
        airlinesRepository.update(airlines);
    }

    public Optional<Airlines> getAirlineById(int id) {
        return airlinesRepository.findById(id);
    }

    public void deleteAirline(int id) {
        airlinesRepository.delete(id);
    }

    public List<Airlines> getAllAirlines() {
        return airlinesRepository.findAll();
    }
}