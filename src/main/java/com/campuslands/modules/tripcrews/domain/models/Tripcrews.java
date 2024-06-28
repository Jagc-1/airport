package com.campuslands.modules.tripcrews.domain.models;

public class Tripcrews {
    int idemployees;
    int idconection;

    public Tripcrews(int idemployees, int idconection) {
        this.idemployees = idemployees;
        this.idconection = idconection;
    }

    public int getIdemployees() {
        return idemployees;
    }

    public void setIdemployees(int idemployees) {
        this.idemployees = idemployees;
    }

    public int getIdconection() {
        return idconection;
    }

    public void setIdconection(int idconection) {
        this.idconection = idconection;
    }

}