package com.campuslands.modules.countries.application;

import java.util.List;
import java.util.Optional;
import com.campuslands.modules.countries.domain.models.Country;
import com.campuslands.modules.countries.domain.repository.CountriesRepository;

public class CountriesService {
    private final CountriesRepository countriesRepository;

    public CountriesService(CountriesRepository countriesRepository) {
        this.countriesRepository = countriesRepository;
    }

    public void createCountry(Country country) {
        countriesRepository.save(country);
    }

    public void updateCountry(Country country) {
        countriesRepository.update(country);
    }

    public Optional<Country> getCountryById(int id) {
        return countriesRepository.findById(id);
    }

    public void deleteCountry(int id) {
        countriesRepository.delete(id);
    }

    public List<Country> getAllCountries() {
        return countriesRepository.findAll();
    }
}
