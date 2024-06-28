package com.campuslands.modules.tripcrews.application;

import java.util.List;
import java.util.Optional;
import com.campuslands.modules.tripcrews.domain.models.Tripcrews;
import com.campuslands.modules.tripcrews.domain.repository.TripcrewsRepository;

public class TripcrewsService {
    private final TripcrewsRepository tripcrewsRepository;

    public TripcrewsService(TripcrewsRepository tripcrewsRepository) {
        this.tripcrewsRepository = tripcrewsRepository;
    }

    public void createTripcrew(Tripcrews tripcrew) {
        tripcrewsRepository.save(tripcrew);
    }

    public void updateTripcrew(Tripcrews tripcrew) {
        tripcrewsRepository.update(tripcrew);
    }

    public Optional<Tripcrews> getTripcrewById(int id) {
        return tripcrewsRepository.findById(id);
    }

    public void deleteTripcrew(int id) {
        tripcrewsRepository.delete(id);
    }

    public List<Tripcrews> getAllTripcrews() {
        return tripcrewsRepository.findAll();
    }
}
