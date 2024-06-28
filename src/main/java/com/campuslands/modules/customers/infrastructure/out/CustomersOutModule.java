package com.campuslands.modules.customers.infrastructure.out;
import com.campuslands.modules.customers.application.CustomersService;
import com.campuslands.modules.customers.infrastructure.in.CustomersAdapter;

public class CustomersOutModule {

    protected CustomersMySQL customersMySQL;
    protected CustomersService customersService;
    protected CustomersAdapter customersAdapter;

    public CustomersOutModule() {
        customersMySQL = new CustomersMySQL();
        customersService = new CustomersService(customersMySQL);
        customersAdapter = new CustomersAdapter(customersService);
    }

    public CustomersAdapter module() {
        return customersAdapter;
    }

   
}
