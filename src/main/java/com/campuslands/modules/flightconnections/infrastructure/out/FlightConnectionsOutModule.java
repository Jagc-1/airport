package com.campuslands.modules.flightconnections.infrastructure.out;

import com.campuslands.modules.flightconnections.application.FlightConnectionsService;
import com.campuslands.modules.flightconnections.infrastructure.in.FlightConnectionsAdapter;

public class FlightConnectionsOutModule {

    protected FlightConnectionsMySqlRespository flightConnectionsMySQL;
    protected FlightConnectionsService flightConnectionsService;
    protected FlightConnectionsAdapter flightConnectionsAdapter;

    public FlightConnectionsOutModule() {
        flightConnectionsMySQL = new FlightConnectionsMySqlRespository();
        flightConnectionsService = new FlightConnectionsService(flightConnectionsMySQL);
        flightConnectionsAdapter = new FlightConnectionsAdapter(flightConnectionsService);

    }

    public FlightConnectionsAdapter module() {
        return flightConnectionsAdapter;
    }

}
