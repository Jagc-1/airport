package com.campuslands.modules.documenttypes.domain.repository;
import java.util.List;
import java.util.Optional;
import com.campuslands.modules.documenttypes.domain.models.DocumentType;
//import com.campuslands.modules.documenttypes.domain.models.DocumentTypesRepository;

public interface DocumentTypesRepository {
    void save(DocumentType documentTypes);
    void update(DocumentType documentTypes);
    Optional<DocumentType> findById(int id);
    void delete(int id);
    List<DocumentType> findAll();
}
