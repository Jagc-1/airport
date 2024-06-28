package com.campuslands.modules.airports.domain.models;

public class Airport{

  private int id ;
  private String name;
  private int idCity;


  public Airport(int id, String name, int idCity) {
    this.id = id;
    this.name = name;
    this.idCity = idCity;
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
  public int getIdCity() {
    return idCity;
  }
  public void setIdCity(int idCity) {
    this.idCity = idCity;
  }

  



}