package com.campuslands.modules.flightfares.domain.models;

/**
 * Flightfares
 */
public class Flightfares {
    int id;
    String description;
    String details;
    int value;

    public Flightfares(int id, String description, String details, int value) {
        this.id = id;
        this.description = description;
        this.details = details;
        this.value = value;
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
    public String getDetails() {
        return details;
    }
    public void setDetails(String details) {
        this.details = details;
    }
    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }


    
}