package com.campuslands.modules.revemployee.application;

import java.util.List;
import java.util.Optional;
import com.campuslands.modules.revemployee.domain.models.Revemployee;
import com.campuslands.modules.revemployee.domain.repository.RevEmployeeRepository;

public class RevemployeeService {
    private final RevEmployeeRepository revemployeeRepository;

    public RevemployeeService(RevEmployeeRepository revemployeeRepository) {
        this.revemployeeRepository = revemployeeRepository;
    }

    public void createRevemployee(Revemployee revemployee) {
        revemployeeRepository.save(revemployee);
    }

    public void updateRevemployee(Revemployee revemployee) {
        revemployeeRepository.update(revemployee);
    }

    public Optional<Revemployee> getRevemployeeById(int id) {
        return revemployeeRepository.findById(id);
    }

    public void deleteRevemployee(int id) {
        revemployeeRepository.delete(id);
    }

    public List<Revemployee> getAllRevemployees() {
        return revemployeeRepository.findAll();
    }
}
