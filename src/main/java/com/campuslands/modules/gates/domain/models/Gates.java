package com.campuslands.modules.gates.domain.models;

/**
 * Gates
 */
public class Gates {
    int id;
    String getNumber;
    String idAirport;

    
    public Gates(int id, String getNumber, String idAirport) {
        this.id = id;
        this.getNumber = getNumber;
        this.idAirport = idAirport;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getGetNumber() {
        return getNumber;
    }
    public void setGetNumber(String getNumber) {
        this.getNumber = getNumber;
    }
    public String getIdAirport() {
        return idAirport;
    }
    public void setIdAirport(String idAirport) {
        this.idAirport = idAirport;
    }

    
    
}