/**
 *
 * @author David Beltran
 * File: VehicleTest.java
 * This file contains unit tests for the Vehicle class.
 */
package edu.du.beltrandavid.model.domain;

import static edu.du.beltrandavid.model.domain.VehicleClassification.ANTIQUE;
import static edu.du.beltrandavid.model.domain.VehicleClassification.CLASSIC;
import static edu.du.beltrandavid.model.domain.VehicleClassification.MODERN;
import org.junit.Test;
import static org.junit.Assert.*;

public class VehicleTest { 

  /**
   * Tests the Vehicle constructor that takes a Boolean argument
   */
  @Test
  public void vehicleBooleanConstructorTest() {
    //checks Boolean true value was captured correctly
    Vehicle car = new Vehicle("1", "2", 2000, "Ford", "Mustang", "GT", MODERN, true);
    boolean expectedValue = true;
    assertEquals(expectedValue, car.isInsured());
    
    //checks Boolean false value was captured correctly
    Vehicle car2 = new Vehicle("1", "2", 2000, "Ford", "Mustang", "GT", MODERN, false);
    expectedValue = false;
    assertEquals(expectedValue, car2.isInsured());
  }

  /**
   * Tests the Vehicle constructor that takes a char argument
   */
  @Test
  public void vehicleCharConstructorTest() {
    // Checks "happy path" of using char 't' value
    Vehicle car = new Vehicle("1", "2", 2000, "Ford", "Mustang", "GT", MODERN, 't');
    boolean expectedValue = true;
    assertEquals(expectedValue, car.isInsured());
    
    // Checks "happy path" of using char 'T' value
    Vehicle car2 = new Vehicle("1", "2", 2000, "Ford", "Mustang", "GT", MODERN, 'T');
    assertEquals(expectedValue, car2.isInsured());
    
    // Checks negative path of using any other char value
    Vehicle car3 = new Vehicle("1", "2", 2000, "Ford", "Mustang", "GT", MODERN, 'f');
    expectedValue = false;
    assertEquals(expectedValue, car3.isInsured());
  }

  /**
   * Tests the Vehicle constructor that takes a String argument
   */
  @Test
  public void vehicleStringConstructorTest() {
    // Checks "happy path" of using String "TRUE" value
    Vehicle car = new Vehicle("1", "2", 2000, "Ford", "Mustang", "GT", MODERN, "TRUE");
    boolean expectedValue = true;
    assertEquals(expectedValue, car.isInsured());
    
    // Checks "happy path" of using String "true" value
    Vehicle car2 = new Vehicle("1", "2", 2000, "Ford", "Mustang", "GT", MODERN, "true");
    assertEquals(expectedValue, car2.isInsured());
    
    // Checks "happy path" of using String "True" value
    Vehicle car3 = new Vehicle("1", "2", 2000, "Ford", "Mustang", "GT", MODERN, "True");
    assertEquals(expectedValue, car3.isInsured());
    
    // Checks negative path of using any other String value
    Vehicle car4 = new Vehicle("1", "2", 2000, "Ford", "Mustang", "GT", MODERN, "false");
    expectedValue = false;
    assertEquals(expectedValue, car4.isInsured());
  }
  
  /**
   * Tests the Vehicle VehicleClassificaton setter that takes a char argument
   */
  @Test
  public void setVehicleClassificationCharTest() {
    // Checks "happy path" of using char 'a' value
    Vehicle car = new Vehicle();
    car.setVehicleClassification('a');
    VehicleClassification expectedValue= ANTIQUE;
    assertEquals(expectedValue, car.getVehicleClassification());
    
    // Checks "happy path" of using char 'A' value
    car.setVehicleClassification('A');
    assertEquals(expectedValue, car.getVehicleClassification());
    
    // Checks "happy path" of using char 'c' value
    car.setVehicleClassification('c');
    expectedValue= CLASSIC;
    assertEquals(expectedValue, car.getVehicleClassification());
    
    // Checks "happy path" of using char 'C' value
    car.setVehicleClassification('C');
    assertEquals(expectedValue, car.getVehicleClassification());
    
    // Checks "happy path" of using char 'm' value
    car.setVehicleClassification('m');
    expectedValue= MODERN;
    assertEquals(expectedValue, car.getVehicleClassification());
    
    // Checks "happy path" of using char 'M' value
    car.setVehicleClassification('M');
    assertEquals(expectedValue, car.getVehicleClassification());
    
    // Checks negative path of using any other char value
    car.setVehicleClassification('b');
    expectedValue= null;
    assertEquals(expectedValue, car.getVehicleClassification());
  }
  
  /**
   * Tests the Vehicle insurance check Boolean setter that takes a char argument
   */
  @Test
  public void setCharIsInsuredTest() {
    // Checks "happy path" of using char 'T' value
    Vehicle car = new Vehicle();
    car.setIsInsured('T');
    boolean expectedValue = true;
    assertEquals(expectedValue, car.isInsured());
    
    // Checks "happy path" of using char 't' value
    car.setIsInsured('t');
    assertEquals(expectedValue, car.isInsured());
    
    // Checks negative path of using any other char value
    car.setIsInsured('f');
    expectedValue = false;
    assertEquals(expectedValue, car.isInsured());
  }
  
  /**
   * Tests the Vehicle insurance check Boolean setter that takes a String argument
   */
  @Test
  public void setStringIsInsuredTest() {
    // Checks "happy path" of using String "TRUE" value
    Vehicle car = new Vehicle();
    car.setIsInsured("TRUE");
    boolean expectedValue = true;
    assertEquals(expectedValue, car.isInsured());
    
    // Checks "happy path" of using String "true" value
    car.setIsInsured("true");
    assertEquals(expectedValue, car.isInsured());
    
    // Checks "happy path" of using String "True" value
    car.setIsInsured("True");
    assertEquals(expectedValue, car.isInsured());
    
    // Checks negative path of using any other String value
    car.setIsInsured("false");
    expectedValue = false;
    assertEquals(expectedValue, car.isInsured());
  }
  
  /**
   * Tests the validateVehicleClassification() method for vehicle classified as ANTIQUE
   */
  @Test
  public void validateAntiqueVehicleClassificationTest() {
    // Checks "happy path" ANTIQUE vehicle classified correctly
    Vehicle car = new Vehicle();
    car.setVehicleClassification(ANTIQUE);
    car.setModelYear(1950);
    boolean expectedValue = true;
    assertEquals(expectedValue, car.validateVehicleClassification());
    
    // Checks negative path ANTIQUE vehicle classified incorrectly
    car.setModelYear(1951);
    expectedValue = false;
    assertEquals(expectedValue, car.validateVehicleClassification());
  }
  
  /**
   * Tests the validateVehicleClassification() method for vehicle classified as CLASSIC
   */
  @Test 
  public void validateClassicVehicleClassificationTest() {
    // Checks "happy path" CLASSIC vehicle classified correctly
    Vehicle car = new Vehicle();
    car.setVehicleClassification(CLASSIC);
    car.setModelYear(1980);// set to max year allowed to be considered CLASSIC
    boolean expectedValue = true;
    assertEquals(expectedValue, car.validateVehicleClassification());
    
    // Checks "happy path" CLASSIC vehicle classified correctly
    car.setModelYear(1951);// set to minimum year allowed to be considered CLASSIC
    expectedValue = true;
    assertEquals(expectedValue, car.validateVehicleClassification());
    
    // Checks negative path CLASSIC vehicle classified incorrectly
    car.setModelYear(1981);
    expectedValue = false;
    assertEquals(expectedValue, car.validateVehicleClassification());
  }
  
  /**
   * Tests the validateVehicleClassification() method for vehicle classified as MODERN
   */
  @Test 
  public void validateModernVehicleClassificationTest() {
    // Checks "happy path" MODERN vehicle classified correctly
    Vehicle car = new Vehicle();
    car.setVehicleClassification(MODERN);
    car.setModelYear(1981);
    boolean expectedValue = true;
    assertEquals(expectedValue, car.validateVehicleClassification());
    
    // Checks negative path MODERN vehicle classified incorrectly
    car.setModelYear(1980);
    expectedValue = false;
    assertEquals(expectedValue, car.validateVehicleClassification());
  }
  
  /**
   * Tests the adjustVehicleClassification() method correctly changes vehicle 
   * classification to ANTIQUE
   */
  @Test
  public void adjustAntiqueVehicleClassificationTest() {
    // Checks vehicle's classification is changed to ANTIQUE if incorrectly
    // set as CLASSIC
    Vehicle car = new Vehicle();
    car.setVehicleClassification(CLASSIC);
    car.setModelYear(1950);
    car.adjustVehicleClassification(car.validateVehicleClassification());
    VehicleClassification expectedValue = ANTIQUE;
    assertEquals(expectedValue, car.getVehicleClassification());
    
    // Checks vehicle's classification is changed to ANTIQUE if incorrectly
    // set as MODERN
    car.setVehicleClassification(MODERN);
    car.adjustVehicleClassification(car.validateVehicleClassification());
    assertEquals(expectedValue, car.getVehicleClassification());
  }
  
  /**
   * Tests the adjustVehicleClassification() method correctly changes vehicle 
   * classification to CLASSIC
   */
  @Test
  public void adjustClassicVehicleClassificationTest() {
    // Checks vehicle's classification is changed to CLASSIC if incorrectly
    // set as ANTIQUE
    Vehicle car = new Vehicle();
    car.setVehicleClassification(ANTIQUE);
    car.setModelYear(1951);
    car.adjustVehicleClassification(car.validateVehicleClassification());
    VehicleClassification expectedValue = CLASSIC;
    assertEquals(expectedValue, car.getVehicleClassification());
    
    // Checks vehicle's classification is changed to CLASSIC if incorrectly
    // set as MODERN
    car.setVehicleClassification(MODERN);
    car.adjustVehicleClassification(car.validateVehicleClassification());
    assertEquals(expectedValue, car.getVehicleClassification());
  }
  
  /**
   * Tests the adjustVehicleClassification() method correctly changes vehicle 
   * classification to MODERN
   */
  @Test
  public void adjustModernVehicleClassificationTest() {
    // Checks vehicle's classification is changed to MODERN if incorrectly
    // set as CLASSIC
    Vehicle car = new Vehicle();
    car.setVehicleClassification(CLASSIC);
    car.setModelYear(1981);
    car.adjustVehicleClassification(car.validateVehicleClassification());
    VehicleClassification expectedValue = MODERN;
    assertEquals(expectedValue, car.getVehicleClassification());
    
    // Checks vehicle's classification is changed to MODERN if incorrectly
    // set as ANTIQUE
    car.setVehicleClassification(ANTIQUE);
    car.adjustVehicleClassification(car.validateVehicleClassification());
    assertEquals(expectedValue, car.getVehicleClassification());
  }
}
