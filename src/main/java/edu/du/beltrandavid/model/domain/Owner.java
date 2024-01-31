/**
 *
 * @author David Beltran
 * File: Owner.java
 * This file contains the Owner class that describes the owner of a vehicle
 */
package edu.du.beltrandavid.model.domain;

import java.util.Objects;

public class Owner {
  private String ownerId;
  private String firstName;
  private String lastName;
  private String phoneNumber;
  private int numYears;
  private Address address;

  /**
   * Constructor with no arguments
   */
  public Owner() {
    this.ownerId = "";
    this.firstName = "";
    this.lastName = "";
    this.phoneNumber = "";
  }

  /**
   *
   * @param ownerId
   * @param firstName
   * @param lastName
   * @param phoneNumber
   * @param numYears
   * @param address
   * Constructor that requires all attribute values as arguments.
   */
  public Owner(String ownerId, String firstName, String lastName, String phoneNumber, 
      int numYears, Address address) {
    this.ownerId = ownerId;
    this.firstName = firstName;
    this.lastName = lastName;
    this.phoneNumber = phoneNumber;
    this.numYears = numYears;
    this.address = address;
  }

  @Override
  public String toString() {
    return "Owner{" + "ownerId=" + ownerId + ", firstName=" + firstName + ", lastName=" + 
        lastName + ", phoneNumber=" + phoneNumber + ", numYears=" + numYears + 
        ", address=" + address + '}';
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
  public String getFirstName() {
    return firstName;
  }

  /**
   *
   * @param firstName
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName.toUpperCase();
  }

  /**
   *
   * @return
   */
  public String getLastName() {
    return lastName;
  }

  /**
   *
   * @param lastName
   */
  public void setLastName(String lastName) {
    this.lastName = lastName.toUpperCase();
  }

  /**
   *
   * @return
   */
  public String getPhoneNumber() {
    return phoneNumber;
  }

  /**
   *
   * @param phoneNumber
   */
  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  /**
   *
   * @return
   */
  public int getNumYears() {
    return numYears;
  }

  /**
   *
   * @param numYears
   */
  public void setNumYears(int numYears) {
    this.numYears = numYears;
  }

  /**
   *
   * @return
   */
  public Address getAddress() {
    return address;
  }

  /**
   *
   * @param address
   */
  public void setAddress(Address address) {
    this.address = address;
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
    final Owner other = (Owner) obj;
    if (this.numYears != other.numYears) {
      return false;
    }
    if (!Objects.equals(this.ownerId, other.ownerId)) {
      return false;
    }
    if (!Objects.equals(this.firstName, other.firstName)) {
      return false;
    }
    if (!Objects.equals(this.lastName, other.lastName)) {
      return false;
    }
    if (!Objects.equals(this.phoneNumber, other.phoneNumber)) {
      return false;
    }
    if (!Objects.equals(this.address, other.address)) {
      return false;
    }
    return true;
  }
  
  /**
   *
   * @return
   * Returns a Boolean value on whether or not an Owner object is considered a senior owner.
   */
  public boolean isSeniorOwner() {
    boolean retValue = false;
    if (this.numYears >= 20) {
      retValue = true;
    }
    return retValue;
  }
  
  /**
   *
   * @param bool
   * @return
   * Returns a String message indicating whether or not an 
   * Owner object is considered a senior owner.
   */
  public String displayIsSeniorOwner(boolean bool) {
    String display = "";
    if (bool == true) {
      display = this.firstName + " " + this.lastName + " is a senior owner.\n";
    } else {
      display = this.firstName + " " + this.lastName + " is not a senior owner.\n";
    }
    return display;
  }
}
