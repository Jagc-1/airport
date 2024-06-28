package com.campuslands.modules.revision_details.domain.models;

/**
 * Revision_details
 */
public class RevisionDetails {

    int id;
    String description;
    int id_employee;

    
    public RevisionDetails(int id, String description, int id_employee) {
        this.id = id;
        this.description = description;
        this.id_employee = id_employee;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public int getId_employee() {
        return id_employee;
    }
    public void setId_employee(int id_employee) {
        this.id_employee = id_employee;
    }

    
}