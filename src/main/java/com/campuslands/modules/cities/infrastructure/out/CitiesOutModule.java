package com.campuslands.modules.cities.infrastructure.out;

import com.campuslands.modules.cities.application.CitiesService;
import com.campuslands.modules.cities.infrastructure.in.CitiesAdapter;

public class CitiesOutModule {

    protected CitiesMySQL citiesMySQL;
    protected CitiesService citiesService;
    protected CitiesAdapter citiesAdapter;

    public CitiesOutModule() {
        citiesMySQL = new CitiesMySQL();
        citiesService = new CitiesService(citiesMySQL);
        citiesAdapter = new CitiesAdapter(citiesService);
    }

    public CitiesAdapter module() {
        return citiesAdapter;
    }

}
