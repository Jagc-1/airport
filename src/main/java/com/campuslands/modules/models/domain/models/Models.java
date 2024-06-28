package com.campuslands.modules.models.domain.models;

/**
 * Models
 */
public class Models {

    int id;
    String name;
    int manuFactureId;
    
    public Models(int id, String name, int manuFactureId) {
        this.id = id;
        this.name = name;
        this.manuFactureId = manuFactureId;
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
    public int getManuFactureId() {
        return manuFactureId;
    }
    public void setManuFactureId(int manuFactureId) {
        this.manuFactureId = manuFactureId;
    }

    

}