package com.campuslands.modules.statuses.infrastructure.out;
import com.campuslands.modules.statuses.application.StatusesService;
import com.campuslands.modules.statuses.infrastructure.in.StatusesAdapter;

public class StatusesOutModule {

    protected StatusesMySQL statusesMySQL;
    protected StatusesService statusesService;
    protected StatusesAdapter statusesAdapter;

    public StatusesOutModule() {
        statusesMySQL = new StatusesMySQL(); // Initialize StatusesMySQL instance
        statusesService = new StatusesService(statusesMySQL); // Initialize StatusesService with StatusesMySQL
        statusesAdapter = new StatusesAdapter(statusesService); // Initialize StatusesAdapter with StatusesService
    }

    public StatusesAdapter module() {
        return statusesAdapter; // Return the StatusesAdapter instance
    }

}
