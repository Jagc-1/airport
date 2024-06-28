package com.campuslands.modules.documenttypes.infrastructure.out;
import com.campuslands.modules.documenttypes.application.DocumenttypesService;
import com.campuslands.modules.documenttypes.infrastructure.in.DocumenttypesAdapter;

public class DocumenttypesOutModule {

    protected DocumenttypesMySQL DocumentTypesMySQL;
    protected DocumenttypesService DocumentTypesService;
    protected DocumenttypesAdapter DocumentTypesAdapter;

    public DocumenttypesOutModule() {
        DocumentTypesMySQL = new DocumenttypesMySQL();
        DocumentTypesService = new DocumenttypesService(DocumentTypesMySQL);
        DocumentTypesAdapter = new DocumenttypesAdapter(DocumentTypesService);
    }

    public DocumenttypesAdapter module() {
        return DocumentTypesAdapter;
    }

   
}
