package com.campuslands.modules.cities.domain.repository;

import java.util.List;
import java.util.Optional;

import com.campuslands.modules.cities.domain.models.Cities;

/**
 * CitiesRepository
 */
public interface CitiesRepository {

    void save(Cities cities);
    void update(Cities cities);
    Optional<Cities> findById(int id);
    void delete(int id);
    List<Cities> findAll();

}