package com.campuslands.modules.tripcrews.domain.repository;

import java.util.List;
import java.util.Optional;
import com.campuslands.modules.tripcrews.domain.models.Tripcrews;

public interface TripcrewsRepository {
    void save(Tripcrews tripCrews);
    void update(Tripcrews tripCrews);
    Optional<Tripcrews> findById(int id);
    void delete(int id);
    List<Tripcrews> findAll();
}