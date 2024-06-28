package com.campuslands.modules.gates.infrastructure.out;

import com.campuslands.modules.gates.application.GatesService;
import com.campuslands.modules.gates.infrastructure.in.GatesAdapter;

public class GatesOutModule {

    protected GatesMySQL gatesMySQL;
    protected GatesService gatesService;
    protected GatesAdapter gatesAdapter;

    public GatesOutModule() {
        gatesMySQL = new GatesMySQL();
        gatesService = new GatesService(gatesMySQL);
        gatesAdapter = new GatesAdapter(gatesService);
    }

    public GatesAdapter module() {
        return gatesAdapter;
    }

   
}
