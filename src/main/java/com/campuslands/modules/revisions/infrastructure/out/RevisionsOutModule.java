package com.campuslands.modules.revisions.infrastructure.out;
import com.campuslands.modules.revisions.application.RevisionsService;
import com.campuslands.modules.revisions.infrastructure.in.RevisionsAdapter;

public class RevisionsOutModule {

    protected RevisionsMySqlRepository revisionsMySQL;
    protected RevisionsService revisionsService;
    protected RevisionsAdapter revisionsAdapter;

    public RevisionsOutModule() {
        revisionsMySQL = new RevisionsMySqlRepository(); // Initialize RevisionsMySQL instance
        revisionsService = new RevisionsService(revisionsMySQL); // Initialize RevisionsService with RevisionsMySQL
        revisionsAdapter = new RevisionsAdapter(revisionsService); // Initialize RevisionsAdapter with RevisionsService
    }

    public RevisionsAdapter module() {
        return revisionsAdapter; // Return the RevisionsAdapter instance
    }

    
    

}
