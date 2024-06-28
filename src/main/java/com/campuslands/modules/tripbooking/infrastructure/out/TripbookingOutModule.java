package com.campuslands.modules.tripbooking.infrastructure.out;

import com.campuslands.modules.tripbooking.application.TripbookingService;
import com.campuslands.modules.tripbooking.infrastructure.in.TripbookingAdapter;

public class TripbookingOutModule {

    protected TripbookingMySQL tripbookingMySQL;
    protected TripbookingService tripbookingService;
    protected TripbookingAdapter tripbookingAdapter;

    public TripbookingOutModule() {
        tripbookingMySQL = new TripbookingMySQL(); 
        tripbookingService = new TripbookingService(tripbookingMySQL); 
        tripbookingAdapter = new TripbookingAdapter(tripbookingService); 
    }

    public TripbookingAdapter module() {
        return tripbookingAdapter; 
    }

   

}
