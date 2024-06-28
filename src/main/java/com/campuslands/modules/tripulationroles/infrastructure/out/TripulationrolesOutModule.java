package com.campuslands.modules.tripulationroles.infrastructure.out;
import com.campuslands.modules.tripulationroles.application.TripulationrolesService;
import com.campuslands.modules.tripulationroles.infrastructure.in.TripulationrolesAdapter;

public class TripulationrolesOutModule {

    protected TripulationRolesMySQL tripulationRolesMySqlRepository;
    protected TripulationrolesService service;
    protected TripulationrolesAdapter adapter;

    public TripulationrolesOutModule() {
        tripulationRolesMySqlRepository = new TripulationRolesMySQL();
        service = new TripulationrolesService(tripulationRolesMySqlRepository);
        adapter = new TripulationrolesAdapter(service);

    }

    public TripulationrolesAdapter module() {
        return adapter;
    }

    
}
