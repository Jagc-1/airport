package com.campuslands.modules.planes.infrastructure.out;
import com.campuslands.modules.planes.application.PlanesService;
import com.campuslands.modules.planes.infrastructure.in.PlanesAdapter;

public class PlanesOutModule {

    protected PlanesMySqlRepository planesMySQL;
    protected PlanesService planesService;
    protected PlanesAdapter planesAdapter;

    public PlanesOutModule() {
        planesMySQL = new PlanesMySqlRepository(); // Initialize PlanesMySQL instance
        planesService = new PlanesService(planesMySQL); // Initialize PlanesService with PlanesMySQL
        planesAdapter = new PlanesAdapter(planesService); // Initialize PlanesAdapter with PlanesService
    }

    public PlanesAdapter module() {
        return planesAdapter; // Return the PlanesAdapter instance
    }

    
      

}
