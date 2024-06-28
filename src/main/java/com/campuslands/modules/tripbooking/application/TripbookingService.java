package com.campuslands.modules.tripbooking.application;

import java.util.List;
import java.util.Optional;
import com.campuslands.modules.tripbooking.domain.models.TripBooking;
import com.campuslands.modules.tripbooking.domain.repository.TripBookingRepository;

public class TripbookingService {
    private final TripBookingRepository tripbookingRepository;

    public TripbookingService(TripBookingRepository tripbookingRepository) {
        this.tripbookingRepository = tripbookingRepository;
    }

    public void createTripbooking(TripBooking tripbooking) {
        tripbookingRepository.save(tripbooking);
    }

    public void updateTripbooking(TripBooking tripbooking) {
        tripbookingRepository.update(tripbooking);
    }

    public Optional<TripBooking> getTripbookingById(int id) {
        return tripbookingRepository.findById(id);
    }

    public void deleteTripbooking(int id) {
        tripbookingRepository.delete(id);
    }

    public List<TripBooking> getAllTripbookings() {
        return tripbookingRepository.findAll();
    }
}
