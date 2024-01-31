/**
 *
 * @author David Beltran
 * File: CarShowOwner.java
 * This file contains the CarShowOwner class that describes owner of a car show event.
 */
package edu.du.beltrandavid.model.domain;

import java.util.Objects;

public class CarShowOwner {
  private String carShowId;
  private String ownerId;

  /**
   * Constructor with no arguments
   */
  public CarShowOwner() {
    this.carShowId = "";
    this.ownerId = "";
  }

  /**
   *
   * @param carShowId
   * @param ownerId
   * Constructor that requires all attribute values as arguments.
   */
  public CarShowOwner(String carShowId, String ownerId) {
    this.carShowId = carShowId;
    this.ownerId = ownerId;
  }

  @Override
  public String toString() {
    return "CarShowOwner{" + "carShowId=" + carShowId + ", ownerId=" + ownerId + '}';
  }

  /**
   *
   * @return
   */
  public String getCarShowId() {
    return carShowId;
  }

  /**
   *
   * @param carShowId
   */
  public void setCarShowId(String carShowId) {
    this.carShowId = carShowId;
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
    this.ownerId = ownerId;
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
    final CarShowOwner other = (CarShowOwner) obj;
    if (!Objects.equals(this.carShowId, other.carShowId)) {
      return false;
    }
    if (!Objects.equals(this.ownerId, other.ownerId)) {
      return false;
    }
    return true;
  }
}
