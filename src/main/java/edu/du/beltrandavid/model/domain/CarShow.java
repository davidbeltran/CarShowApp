/**
 *
 * @author David Beltran
 * File: CarShow.java
 * This file contains the CarShow class that describes the needed details for a car show event.
 */
package edu.du.beltrandavid.model.domain;

import java.time.LocalDate;
import java.util.Objects;

public class CarShow {
  private String carShowId;
  private String carShowTitle;
  private LocalDate carShowDate;
  private boolean isSanctioned;

  /**
   * Constructor with no arguments
   */
  public CarShow() {
    this.carShowId = "";
    this.carShowTitle = "";
  }

  /**
   *
   * @param carShowId
   * @param carShowTitle
   * @param carShowDate
   * @param isSanctioned
   * Constructor that requires all attribute values as arguments.
   * isSanctioned attribute is filled with a Boolean value.
   */
  public CarShow(String carShowId, String carShowTitle, LocalDate carShowDate,
      boolean isSanctioned) {
    this.carShowId = carShowId;
    this.carShowTitle = carShowTitle;
    this.carShowDate = carShowDate;
    this.isSanctioned = isSanctioned;
  }

  /**
   *
   * @param carShowId
   * @param carShowTitle
   * @param carShowDate
   * @param isSanctioned
   * isSanctioned attribute is filled with a char value.
   */
  public CarShow(String carShowId, String carShowTitle, LocalDate carShowDate,
      char isSanctioned) {
    this.carShowId = carShowId;
    this.carShowTitle = carShowTitle;
    this.carShowDate = carShowDate;
    this.isSanctioned = false;
    if (isSanctioned == 'T' || isSanctioned == 't' || isSanctioned == 'y' || 
        isSanctioned == 'Y') {
      this.isSanctioned = true;
    }
  }
  
  /**
   *
   * @param carShowId
   * @param carShowTitle
   * @param carShowDate
   * @param isSanctioned
   * isSanctioned attribute is filled with a String value.
   */
  public CarShow(String carShowId, String carShowTitle, LocalDate carShowDate,
      String isSanctioned) {
    this.carShowId = carShowId;
    this.carShowTitle = carShowTitle;
    this.carShowDate = carShowDate;
    this.isSanctioned = false;
    if (isSanctioned.equals("TRUE") || isSanctioned.equals("true") 
        || isSanctioned.equals("True")) {
      this.isSanctioned = true;
    }
  }
  
  @Override
  public String toString() {
    return "CarShow{" + "carShowId=" + carShowId + ", carShowTitle=" + carShowTitle + 
        ", carShowDate=" + carShowDate + ", isSanctioned=" + isSanctioned + '}';
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
    this.carShowId = carShowId.toUpperCase();
  }

  /**
   *
   * @return
   */
  public String getCarShowTitle() {
    return carShowTitle;
  }

  /**
   *
   * @param carShowTitle
   */
  public void setCarShowTitle(String carShowTitle) {
    this.carShowTitle = carShowTitle.toUpperCase();
  }

  /**
   *
   * @return
   */
  public LocalDate getCarShowDate() {
    return carShowDate;
  }

  /**
   *
   * @param carShowDate
   */
  public void setCarShowDate(LocalDate carShowDate) {
    this.carShowDate = carShowDate;
  }

  /**
   *
   * @param isSanctioned
   */
  public void setIsSanctioned(boolean isSanctioned) {
    this.isSanctioned = isSanctioned;
  }

  /**
   *
   * @param isSanctioned
   * setter uses char argument
   */
  public void setIsSanctioned(char isSanctioned) {
    this.isSanctioned = false;
    if (isSanctioned == 'T' || isSanctioned == 't' || isSanctioned == 'Y' 
        || isSanctioned == 'y') {
      this.isSanctioned = true;
    }
  }
  
  /**
   *
   * @param isSanctioned
   * setter uses String argument
   */
  public void setIsSanctioned(String isSanctioned) {
    this.isSanctioned = false;
    if (isSanctioned.equals("TRUE") || isSanctioned.equals("true") 
        || isSanctioned.equals("True") || isSanctioned.equals("YES") 
        || isSanctioned.equals("yes") || isSanctioned.equals("Yes")
        || isSanctioned.equals("y") || isSanctioned.equals("Y")) {
      this.isSanctioned = true;
    }
  }
  
  /**
   *
   * @param isSanctioned
   * setter uses int argument
   */
  public void setIsSanctioned(int isSanctioned) {
    this.isSanctioned = true;
    if (isSanctioned == 0) {
      this.isSanctioned = false;
    }
  }
  
  public boolean getIsSanctioned() {
    return this.isSanctioned;
  }
  
  /**
   *
   * @param bool
   * Displays message on whether a CarShow object is sanctioned or not
   */
  public String displayIsSanctioned(boolean bool) {
    String display = "";
    if (bool == true) {
      display = this.carShowTitle + " is sanctioned.\n";
    } else {
      display = this.carShowTitle + " is NOT sanctioned.\n";
    }
    return display;
  }
  
  @Override
  public int hashCode() {
    int hash = 3;
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
    final CarShow other = (CarShow) obj;
    if (this.isSanctioned != other.isSanctioned) {
      return false;
    }
    if (!Objects.equals(this.carShowId, other.carShowId)) {
      return false;
    }
    if (!Objects.equals(this.carShowTitle, other.carShowTitle)) {
      return false;
    }
    if (!Objects.equals(this.carShowDate, other.carShowDate)) {
      return false;
    }
    return true;
  }
  
  /**
   *
   * @return
   * Returns a Boolean value on whether a CarShow object is sanctioned or not
   */
  public boolean isSanctioned() {
    return this.isSanctioned;
  }
}
