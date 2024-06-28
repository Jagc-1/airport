package com.campuslands.modules.statuses.domain.repository;

import java.util.List;
import java.util.Optional;
import com.campuslands.modules.statuses.domain.models.Statuses;

public interface StatusesRepository {
    void save(Statuses statuses);
    void update(Statuses statuses);
    Optional<Statuses> findById(int id);
    void delete(int id);
    List<Statuses> findAll();
}