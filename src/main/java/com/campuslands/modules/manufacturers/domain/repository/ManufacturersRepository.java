package com.campuslands.modules.manufacturers.domain.repository;

import java.util.List;
import java.util.Optional;
import com.campuslands.modules.manufacturers.domain.models.Manufacturers;

public interface ManufacturersRepository {
    void save(Manufacturers manufacturers);
    void update(Manufacturers manufacturers);
    Optional<Manufacturers> findById(int id);
    void delete(int id);
    List<Manufacturers> findAll();
}