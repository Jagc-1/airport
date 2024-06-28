package com.campuslands.modules.airports.infrastructure.out;
import com.campuslands.modules.airports.application.AirportsService;
import com.campuslands.modules.airports.infrastructure.in.AirportsAdapter;

public class AirportsOutModule {

    protected AirportsMySQL MySQL;
    protected AirportsService service;
    protected AirportsAdapter adapter;

    public AirportsOutModule() {
        MySQL = new AirportsMySQL();
        service = new AirportsService(MySQL);
        adapter = new AirportsAdapter(service);

    }

    public AirportsAdapter module() {
        return adapter;
    }

    
}
