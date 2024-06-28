package com.campuslands.modules.planes.domain.models;

public class Planes {

    int id;
    String plateNumber;
    int capacity;
    String fabrication_date;
    int id_status;
    int id_model;

    public Planes(String plateNumber, int capacity, String fabrication_date, int id_status, int id_model) {
        this.plateNumber = plateNumber;
        this.capacity = capacity;
        this.fabrication_date = fabrication_date;
        this.id_status = id_status;
        this.id_model = id_model;
    }

    public Planes(int id, String plateNumber, int capacity, String fabrication_date, int id_status, int id_model) {
        this.id = id;
        this.plateNumber = plateNumber;
        this.capacity = capacity;
        this.fabrication_date = fabrication_date;
        this.id_status = id_status;
        this.id_model = id_model;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlates(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getFabrication_date() {
        return fabrication_date;
    }

    public void setFabrication_date(String fabrication_date) {
        this.fabrication_date = fabrication_date;
    }

    public int getId_status() {
        return id_status;
    }

    public void setId_status(int id_status) {
        this.id_status = id_status;
    }

    public int getId_model() {
        return id_model;
    }

    public void setId_model(int id_model) {
        this.id_model = id_model;
    }

}
