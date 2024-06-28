package com.campuslands.modules.revision_details.infrastructure.out;
import com.campuslands.modules.revision_details.application.RevisionDetailsService;
import com.campuslands.modules.revision_details.infrastructure.in.Revision_detailsAdapter;

public class Revision_detailsOutModule {

    protected Revision_detailsMySQL revisionDetailsMySQL;
    protected RevisionDetailsService revisionDetailsService;
    protected Revision_detailsAdapter revisionDetailsAdapter;

    public Revision_detailsOutModule() {
        revisionDetailsMySQL = new Revision_detailsMySQL(); // Initialize RevisionDetailsMySQL instance
        revisionDetailsService = new RevisionDetailsService(revisionDetailsMySQL); // Initialize RevisionDetailsService
                                                                                   // with RevisionDetailsMySQL
        revisionDetailsAdapter = new Revision_detailsAdapter(revisionDetailsService); // Initialize
                                                                                      // RevisionDetailsAdapter with
                                                                                      // RevisionDetailsService
    }

    public Revision_detailsAdapter module() {
        return revisionDetailsAdapter; // Return the RevisionDetailsAdapter instance
    }

}
