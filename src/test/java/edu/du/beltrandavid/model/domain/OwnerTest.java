/**
 *
 * @author David Beltran
 * File: OwnerTest.java
 * This file contains unit tests for the Owner class.
 */
package edu.du.beltrandavid.model.domain;

import org.junit.Test;
import static org.junit.Assert.*;

public class OwnerTest {

  /**
   * Tests "happy path" if owner is considered a senior with the minimum requirement
   */
  @Test
  public void isSeniorOwner20Test() {
    Owner owner = new Owner();
    owner.setNumYears(20);
    boolean expectedValue = true;
    assertEquals(owner.isSeniorOwner(), expectedValue);
  }
  
  /**
   * Tests "happy path" if owner is considered a senior with a higher value
   */
  @Test
  public void isSeniorOwner21Test() {
    Owner owner = new Owner();
    owner.setNumYears(21);
    boolean expectedValue = true;
    assertEquals(owner.isSeniorOwner(), expectedValue);
  }
  
  /**
   * Test negative path if owner does not meet a senior classification with a max numYears value
   */
  @Test
  public void isSeniorOwner19Test() {
    Owner owner = new Owner();
    owner.setNumYears(19);
    boolean expectedValue = false;
    assertEquals(owner.isSeniorOwner(), expectedValue);
  }
  
  /**
   * Tests the correct String message displays if Owner object is not considered a senior owner.
   */
  @Test
  public void displayIsNotSeniorOwnerTest() {
    Owner owner = new Owner();
    owner.setNumYears(19); 
    owner.setFirstName("Jon"); 
    owner.setLastName("Doe");
    String expectedValue = "JON DOE is not a senior owner.\n";
    assertEquals(owner.displayIsSeniorOwner(owner.isSeniorOwner()), expectedValue);
  }
  
  /**
   * Tests the correct String message displays if Owner object is considered a senior owner.
   */
  @Test
  public void displayIsSeniorOwnerTest() {
    Owner owner = new Owner();
    owner.setNumYears(21); 
    owner.setFirstName("Jon"); 
    owner.setLastName("Doe");
    String expectedValue = "JON DOE is a senior owner.\n";
    assertEquals(owner.displayIsSeniorOwner(owner.isSeniorOwner()), expectedValue);
  }
}
