package com.campuslands.modules.cities.application;

import com.campuslands.modules.cities.domain.models.Cities;
import com.campuslands.modules.cities.domain.repository.CitiesRepository;
import java.util.List;
import java.util.Optional;

/**
 * CitiesService
 */
public class CitiesService {
    private final CitiesRepository citiesRepository;

    public CitiesService(CitiesRepository citiesRepository) {
        this.citiesRepository = citiesRepository;
    }

    public void createCities(Cities cities) {
        citiesRepository.save(cities);
    }

    public void updateCities(Cities cities) {
        citiesRepository.update(cities);
    }

    public Optional<Cities> getCityById(int id) {
        return citiesRepository.findById(id);
    }

    public void deleteCities(int id) {
        citiesRepository.delete(id);
    }

    public List<Cities> getAllCities() {
        return citiesRepository.findAll();
    }
}