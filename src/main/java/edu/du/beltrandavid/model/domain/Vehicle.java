/**
 *
 * @author David Beltran
 * File: Vehicle.java
 * This file contains the Vehicle class that describes a vehicle from a car show.
 */
package edu.du.beltrandavid.model.domain;

import static edu.du.beltrandavid.model.domain.VehicleClassification.ANTIQUE;
import static edu.du.beltrandavid.model.domain.VehicleClassification.CLASSIC;
import static edu.du.beltrandavid.model.domain.VehicleClassification.MODERN;
import static edu.du.beltrandavid.model.domain.VehicleClassification.UNKNOWN;
import java.io.Serializable;
import java.util.Objects;

public class Vehicle implements Serializable {
  private String vehicleId;
  private String ownerId;
  private String manufacturer;
  private int modelYear;
  private String model;
  private String submodel;
  private VehicleClassification vehicleClassification;
  private boolean isInsured;

  /**
   * Constructor with no arguments
   */
  public Vehicle() {
    this.vehicleId = "";
    this.ownerId = "";
    this.manufacturer = "";
    this.model = "";
    this.submodel = "";
  }

  /**
   *
   * @param vehicleId
   * @param ownerId
   * @param manufacturer
   * @param modelYear
   * @param model
   * @param submodel
   * @param vehicleClassification
   * @param isInsured
   * Constructor that requires all attribute values as arguments.
   * isInsured attribute is filled with a Boolean value.
   */
  public Vehicle(String vehicleId, String ownerId, int modelYear, String manufacturer,  
      String model, String submodel, VehicleClassification vehicleClassification, 
      boolean isInsured) {
    this.vehicleId = vehicleId;
    this.ownerId = ownerId;
    this.manufacturer = manufacturer;
    this.modelYear = modelYear;
    this.model = model;
    this.submodel = submodel;
    this.vehicleClassification = vehicleClassification;
    this.isInsured = isInsured;
  }

  /**
   *
   * @param vehicleId
   * @param ownerId
   * @param manufacturer
   * @param modelYear
   * @param model
   * @param submodel
   * @param vehicleClassification
   * @param isInsured
   * Constructor that requires all attribute values as arguments.
   * isInsured attribute is filled with a char value.
   */
  public Vehicle(String vehicleId, String ownerId, int modelYear, String manufacturer,  
      String model, String submodel, VehicleClassification vehicleClassification, 
      char isInsured) {
    this.vehicleId = vehicleId;
    this.ownerId = ownerId;
    this.manufacturer = manufacturer;
    this.modelYear = modelYear;
    this.model = model;
    this.submodel = submodel;
    this.vehicleClassification = vehicleClassification;
    this.isInsured = false;
    if (isInsured == 'T' || isInsured == 't' || isInsured == 'y' || isInsured == 'Y') {
      this.isInsured = true;
    }
  }
  
  /**
   *
   * @param vehicleId
   * @param ownerId
   * @param manufacturer
   * @param modelYear
   * @param model
   * @param submodel
   * @param vehicleClassification
   * @param isInsured
   * Constructor that requires all attribute values as arguments.
   * isInsured attribute is filled with a String value.
   */
  public Vehicle(String vehicleId, String ownerId, int modelYear, String manufacturer, 
      String model, String submodel, VehicleClassification vehicleClassification, 
      String isInsured) {
    this.vehicleId = vehicleId;
    this.ownerId = ownerId;
    this.manufacturer = manufacturer;
    this.modelYear = modelYear;
    this.model = model;
    this.submodel = submodel;
    this.vehicleClassification = vehicleClassification;
    this.isInsured = false;
    if (isInsured.equals("TRUE") || isInsured.equals("true") || isInsured.equals("True")) {
      this.isInsured = true;
    }
  }
  
  @Override
  public String toString() {
    return "Vehicle{" + "vehicleId=" + vehicleId + ", ownerId=" + ownerId + 
        ", manufacturer=" + manufacturer + ", modelYear=" + modelYear + ", model=" + model + 
        ", submodel=" + submodel + ", vehicleClassification=" + vehicleClassification + 
        ", isInsured=" + isInsured + '}';
  }
  
  /**
   *
   * @return
   */
  public String getVehicleId() {
    return vehicleId;
  }

  /**
   *
   * @param vehicleId
   */
  public void setVehicleId(String vehicleId) {
    this.vehicleId = vehicleId.toUpperCase();
  }

  /**
   *
   * @return
   */
  public String getOwnerId() {
    return ownerId;
  }

  /**
   *
   * @param ownerId
   */
  public void setOwnerId(String ownerId) {
    this.ownerId = ownerId.toUpperCase();
  }

  /**
   *
   * @return
   */
  public String getManufacturer() {
    return manufacturer;
  }

  /**
   *
   * @param manufacturer
   */
  public void setManufacturer(String manufacturer) {
    this.manufacturer = manufacturer.toUpperCase();
  }

  /**
   *
   * @return
   */
  public int getModelYear() {
    return modelYear;
  }

  /**
   *
   * @param modelYear
   */
  public void setModelYear(int modelYear) {
    this.modelYear = modelYear;
  }

  /**
   * @return
   */
  public String getModel() {
    return model;
  }
  
  /**
   * @param model
   */
  public void setModel(String model) {
    this.model = model.toUpperCase();
  }
  
  /**
   *
   * @return
   */
  public String getSubmodel() {
    return submodel;
  }

  /**
   *
   * @param submodel
   */
  public void setSubmodel(String submodel) {
    this.submodel = submodel.toUpperCase();
  }

  /**
   *
   * @return
   */
  public VehicleClassification getVehicleClassification() {
    return vehicleClassification;
  }

  /**
   *
   * @param vehicleClassification
   * setter uses VehicleClassification enumeration argument
   */
  public void setVehicleClassification(VehicleClassification vehicleClassification) {
    this.vehicleClassification = vehicleClassification;
  }

  /**
   *
   * @param vehicleClassification
   * setter uses char argument
   */
  public void setVehicleClassification(char vehicleClassification) {
    switch (vehicleClassification) {
      case 'a': case 'A':
        this.vehicleClassification = ANTIQUE;
        break;
      case 'c': case 'C':
        this.vehicleClassification = CLASSIC;
        break;
      case 'm': case 'M':
        this.vehicleClassification = MODERN;
        break;
      default:
        this.vehicleClassification = null;
        break;
    }
  }
  
  /**
   *
   * @return
   */
  public boolean isInsured() {
    return isInsured;
  }

  /**
   *
   * @param isInsured
   */
  public void setIsInsured(boolean isInsured) {
    this.isInsured = isInsured;
  }

  /**
   *
   * @param isInsured
   * setter uses char argument
   */
  public void setIsInsured(char isInsured) {
    this.isInsured = false;
    if (isInsured == 'T' || isInsured == 't'|| isInsured == 'y' || isInsured == 'Y') {
      this.isInsured = true;
    }
  }
  
  /**
   *
   * @param isInsured
   * setter uses String argument
   */
  public void setIsInsured(String isInsured) {
    this.isInsured = false;
    if (isInsured.equals("TRUE") || isInsured.equals("true") || isInsured.equals("True") ||
        isInsured.equals("y") || isInsured.equals("Y") || isInsured.equals("T") || 
        isInsured.equals("t")) {
      this.isInsured = true;
    }
  }
  /*
  public String getIsInsured() {
    return String.valueOf(this.isInsured);
  }
  */
  
  public boolean getIsInsured() {
    return this.isInsured;
  }
  
  @Override
  public int hashCode() {
    int hash = 7;
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final Vehicle other = (Vehicle) obj;
    if (this.modelYear != other.modelYear) {
      return false;
    }
    if (this.isInsured != other.isInsured) {
      return false;
    }
    if (!Objects.equals(this.vehicleId, other.vehicleId)) {
      return false;
    }
    if (!Objects.equals(this.ownerId, other.ownerId)) {
      return false;
    }
    if (!Objects.equals(this.manufacturer, other.manufacturer)) {
      return false;
    }
    if (!Objects.equals(this.submodel, other.submodel)) {
      return false;
    }
    if (!Objects.equals(this.vehicleClassification, other.vehicleClassification)) {
      return false;
    }
    return true;
  }
  
  /**
   *
   * @return
   * Checks if Vehicle object was classified correctly.
   * Returns a Boolean value.
   */
  public boolean validateVehicleClassification() {
    boolean retValue = true;
    if ((this.vehicleClassification.equals(ANTIQUE)) && (this.modelYear > 1950)) {
      retValue = false;
    } else if ((this.vehicleClassification.equals(CLASSIC)) 
        && (this.modelYear < 1951 || this.modelYear > 1980)) {
      retValue = false;
    } else if ((this.vehicleClassification.equals(MODERN)) && (this.modelYear < 1981)) {
      retValue = false;
    } else if(this.vehicleClassification.equals(UNKNOWN)) {
      retValue = false;
    }
    return retValue;
  }
  
  /**
   *
   * @param bool
   * If Vehicle object was classified incorrectly, VehicleClassification is set to correct
   * enumeration based on modelYear.
   * Returns a String message indicating if Vehicle object was classified correctly or not.
   * If not correctly classified message indicates also that the classification was corrected.
   */
  public void adjustVehicleClassification(boolean bool) {
    if (bool == false) {
      if (this.modelYear <= 1950) {
        this.setVehicleClassification(ANTIQUE);
      } else if (this.modelYear > 1950 && this.modelYear < 1981) {
        this.setVehicleClassification(CLASSIC);
      } else {
        this.setVehicleClassification(MODERN);
      }
      System.out.println("Vehicle " + this.vehicleId + 
          " was classified incorrectly. Classification has been reset.\n"
              + this.toString() + "\n");
    } else {
      System.out.println("Vehicle " + this.vehicleId + " was classified correctly.\n");
    }
  }
}
