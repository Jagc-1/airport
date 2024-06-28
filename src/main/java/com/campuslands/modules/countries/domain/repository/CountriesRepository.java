package com.campuslands.modules.countries.domain.repository;

import com.campuslands.modules.countries.domain.models.Country;

import java.util.List;
import java.util.Optional;
public interface CountriesRepository {
    void save(Country countries);
    void update(Country countries);
    Optional<Country> findById(int id);
    void delete(int id);
    List<Country> findAll();
}