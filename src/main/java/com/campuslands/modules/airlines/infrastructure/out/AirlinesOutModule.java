package com.campuslands.modules.airlines.infrastructure.out;

import com.campuslands.modules.airlines.application.AirlinesService;
import com.campuslands.modules.airlines.infrastructure.in.AirlinesAdapter;

public class AirlinesOutModule {

    protected AirlinesMySQL AirlinesRepository;
    protected AirlinesService service;
    protected AirlinesAdapter adapter;

    public AirlinesOutModule() {
        AirlinesRepository = new AirlinesMySQL();
        service = new AirlinesService(AirlinesRepository);
        adapter = new AirlinesAdapter(service);

    }

    public AirlinesAdapter module() {
        return adapter;
    }

    
}
