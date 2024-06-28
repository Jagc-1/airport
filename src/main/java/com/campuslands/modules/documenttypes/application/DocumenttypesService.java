package com.campuslands.modules.documenttypes.application;

import java.util.List;
import java.util.Optional;
import com.campuslands.modules.documenttypes.domain.models.DocumentType;
import com.campuslands.modules.documenttypes.domain.repository.DocumentTypesRepository;

public class DocumenttypesService {
    private final DocumentTypesRepository documentTypesRepository;

    public DocumenttypesService(DocumentTypesRepository documentTypesRepository) {
        this.documentTypesRepository = documentTypesRepository;
    }

    public void createDocumentType(DocumentType documentType) {
        documentTypesRepository.save(documentType);
    }

    public void updateDocumentType(DocumentType documentType) {
        documentTypesRepository.update(documentType);
    }

    public Optional<DocumentType> getDocumentTypeById(int id) {
        return documentTypesRepository.findById(id);
    }

    public void deleteDocumentType(int id) {
        documentTypesRepository.delete(id);
    }

    public List<DocumentType> getAllDocumentTypes() {
        return documentTypesRepository.findAll();
    }
}
