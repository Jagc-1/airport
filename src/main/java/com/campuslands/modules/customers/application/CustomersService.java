package com.campuslands.modules.customers.application;

import java.util.List;
import java.util.Optional;
import com.campuslands.modules.customers.domain.models.Customer;
import com.campuslands.modules.customers.domain.repository.CustomersRepository;

public class CustomersService {
    private final CustomersRepository customersRepository;

    public CustomersService(CustomersRepository customersRepository) {
        this.customersRepository = customersRepository;
    }

    public void createCustomer(Customer customer) {
        customersRepository.save(customer);
    }

    public void updateCustomer(Customer customer) {
        customersRepository.update(customer);
    }

    public Optional<Customer> getCustomerById(int id) {
        return customersRepository.findById(id);
    }

    public void deleteCustomer(int id) {
        customersRepository.delete(id);
    }

    public List<Customer> getAllCustomers() {
        return customersRepository.findAll();
    }
}
