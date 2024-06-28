package com.campuslands.modules.revemployee.domain.models;

/**
 * Revemployee
 */
public class Revemployee {
    int idEmployee;
    int idRevision;

    public Revemployee(int idEmployee, int idRevision) {
        this.idEmployee = idEmployee;
        this.idRevision = idRevision;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public int getIdRevision() {
        return idRevision;
    }

    public void setIdRevision(int idRevision) {
        this.idRevision = idRevision;
    }

}