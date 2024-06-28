package com.campuslands.modules.revision_details.domain.repository;

import java.util.List;
import java.util.Optional;
import com.campuslands.modules.revision_details.domain.models.RevisionDetails;

public interface RevisionDetailsRepository {
    void save(RevisionDetails revisionDetails);
    void update(RevisionDetails revisionDetails);
    Optional<RevisionDetails> findById(int id);
    void delete(int id);
    List<RevisionDetails> findAll();
}