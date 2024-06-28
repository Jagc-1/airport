package com.campuslands.modules.tripbooking.domain.repository;

import java.util.List;
import java.util.Optional;
import com.campuslands.modules.tripbooking.domain.models.TripBooking;

public interface TripBookingRepository {
    void save(TripBooking tripBooking);
    void update(TripBooking tripBooking);
    Optional<TripBooking> findById(int id);
    void delete(int id);
    List<TripBooking> findAll();
}