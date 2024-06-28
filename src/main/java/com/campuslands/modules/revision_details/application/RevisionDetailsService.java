package com.campuslands.modules.revision_details.application;

import java.util.List;
import java.util.Optional;
import com.campuslands.modules.revision_details.domain.repository.RevisionDetailsRepository;
import com.campuslands.modules.revision_details.domain.models.RevisionDetails;

public class RevisionDetailsService {
    private final RevisionDetailsRepository revisionDetailsRepository;

    public RevisionDetailsService(RevisionDetailsRepository revisionDetailsRepository) {
        this.revisionDetailsRepository = revisionDetailsRepository;
    }

    public void createRevisionDetail(RevisionDetails revisionDetail) {
        revisionDetailsRepository.save(revisionDetail);
    }

    public void updateRevisionDetail(RevisionDetails revisionDetail) {
        revisionDetailsRepository.update(revisionDetail);
    }

    public Optional<RevisionDetails> getRevisionDetailById(int id) {
        return revisionDetailsRepository.findById(id);
    }

    public void deleteRevisionDetail(int id) {
        revisionDetailsRepository.delete(id);
    }

    public List<RevisionDetails> getAllRevisionDetails() {
        return revisionDetailsRepository.findAll();
    }
}
