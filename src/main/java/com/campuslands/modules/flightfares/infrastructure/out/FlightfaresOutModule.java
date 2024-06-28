package com.campuslands.modules.flightfares.infrastructure.out;
import com.campuslands.modules.flightfares.application.FlightfaresService;
import com.campuslands.modules.flightfares.infrastructure.in.FlightFaresAdapter;

public class FlightfaresOutModule {

    protected FlightFaresMySQL flightFaresMySQL;
    protected FlightfaresService flightFaresService;
    protected FlightFaresAdapter flightFaresAdapter;

    public FlightfaresOutModule() {
        flightFaresMySQL = new FlightFaresMySQL();
        flightFaresService = new FlightfaresService(flightFaresMySQL);
        flightFaresAdapter = new FlightFaresAdapter(flightFaresService);

    }

    public FlightFaresAdapter module() {
        return flightFaresAdapter; // Return the FlightFaresAdapter instance
    }

   
}
