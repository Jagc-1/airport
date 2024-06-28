package com.campuslands.modules.revisions.domain.repository;

import java.util.List;
import java.util.Optional;
import com.campuslands.modules.revisions.domain.models.Revisions;

public interface RevisionsRepository {
    void save(Revisions revisions);
    void update(Revisions revisions);
    Optional<Revisions> findById(int id);
    void delete(int id);
    List<Revisions> findAll();
}