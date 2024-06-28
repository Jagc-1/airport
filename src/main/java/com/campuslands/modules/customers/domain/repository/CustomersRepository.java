package com.campuslands.modules.customers.domain.repository;
import com.campuslands.modules.customers.domain.models.Customer;

import java.util.List;
import java.util.Optional;
public interface CustomersRepository {
    void save(Customer customers);
    void update(Customer customers);
    Optional<Customer> findById(int id);
    void delete(int id);
    List<Customer> findAll();
}