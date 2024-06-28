package com.campuslands.modules.statuses.application;

import java.util.List;
import java.util.Optional;
import com.campuslands.modules.statuses.domain.models.Statuses;
import com.campuslands.modules.statuses.domain.repository.StatusesRepository;

public class StatusesService {
    private final StatusesRepository statusesRepository;

    public StatusesService(StatusesRepository statusesRepository) {
        this.statusesRepository = statusesRepository;
    }

    public void createStatus(Statuses status) {
        statusesRepository.save(status);
    }

    public void updateStatus(Statuses status) {
        statusesRepository.update(status);
    }

    public Optional<Statuses> getStatusById(int id) {
        return statusesRepository.findById(id);
    }

    public void deleteStatus(int id) {
        statusesRepository.delete(id);
    }

    public List<Statuses> getAllStatuses() {
        return statusesRepository.findAll();
    }
}
