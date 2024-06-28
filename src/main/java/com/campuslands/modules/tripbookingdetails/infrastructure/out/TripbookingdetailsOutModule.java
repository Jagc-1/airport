package com.campuslands.modules.tripbookingdetails.infrastructure.out;
import com.campuslands.modules.tripbookingdetails.application.TripbookingdetailsService;
import com.campuslands.modules.tripbookingdetails.infrastructure.in.TripbookingdetailsAdapter;


public class TripbookingdetailsOutModule {
    protected TripBookingdetailsMySQL tripBookingDetailsMySQL;
    protected TripbookingdetailsService tripBookingDetailsService;
    protected TripbookingdetailsAdapter tripBookingDetailsAdapter;

    public TripbookingdetailsOutModule() {
        tripBookingDetailsMySQL = new TripBookingdetailsMySQL();
        tripBookingDetailsAdapter = new TripbookingdetailsAdapter(tripBookingDetailsService);
    }

    public TripbookingdetailsAdapter module() {
        return tripBookingDetailsAdapter;
    }

   
}
