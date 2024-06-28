package com.campuslands.modules.manufacturers.infrastructure.out;
import com.campuslands.modules.manufacturers.application.ManufacturersService;
import com.campuslands.modules.manufacturers.infrastructure.in.ManufacturersAdapter;

public class ManufacturersOutModule {

    protected ManufacturersMySqlRepository manufacturersMySQL;
    protected ManufacturersService manufacturersService;
    protected ManufacturersAdapter manufacturersAdapter;

    public ManufacturersOutModule() {
        manufacturersMySQL = new ManufacturersMySqlRepository(); 
        manufacturersService = new ManufacturersService(manufacturersMySQL); 
        manufacturersAdapter = new ManufacturersAdapter(manufacturersService); 
    }

    public ManufacturersAdapter module() {
        return manufacturersAdapter; 
    }

    
}
