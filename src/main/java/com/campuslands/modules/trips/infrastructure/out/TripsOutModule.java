package com.campuslands.modules.trips.infrastructure.out;
import com.campuslands.modules.trips.application.TripsService;
import com.campuslands.modules.trips.infrastructure.in.TripsAdapter;



public class TripsOutModule {

    protected TripsMySqlRepository tripsMySQL;
    protected TripsService tripsService;
    protected TripsAdapter tripsAdapter;

    public TripsOutModule() {
        tripsMySQL = new TripsMySqlRepository(); // Initialize TripsMySQL instance
        tripsService = new TripsService(tripsMySQL); // Initialize TripsService with TripsMySQL
        tripsAdapter = new TripsAdapter(tripsService); // Initialize TripsAdapter with TripsService
    }

    public TripsAdapter module() {
        return tripsAdapter; // Return the TripsAdapter instance
    }

}
