package com.campuslands.modules.tripbookingdetails.application;

import java.util.List;
import java.util.Optional;
import com.campuslands.modules.tripbookingdetails.domain.models.Tripbookingdetails;
import com.campuslands.modules.tripbookingdetails.domain.repository.TripbookingdetailsRepository;

public class TripbookingdetailsService {
    private final TripbookingdetailsRepository tripbookingdetailsRepository;

    public TripbookingdetailsService(TripbookingdetailsRepository tripbookingdetailsRepository) {
        this.tripbookingdetailsRepository = tripbookingdetailsRepository;
    }

    public void createTripbookingdetail(Tripbookingdetails tripbookingdetail) {
        tripbookingdetailsRepository.save(tripbookingdetail);
    }

    public void updateTripbookingdetail(Tripbookingdetails tripbookingdetail) {
        tripbookingdetailsRepository.update(tripbookingdetail);
    }

    public Optional<Tripbookingdetails> getTripbookingdetailById(int id) {
        return tripbookingdetailsRepository.findById(id);
    }

    public void deleteTripbookingdetail(int id) {
        tripbookingdetailsRepository.delete(id);
    }

    public List<Tripbookingdetails> getAllTripbookingdetails() {
        return tripbookingdetailsRepository.findAll();
    }
}
