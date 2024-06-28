package com.campuslands.modules.gates.domain.repository;

import java.util.List;
import java.util.Optional;
import com.campuslands.modules.gates.domain.models.Gates;

public interface GatesRepository {
    void save(Gates gates);
    void update(Gates gates);
    Optional<Gates> findById(int id);
    void delete(int id);
    List<Gates> findAll();
}