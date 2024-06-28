package com.campuslands.modules.countries.infrastructure.out;
import com.campuslands.modules.countries.application.CountriesService;
import com.campuslands.modules.countries.infrastructure.in.CountriesAdapter;

public class CountriesOutModule {

    protected CountriesMySQL countriesMySQL;
    protected CountriesService countriesService;
    protected CountriesAdapter countriesAdapter;

    public CountriesOutModule() {
        countriesMySQL = new CountriesMySQL();
        countriesService = new CountriesService(countriesMySQL);
        countriesAdapter = new CountriesAdapter(countriesService);
    }

    public CountriesAdapter module() {
        return countriesAdapter;
    }

   
}
