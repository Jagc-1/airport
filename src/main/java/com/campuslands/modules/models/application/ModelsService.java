package com.campuslands.modules.models.application;

import java.util.List;
import java.util.Optional;

import com.campuslands.modules.models.domain.models.Models;
import com.campuslands.modules.models.domain.repository.ModelsRepository;

public class ModelsService {
    private final ModelsRepository modelRepository;

    public ModelsService(ModelsRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    public void createModel(Models model) {
        modelRepository.save(model);
    }

    public void updateModel(Models model) {
        modelRepository.update(model);
    }

    public Optional<Models> getModelById(int id) {
        return modelRepository.findById(id);
    }

    public void deleteModel(int id) {
        modelRepository.delete(id);
    }

    public List<Models> getAllModels() {
        return modelRepository.findAll();
    }
}