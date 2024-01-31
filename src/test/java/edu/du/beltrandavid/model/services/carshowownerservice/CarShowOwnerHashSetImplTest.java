/**
 *
 * @author David Beltran
 * File: CarShowOwnerHashSetImplTest.java
 * This file contains the CarShowOwnerHashSetImplTest class which is responsible for
 * testing methods added to the CarShowOwnerHashSetImplTest class.
 */
package edu.du.beltrandavid.model.services.carshowownerservice;

import edu.du.beltrandavid.model.business.manager.carshowownermanager.CarShowOwnerManager;
import edu.du.beltrandavid.model.domain.CarShowOwner;
import java.util.ArrayList;
import java.util.Iterator;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;
import org.junit.Test;
 
public class CarShowOwnerHashSetImplTest {
  /**
   * Declared variables need to run tests
   */
  CarShowOwnerManager impl = new CarShowOwnerManager();
  public CarShowOwner cso1, cso2,cso3;
  
  /**
   * Instantiated CarShowOwner objects
   */
  public void createCarShowOwners() {
    cso1 = new CarShowOwner("cs1", "909");
    cso2 = new CarShowOwner("cs21", "808");
    cso3 = new CarShowOwner("cs3", "909");
    this.impl.setServiceProperties("servicepropertieshashsettest.txt");
  }
  
  /**
   * CarShowOwner objects added to HashSet
   * @throws java.lang.Exception
   */
  public void addAllCarShowOwners() throws Exception {
    this.impl.add(cso1);
    this.impl.add(cso2);
    this.impl.add(cso3);
  }
  
  /**
   * @return
   * @throws Exception 
   * Receives Iterator object from Manager object and fills HashSet to test
   * contents of a collection
   */
  public ArrayList<CarShowOwner> createList() throws Exception {
    Iterator itr = this.impl.getCarShowOwners();
    ArrayList<CarShowOwner> al = new ArrayList<>();
    while (itr.hasNext()) {
      al.add((CarShowOwner) itr.next());
    }
    return al;
  }
  
  /**
   * Tests the add() method
   * @throws java.lang.Exception
   */
  @Test
  public void addTest() throws Exception {
    createCarShowOwners();
    this.impl.emptyList();
    this.impl.add(cso1);
    
    ArrayList<CarShowOwner> al = createList();
    //Checks the "happy path" for HashSet size and contained object
    assertEquals(1, al.size());
    assertEquals(this.cso1, al.get(0));
    
    //Checks the negative path for HashSet size and contained object
    assertNotEquals(2, al.size());
    assertNotEquals(this.cso2, al.get(0));
  }
  
  /**
   * Tests the remove() method that takes an object as an argument
   * @throws java.lang.Exception
   */
  @Test
  public void removeTest() throws Exception {
    createCarShowOwners();
    this.impl.emptyList();
    addAllCarShowOwners();
    
    ArrayList<CarShowOwner> al = createList();
    //Checks "happy path"
    assertEquals(3, al.size());//HashSet size before remove()
    this.impl.remove(this.cso1);
    al = createList();
    assertEquals(2, al.size());//HashSet size after remove()
    //Checks object was correctly moved to different HashSet index
    assertEquals(this.cso2, al.get(0));
    
    //Checks negative path that HashSet size is no longer as before and
    //removed object is no longer in the HashSet index as before.
    assertNotEquals(3, al.size());
    assertNotEquals(this.cso1, al.get(0));
  }
  
  /**
   * Tests the find() method
   * @throws java.lang.Exception
   */
  @Test
  public void findTest() throws Exception {
    createCarShowOwners();
    this.impl.emptyList();
    addAllCarShowOwners();
    
    //Checks "happy path" that entered arguments return the correct object.
    assertEquals(this.cso1, this.impl.find("cs1", "909"));
    
    //Checks negative path that entered arguments of non-existing object returns a null value and
    //entered arguments of one stored object does not return a different stored object. 
    assertEquals(null, this.impl.find("cs1", "901"));
    assertEquals(null, this.impl.find("cs6", "909"));
    assertNotEquals(this.cso1, this.impl.find("cs3", "9091"));
  }
  
  /**
   * Tests the isPresent() method which uses a String argument
   * @throws java.lang.Exception
   */
  @Test
  public void isPresentStringTest() throws Exception {
    createCarShowOwners();
    this.impl.emptyList();
    addAllCarShowOwners();
    
    //Checks "happy path" String ID value locates a stored object in HashSet
    assertEquals(true, this.impl.isPresent("909"));
    
    //Checks negative path String ID value does not locate an object not stored in HashSet
    assertEquals(false, this.impl.isPresent("901"));
  }
  
  /**
   * Tests isPresent() method which uses two String arguments
   * @throws java.lang.Exception
   */
  @Test
  public void isPresentTwoStringTest() throws Exception {
    createCarShowOwners();
    this.impl.emptyList();
    addAllCarShowOwners();
    
    //Checks "happy path" String owner ID and String carShow ID locates a 
    //stored object in HashSet
    assertEquals(true, this.impl.isPresent("cs1", "909"));
    
    //Checks negative path String arguments do not locate an object not stored in HashSet
    assertEquals(false, this.impl.isPresent("cs21", "909"));
    assertEquals(false, this.impl.isPresent("cs1", "9091"));
  }
  
  /**
   * Tests isPresent() method which uses an object argument
   * @throws java.lang.Exception
   */
  @Test
  public void isPresentObjectTest() throws Exception {
    createCarShowOwners();
    this.impl.emptyList();  
    addAllCarShowOwners();
    CarShowOwner cso4 = new CarShowOwner();//dummy object not stored in HashSet
    
    //Checks "happy path" object argument locates a stored object in HashSet 
    assertEquals(true, this.impl.isPresent(cso3));
    
    //Checks negative path object argument does not locate an object not stored in HashSet
    assertEquals(false, this.impl.isPresent(cso4));
  }
  
  /**
   * Tests the NullPointerException in the dump() method with no null value
   * @throws java.lang.Exception
   */
  @Test
  public void dumpNullExceptionHappyTest() throws Exception {
    createCarShowOwners();
    this.impl.emptyList();  
    addAllCarShowOwners();
    
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
    createCarShowOwners();
    addAllCarShowOwners();
    
    try {
      this.impl.add(null);
      this.impl.dump();
    } catch (NullPointerException ne) {
      System.out.println(ne.getMessage());
    }
  }
}
