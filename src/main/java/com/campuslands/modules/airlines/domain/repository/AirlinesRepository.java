package com.campuslands.modules.airlines.domain.repository;
import java.util.List;
import java.util.Optional;

import com.campuslands.modules.airlines.domain.models.Airlines;

public interface AirlinesRepository {
    
    void save(Airlines airlines);
    void update(Airlines airlines);
    Optional<Airlines> findById(int id);
    void delete(int id);
    List<Airlines> findAll();
    
}