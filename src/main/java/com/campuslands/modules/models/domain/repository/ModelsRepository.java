package com.campuslands.modules.models.domain.repository;

import java.util.List;
import java.util.Optional;


import com.campuslands.modules.models.domain.models.Models;

/**
 * ModelsRepository
 */
public interface ModelsRepository {

    void save(Models customers);
    void update(Models customers);
    Optional<Models> findById(int id);
    void delete(int id);
    List<Models> findAll();
    
}