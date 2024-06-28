package com.campuslands.modules.revisions.application;

import java.util.List;
import java.util.Optional;
import com.campuslands.modules.revisions.domain.models.Revisions;
import com.campuslands.modules.revisions.domain.repository.RevisionsRepository;

public class RevisionsService {
    private final RevisionsRepository revisionsRepository;

    public RevisionsService(RevisionsRepository revisionsRepository) {
        this.revisionsRepository = revisionsRepository;
    }

    public void createRevision(Revisions revision) {
        revisionsRepository.save(revision);
    }

    public void updateRevision(Revisions revision) {
        revisionsRepository.update(revision);
    }

    public Optional<Revisions> getRevisionById(int id) {
        return revisionsRepository.findById(id);
    }

    public void deleteRevision(int id) {
        revisionsRepository.delete(id);
    }

    public List<Revisions> getAllRevisions() {
        return revisionsRepository.findAll();
    }
}
