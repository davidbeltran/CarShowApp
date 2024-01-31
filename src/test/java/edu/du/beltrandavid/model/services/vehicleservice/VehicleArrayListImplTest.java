/**
 *
 * @author David Beltran
 * File: VehicleArrayListImplTest.java
 * This file contains the VehicleArrayListImplTest class which is responsible for
 * testing methods added to the VehicleArrayListImpl class.
 */
package edu.du.beltrandavid.model.services.vehicleservice;

import edu.du.beltrandavid.model.business.manager.vehiclemanager.VehicleManager;
import edu.du.beltrandavid.model.domain.Vehicle;
import static edu.du.beltrandavid.model.domain.VehicleClassification.ANTIQUE;
import static edu.du.beltrandavid.model.domain.VehicleClassification.CLASSIC;
import static edu.du.beltrandavid.model.domain.VehicleClassification.MODERN;
import java.util.ArrayList;
import java.util.Iterator;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail; 
import org.junit.Test;

public class VehicleArrayListImplTest {
  /**
   * Declared variables need to run tests
   */
  VehicleManager impl = new VehicleManager();
  public Vehicle car1, car2, car3, car4, car5, car6;
  
  /**
   * Instantiated Vehicle objects
   */
  public void createVehicles() {
    car1 = new Vehicle("1234", "4561", 1940, "Ford", "Coupe", "Deluxe", ANTIQUE, true);
    car2 = new Vehicle("2345", "456", 1960, "Chevrolet", "Apache", "10", CLASSIC, true);
    car3 = new Vehicle("2345", "456", 2020, "Buick", "Encore", "GX", MODERN, true);
    car4 = new Vehicle("1234", "4561", 1940, "Ford", "Coupe", "Deluxe", ANTIQUE, true);
    car5 = new Vehicle("7653", "45611", 1940, "Ford", "Coupe", "Deluxe", ANTIQUE, true);
    car6 = new Vehicle("5678", "007", 1940, "Ford", "Coupe", "Deluxe", ANTIQUE, true);
    this.impl.setServiceProperties("servicepropertiesarraylisttest.txt");
  }
  
  /**
   * Vehicle objects added to ArrayList
   * @throws java.lang.Exception
   */
  public void addAllVehicles() throws Exception {
    this.impl.add(this.car1);
    this.impl.add(this.car2);
    this.impl.add(this.car3);
    this.impl.add(this.car4);
    this.impl.add(this.car5);
    this.impl.add(this.car6);
  }
  
  /**
   * @return
   * @throws Exception 
   * Receives Iterator object from Manager object and fills ArrayList to test
   * contents of a collection
   */
  public ArrayList<Vehicle> createList() throws Exception {
    Iterator itr = this.impl.getVehicles();
    ArrayList<Vehicle> al = new ArrayList<>();
    while (itr.hasNext()) {
      al.add((Vehicle) itr.next());
    }
    return al;
  }
  
  /**
   * Tests the add() method
   * @throws java.lang.Exception
   */
  @Test
  public void addTest() throws Exception {
    createVehicles();
    this.impl.emptyList();
    this.impl.add(this.car1);
    
    ArrayList<Vehicle> al = createList();
    //Checks the "happy path" for ArrayList size and contained object
    assertEquals(1, al.size());
    assertEquals(this.car1, al.get(0));
    
    //Checks the negative path for ArrayList size and contained object
    assertNotEquals(2, al.size());
    assertNotEquals(this.car2, al.get(0));
  }
  
  /**
   * Tests the addDuplicateTest() method
   * @throws java.lang.Exception
   */
  @Test
  public void addDuplicateTest() throws Exception {
    createVehicles();
    this.impl.emptyList();  
    addAllVehicles();
    
    //Checks "happy path" that object with duplicate ID was adjusted to a unique value
    assertEquals("23451", this.car3.getVehicleId());
    
    //Checks negative path that object with duplicate ID was not kept the same
    assertNotEquals("2345", this.car3.getVehicleId());
  }
  
  /**
   * Tests the remove() method that takes an object as an argument
   * @throws java.lang.Exception
   */
  @Test
  public void removeObjectTest() throws Exception {
    createVehicles();
    this.impl.emptyList();
    addAllVehicles();
    
    ArrayList<Vehicle> al = createList();
    //Checks "happy path"
    assertEquals(6, al.size());//ArrayList size before remove()
    this.impl.remove(car1);
    al = createList();
    assertEquals(5, al.size());//ArrayList size after remove()
    //Checks object was correctly moved to different ArrayList index
    assertEquals(this.car2, al.get(0));
    
    //Checks negative path that ArrayList size is no longer as before and
    //removed object is no longer in the ArrayList index as before.
    assertNotEquals(6, al.size());
    assertNotEquals(this.car1, al.get(0));
  }
  
  /**
   * Tests the remove() method that takes a String as an argument
   * @throws java.lang.Exception
   */
  @Test
  public void removeStringTest() throws Exception {
    createVehicles();
    this.impl.emptyList();
    addAllVehicles();
    
    ArrayList<Vehicle> al = createList();
    //Checks "happy path"
    assertEquals(6, al.size());//ArrayList size before remove()
    this.impl.remove("2345");
    al = createList();
    assertEquals(5, al.size());//ArrayList size after remove()
    //Checks object was correctly moved to different ArrayList index
    assertEquals(this.car3, al.get(1));
    
    //Checks negative path that ArrayList size is no longer as before and
    //removed object is no longer in the ArrayList index as before.
    assertNotEquals(6, al.size());
    assertNotEquals(this.car2, al.get(1));
  }
  
  /**
   * Tests the find() method
   * @throws java.lang.Exception
   */
  @Test
  public void findTest() throws Exception {
    createVehicles();
    this.impl.emptyList();
    addAllVehicles();
    
    //Checks "happy path" that entered arguments return the correct object.
    assertEquals(this.car1, this.impl.find("1234"));
    
    //Checks negative path that entered arguments of non-existing object returns a null value and
    //entered arguments of one stored object does not return a different stored object. 
    assertEquals(null, this.impl.find("92123"));
    assertNotEquals(this.car1, this.impl.find("2345"));
  }
  
  /**
   * Tests the isPresent() method which uses a String argument
   * @throws java.lang.Exception
   */
  @Test
  public void isPresentStringTest() throws Exception {
    createVehicles();
    this.impl.emptyList();
    addAllVehicles();
    
    //Checks "happy path" String ID value locates a stored object in ArrayList
    assertEquals(true, this.impl.isPresent("7653"));
    
    //Checks negative path String ID value does not locate an object not stored in ArrayList
    assertEquals(false, this.impl.isPresent("542934"));
  }
  
  /**
   * Tests isPresent() method which uses an object argument
   * @throws java.lang.Exception
   */
  @Test
  public void isPresentObjectTest() throws Exception {
    createVehicles();
    this.impl.emptyList();
    addAllVehicles();
    Vehicle car7 = new Vehicle();//dummy object not stored in ArrayList
    
    //Checks "happy path" object argument locates a stored object in ArrayList 
    assertEquals(true, this.impl.isPresent(car4));
    
    //Checks negative path object argument does not locate an object not stored in ArrayList
    assertEquals(false, this.impl.isPresent(car7));
  }
  
  /**
   * Tests the NullPointerException in the dump() method with no null value
   * @throws java.lang.Exception
   */
  @Test
  public void dumpNullExceptionHappyTest() throws Exception {
    createVehicles();
    this.impl.emptyList();
    addAllVehicles();
    
    try {
      this.impl.dump();
    } catch (NullPointerException ne) {
      fail("An exception should not be thrown.");
    }
  }
  
  /**
   * Tests the NullPointerException in the dump() method with a null value
   * @throws java.lang.Exception
   */
  @Test 
  public void dumpNullExceptionNegativeTest() throws Exception {
    createVehicles();
    this.impl.emptyList();
    addAllVehicles();
    
    try {
      this.impl.add(null);
      this.impl.dump();
    } catch (NullPointerException ne) {
      System.out.println(ne.getMessage());
    }
  }
}
