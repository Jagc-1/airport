package com.campuslands.modules.tripbookingdetails.domain.models;

/**
 * Tripbookingdetails
 */
public class Tripbookingdetails {
int id;
int idtripbooking;
String idcustomers;
int idfares;
 
      public Tripbookingdetails(int id, int idtripbooking, String idcustomers, int idfares) {
        this.id = id;
        this.idtripbooking = idtripbooking;
        this.idcustomers = idcustomers;
        this.idfares = idfares;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdtripbooking() {
        return idtripbooking;
    }

    public void setIdtripbooking(int idtripbooking) {
        this.idtripbooking = idtripbooking;
    }

    public String getIdcustomers() {
        return idcustomers;
    }

    public void setIdcustomers(String idcustomers) {
        this.idcustomers = idcustomers;
    }

    public int getIdfares() {
        return idfares;
    }

    public void setIdfares(int idfares) {
        this.idfares = idfares;
    }
    
}