package com.campuslands.modules.tripulationroles.domain.models;

/**
 * Tripulationroles
 */
public class Tripulationroles {
    int id;
    String name;

    public Tripulationroles(String name) {

        this.name = name;
    }

    public Tripulationroles(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
