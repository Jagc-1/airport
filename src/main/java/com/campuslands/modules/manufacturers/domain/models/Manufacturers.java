package com.campuslands.modules.manufacturers.domain.models;

/**
 * Manufacturers
 */
public class Manufacturers {
    int id;
    String name;

    

    public Manufacturers(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    
}