package com.campuslands.modules.airlines.domain.models;

public class Airlines{
    private int id;
    private String name;


    public Airlines(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Airlines(String name) {
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