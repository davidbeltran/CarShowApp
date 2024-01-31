/**
 *
 * @author David Beltran
 * File: VehicleClassification.java
 * This file contains the enumerations for the different vehicle classification types
 */
package edu.du.beltrandavid.model.domain;

import java.io.Serializable;

public enum VehicleClassification implements Serializable {

  /**
   * Vehicle classification on a vehicle 1950 or older
   */
  ANTIQUE,

  /**
   * Vehicle classification on a vehicle between 1951 and 1980
   */
  CLASSIC,

  /**
   * Vehicle classification on a vehicle 1981 or newer
   */
  MODERN,
  
  /**
   * Vehicle classification if no value given
   */
  UNKNOWN;
  
  /**
   * Constructor with no arguments
   */
  VehicleClassification(){
  }
}
