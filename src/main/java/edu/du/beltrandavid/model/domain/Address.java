/**
 *
 * @author David Beltran
 * File: Address.java
 * This file contains the Address class that describes a street address. 
 */
package edu.du.beltrandavid.model.domain;

import java.util.Objects;

public class Address {
  private String street1;
  private String street2;
  private String city;
  private String state;
  private String zipCode;

  /**
   * Constructor with no arguments
   */
  public Address() {
    this.street1 = "";
    this.street2 = "";
    this.city = "";
    this.state = "";
    this.zipCode = "";
  }

  /**
   *
   * @param street1
   * @param street2
   * @param city
   * @param state
   * @param zipCode
   * Constructor that requires all attribute values as arguments.
   */
  public Address(String street1, String street2, String city, String state, String zipCode) {
    this.street1 = street1;
    this.street2 = street2;
    this.city = city;
    this.state = state;
    this.zipCode = zipCode;
  }

  @Override
  public String toString() {
    return "Address{" + "street1=" + street1 + ", street2=" + street2 + ", city=" + city + 
        ", state=" + state + ", zipCode=" + zipCode + '}';
  }
  
  /**
   *
   * @return
   */
  public String getStreet1() {
    return street1;
  }

  /**
   *
   * @param street1
   */
  public void setStreet1(String street1) {
    this.street1 = street1.toUpperCase();
  }

  /**
   *
   * @return
   */
  public String getStreet2() {
    return street2;
  }

  /**
   *
   * @param street2
   */
  public void setStreet2(String street2) {
    this.street2 = street2.toUpperCase();
  }

  /**
   *
   * @return
   */
  public String getCity() {
    return city;
  }

  /**
   *
   * @param city
   */
  public void setCity(String city) {
    this.city = city.toUpperCase();
  }

  /**
   *
   * @return
   */
  public String getState() {
    return state;
  }

  /**
   *
   * @param state
   */
  public void setState(String state) {
    this.state = state.toUpperCase();
  }

  /**
   *
   * @return
   */
  public String getZipCode() {
    return zipCode;
  }

  /**
   *
   * @param zipCode
   */
  public void setZipCode(String zipCode) {
    this.zipCode = zipCode;
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
    final Address other = (Address) obj;
    if (!Objects.equals(this.street1, other.street1)) {
      return false;
    }
    if (!Objects.equals(this.street2, other.street2)) {
      return false;
    }
    if (!Objects.equals(this.city, other.city)) {
      return false;
    }
    if (!Objects.equals(this.state, other.state)) {
      return false;
    }
    if (!Objects.equals(this.zipCode, other.zipCode)) {
      return false;
    }
    return true;
  }
}
