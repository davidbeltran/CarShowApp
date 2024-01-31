/**
 *
 * @author David Beltran
 * File: CarShowTest.java
 * This file contains unit tests for the CarShow class.
 */
package edu.du.beltrandavid.model.domain;

import java.time.LocalDate;
import org.junit.Test;
import static org.junit.Assert.*;

public class CarShowTest { 

  /**
   * Tests the CarShow constructor that takes a Boolean argument
   */
  @Test
  public void testCarShowRegConstructor() {
    //checks Boolean false value was captured correctly
    CarShow show1 = new CarShow("123", "Dynamite", LocalDate.of(2022, 8, 20), false);
    boolean expectedResult = false;
    assertEquals(expectedResult, show1.isSanctioned());
    
    //checks Boolean true value was captured correctly
    CarShow show2 = new CarShow("123", "Dynamite", LocalDate.of(2022, 8, 20), true);
    expectedResult = true;
    assertEquals(expectedResult, show2.isSanctioned());
  }
  
  /**
   * Tests the CarShow constructor that takes a char argument
   */
  @Test
  public void testCarShowCharConstructor() {
    // Checks "happy path" of using char 't' value
    CarShow show1 = new CarShow("123", "Dynamite", LocalDate.of(2022, 8, 20), 't');
    boolean expectedResult = true;
    assertEquals(expectedResult, show1.isSanctioned());
    
    // Checks "happy path" of using char 'T' value
    CarShow show2 = new CarShow("123", "Dynamite", LocalDate.of(2022, 8, 20), 'T');
    assertEquals(expectedResult, show2.isSanctioned());
    
    // Checks negative path of using any other char value
    CarShow show3 = new CarShow("123", "Dynamite", LocalDate.of(2022, 8, 20), 'f');
    expectedResult = false;
    assertEquals(expectedResult, show3.isSanctioned());
  }
  
  /**
   * Tests the CarShow constructor that takes a String argument
   */
  @Test
  public void testCarShowStringConstructor() {
    // Checks "happy path" of using String "true" value
    CarShow show1 = new CarShow("123", "Dynamite", LocalDate.of(2022, 8, 20), "true");
    boolean expectedResult = true;
    assertEquals(expectedResult, show1.isSanctioned());
    
    // Checks "happy path" of using String "TRUE" value
    CarShow show2 = new CarShow("123", "Dynamite", LocalDate.of(2022, 8, 20), "TRUE");
    assertEquals(expectedResult, show2.isSanctioned());
    
    // Checks "happy path" of using String "True" value
    CarShow show3 = new CarShow("123", "Dynamite", LocalDate.of(2022, 8, 20), "True");
    assertEquals(expectedResult, show3.isSanctioned());
    
    // Checks negative path of using any other String value
    CarShow show4 = new CarShow("123", "Dynamite", LocalDate.of(2022, 8, 20), "false");
    expectedResult = false;
    assertEquals(expectedResult, show4.isSanctioned());
  }
  
  /**
   * Tests the Vehicle sanctioned Boolean setter that takes a Boolean argument
   */
  @Test
  public void testBooleanSetIsSanctioned() {
    // Checks using a Boolean true value
    CarShow show = new CarShow();
    show.setIsSanctioned(true);
    boolean expectedResult = true;
    assertEquals(expectedResult, show.isSanctioned());
    
    // Checks using a Boolean false value
    show.setIsSanctioned(false);
    expectedResult = false;
    assertEquals(expectedResult, show.isSanctioned());
  }
  
  /**
   * Tests the Vehicle sanctioned Boolean setter that takes a char argument
   */
  @Test
  public void testCharSetIsSanctioned() {
    // Checks "happy path" of using char 't' value
    CarShow show = new CarShow();
    show.setIsSanctioned('t');
    boolean expectedResult = true;
    assertEquals(expectedResult, show.isSanctioned());
    
    // Checks "happy path" of using char 'T' value
    show.setIsSanctioned('T');
    assertEquals(expectedResult, show.isSanctioned());
    
    // Checks "happy path" of using char 'y' value
    show.setIsSanctioned('y');
    assertEquals(expectedResult, show.isSanctioned());
    
    // Checks "happy path" of using char 'Y' value
    show.setIsSanctioned('Y');
    assertEquals(expectedResult, show.isSanctioned());
    
    // Checks negative path of using any other char value
    show.setIsSanctioned('f');
    expectedResult = false;
    assertEquals(expectedResult, show.isSanctioned());
  }
  
  /**
   * Tests the Vehicle sanctioned Boolean setter that takes a String argument
   */
  @Test
  public void testStringSetIsSanctiond() {
    // Checks "happy path" of using String "true" value
    CarShow show = new CarShow();
    show.setIsSanctioned("true");
    boolean expectedResult = true;
    assertEquals(expectedResult, show.isSanctioned());
    
    // Checks "happy path" of using String "TRUE" value
    show.setIsSanctioned("TRUE");
    assertEquals(expectedResult, show.isSanctioned());
    
    // Checks "happy path" of using String "True" value
    show.setIsSanctioned("True");
    assertEquals(expectedResult, show.isSanctioned());
    
    // Checks "happy path" of using String "YES" value
    show.setIsSanctioned("YES");
    assertEquals(expectedResult, show.isSanctioned());
    
    // Checks "happy path" of using String "yes" value
    show.setIsSanctioned("yes");
    assertEquals(expectedResult, show.isSanctioned());
    
    // Checks "happy path" of using String "Yes" value
    show.setIsSanctioned("Yes");
    assertEquals(expectedResult, show.isSanctioned());
    
    // Checks negative path of using any other String value
    show.setIsSanctioned("false");
    expectedResult = false;
    assertEquals(expectedResult, show.isSanctioned());
  }
  
  /**
   * Tests the Vehicle sanctioned Boolean setter that takes an int argument
   */
  @Test
  public void testIntSetIsSanctiond() {
    // Checks using int 1 value
    CarShow show = new CarShow();
    show.setIsSanctioned(1);
    boolean expectedResult = true;
    assertEquals(expectedResult, show.isSanctioned());
    
    // Checks using int 0 value
    show.setIsSanctioned(0);
    expectedResult = false;
    assertEquals(expectedResult, show.isSanctioned());
  }
  
  /**
   * Tests display message if CarShow object is sanctioned.
   */
  @Test 
  public void testDisplayIsSanctioned() {
    CarShow carShow = new CarShow();
    carShow.setCarShowTitle("Dynamite");
    carShow.setIsSanctioned(true);
    String expectedValue = "DYNAMITE is sanctioned.\n";
    assertEquals(carShow.displayIsSanctioned(carShow.isSanctioned()), expectedValue);
    
    carShow.setIsSanctioned(false);
    expectedValue = "DYNAMITE is NOT sanctioned.\n";
    assertEquals(carShow.displayIsSanctioned(carShow.isSanctioned()), expectedValue);
  }
}
