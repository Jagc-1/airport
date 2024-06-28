package com.campuslands.modules.models.infrastructure.out;
import com.campuslands.modules.models.application.ModelsService;
import com.campuslands.modules.models.infrastructure.in.ModelsAdapter;

public class ModelsOutModule {

    protected ModelsMySqlRepository modelsMySQL;
    protected ModelsService modelsService;
    protected ModelsAdapter modelsAdapter;

    public ModelsOutModule() {
        modelsMySQL = new ModelsMySqlRepository(); // Initialize ModelsMySQL instance
        modelsService = new ModelsService(modelsMySQL); // Initialize ModelsService with ModelsMySQL
        modelsAdapter = new ModelsAdapter(modelsService); // Initialize ModelsAdapter with ModelsService
    }

    public ModelsAdapter module() {
        return modelsAdapter; // Return the ModelsAdapter instance
    }

    
}
