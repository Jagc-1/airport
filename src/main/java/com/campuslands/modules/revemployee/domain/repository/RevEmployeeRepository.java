package com.campuslands.modules.revemployee.domain.repository;

import java.util.List;
import java.util.Optional;
import com.campuslands.modules.revemployee.domain.models.Revemployee;

public interface RevEmployeeRepository {
    void save(Revemployee revemployee);
    void update(Revemployee revemployee);
    Optional<Revemployee> findById(int id);
    void delete(int id);
    List<Revemployee> findAll();
}