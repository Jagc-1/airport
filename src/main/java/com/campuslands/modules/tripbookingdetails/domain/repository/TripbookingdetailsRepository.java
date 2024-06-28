package com.campuslands.modules.tripbookingdetails.domain.repository;

import java.util.List;
import java.util.Optional;
import com.campuslands.modules.tripbookingdetails.domain.models.Tripbookingdetails;

public interface TripbookingdetailsRepository {
    void save(Tripbookingdetails tripBookingDetails);
    void update(Tripbookingdetails tripBookingDetails);
    Optional<Tripbookingdetails> findById(int id);
    void delete(int id);
    List<Tripbookingdetails> findAll();
}