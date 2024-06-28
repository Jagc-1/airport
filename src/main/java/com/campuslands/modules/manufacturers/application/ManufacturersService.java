package com.campuslands.modules.manufacturers.application;

import java.util.List;
import java.util.Optional;
import com.campuslands.modules.manufacturers.domain.models.Manufacturers;
import com.campuslands.modules.manufacturers.domain.repository.ManufacturersRepository;

public class ManufacturersService {
    private final ManufacturersRepository manufacturersRepository;

    public ManufacturersService(ManufacturersRepository manufacturersRepository) {
        this.manufacturersRepository = manufacturersRepository;
    }

    public void createManufacturer(Manufacturers manufacturer) {
        manufacturersRepository.save(manufacturer);
    }

    public void updateManufacturer(Manufacturers manufacturer) {
        manufacturersRepository.update(manufacturer);
    }

    public Optional<Manufacturers> getManufacturerById(int id) {
        return manufacturersRepository.findById(id);
    }

    public void deleteManufacturer(int id) {
        manufacturersRepository.delete(id);
    }

    public List<Manufacturers> getAllManufacturers() {
        return manufacturersRepository.findAll();
    }
}
