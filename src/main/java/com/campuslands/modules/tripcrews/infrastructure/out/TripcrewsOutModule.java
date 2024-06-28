package com.campuslands.modules.tripcrews.infrastructure.out;

import com.campuslands.modules.tripcrews.application.TripcrewsService;
import com.campuslands.modules.tripcrews.infrastructure.in.TripcrewsAdapter;

public class TripcrewsOutModule {

    protected TripcrewsMySQL tripcrewsMySQL;
    protected TripcrewsService tripcrewsService;
    protected TripcrewsAdapter tripcrewsAdapter;

    public TripcrewsOutModule() {
        tripcrewsMySQL = new TripcrewsMySQL();
        tripcrewsService = new TripcrewsService(tripcrewsMySQL);
        tripcrewsAdapter = new TripcrewsAdapter(tripcrewsService);
    }

    public TripcrewsAdapter module() {
        return tripcrewsAdapter; // Return the TripcrewsAdapter instance
    }

    
}
