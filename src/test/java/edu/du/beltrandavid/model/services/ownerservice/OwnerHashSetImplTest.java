/**
 *
 * @author David Beltran
 * File: OwnerHashSetImplTest.java
 * This file contains the OwnerHashSetImplTest class which is responsible for
 * testing methods added to the OwnerHashSetImplTest class.
 */
package edu.du.beltrandavid.model.services.ownerservice;

import edu.du.beltrandavid.model.business.manager.ownermanager.OwnerManager;
import edu.du.beltrandavid.model.domain.Address;
import edu.du.beltrandavid.model.domain.Owner;
import java.util.ArrayList;
import java.util.Iterator;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;
import org.junit.Test; 

public class OwnerHashSetImplTest {
  /**
   * Declared variables need to run tests
   */
  OwnerManager impl = new OwnerManager();
  public Owner owner1, owner2, owner3;
  
  /**
   * Instantiated Owner objects
   */
  public void createOwners(){
    Address address1 = new Address("123 Circle Dr.", "Unit 5", "Las Vegas", "NV", "12345");
    owner1 = new Owner("4561", "Jon", "Doe", "123-456-7890", 21, address1);
    owner2 = new Owner("456", "Adam", "Cole", "234-567-8901", 10, address1);
    owner3 = new Owner("456", "Britt", "Baker", "345-123-7642", 17, address1);
    impl.setServiceProperties("servicepropertieshashsettest.txt");
  }
  
  /**
   * Owner objects added to HashSet
   * @throws java.lang.Exception
   */
  public void addAllOwners() throws Exception {
    this.impl.add(this.owner1);
    this.impl.add(this.owner2);
    this.impl.add(this.owner3);
  }
  
  /**
   * @return
   * @throws Exception 
   * Receives Iterator object from Manager object and fills ArrayList to test
   * contents of a collection
   */
  public ArrayList<Owner> createList() throws Exception {
    Iterator itr = this.impl.getOwners();
    ArrayList<Owner> al = new ArrayList<>();
    while (itr.hasNext()) {
      al.add((Owner) itr.next());
    }
    return al;
  }
  
  /**
   * Tests the add() method
   * @throws java.lang.Exception
   */
  @Test
  public void addTest() throws Exception {
    createOwners();
    this.impl.emptyList();
    this.impl.add(owner1);
    
    ArrayList<Owner> al = createList();
    //Checks the "happy path" for HashSet size and contained object
    assertEquals(1, al.size());
    assertEquals(this.owner1, al.get(0));
    
    //Checks the negative path for HashSet size and contained object
    assertNotEquals(2, al.size());
    assertNotEquals(this.owner2, al.get(0));
  }
  
    /**
   * Tests the addDuplicateTest() method
   * @throws java.lang.Exception
   */
  @Test
  public void addDuplicateTest() throws Exception {
    createOwners();
    this.impl.emptyList();
    addAllOwners();
    
    //Checks "happy path" that object with duplicate ID was adjusted to a unique value
    assertEquals("45611", this.owner3.getOwnerId());
    
    //Checks negative path that object with duplicate ID was not kept the same
    assertNotEquals("456", this.owner3.getOwnerId());
    assertNotEquals("4561", this.owner3.getOwnerId());
  }
  
    
  /**
   * Tests the remove() method that takes an object as an argument
   * @throws java.lang.Exception
   */
  @Test
  public void removeObjectTest() throws Exception {
    createOwners();
    this.impl.emptyList();
    addAllOwners();
    
    ArrayList<Owner> al = createList();
    //Checks "happy path"
    assertEquals(3, al.size());//HashSet size before remove()
    this.impl.remove(this.owner1);
    al = createList();
    System.out.print("SHOULD BE HERE: \n"); this.impl.dump();
    assertEquals(2, al.size());//HashSet size after remove()
    //Checks object was correctly moved to different HashSet index
    assertEquals(this.owner2, al.get(0));
    
    //Checks negative path that HashSet size is no longer as before and
    //removed object is no longer in the HashSet index as before.
    assertNotEquals(3, al.size());
    assertNotEquals(this.owner1, al.get(0));
  }
  
    /**
   * Tests the remove() method that takes a String as an argument
   * @throws java.lang.Exception
   */
  @Test
  public void removeStringTest() throws Exception {
    createOwners();
    this.impl.emptyList();
    addAllOwners();
    
    ArrayList<Owner> al = createList();
    //Checks "happy path"
    assertEquals(3, al.size());//HashSet size before remove()
    this.impl.remove("456");
    al = createList();
    assertEquals(2, al.size());//HashSet size after remove()
    //Checks object was correctly moved to different HashSet index
    assertEquals(this.owner3, al.get(1));
    
    //Checks negative path that HashSet size is no longer as before and
    //removed object is no longer in the HashSet index as before.
    assertNotEquals(3, al.size());
    assertNotEquals(this.owner2, al.get(1));
  }
  
    /**
   * Tests the find() method
   * @throws java.lang.Exception
   */
  @Test
  public void findTest() throws Exception {
    createOwners();
    this.impl.emptyList();
    addAllOwners();
    
    //Checks "happy path" that entered arguments return the correct object.
    assertEquals(this.owner1, this.impl.find("4561"));
    
    //Checks negative path that entered arguments of non-existing object returns a null value and
    //entered arguments of one stored object does not return a different stored object. 
    assertEquals(null, this.impl.find("123"));
    assertNotEquals(this.owner1, this.impl.find("45611"));
  }
  
    /**
   * Tests the isPresent() method which uses a String argument
   * @throws java.lang.Exception
   */
  @Test
  public void isPresentStringTest() throws Exception {
    createOwners();
    this.impl.emptyList();
    addAllOwners();
    
    //Checks "happy path" String ID value locates a stored object in HashSet
    assertEquals(true, this.impl.isPresent("456"));
    
    //Checks negative path String ID value does not locate an object not stored in HashSet
    assertEquals(false, this.impl.isPresent("123"));
  }
  
    /**
   * Tests isPresent() method which uses an object argument
   * @throws java.lang.Exception
   */
  @Test
  public void isPresentObjectTest() throws Exception {
    createOwners();
    this.impl.emptyList();
    addAllOwners();
    Owner owner4 = new Owner();//dummy object not stored in HashSet
    
    //Checks "happy path" object argument locates a stored object in HashSet 
    assertEquals(true, this.impl.isPresent(this.owner3));
    
    //Checks negative path object argument does not locate an object not stored in HashSet
    assertEquals(false, this.impl.isPresent(owner4));
  }
  
    /**
   * Tests the NullPointerException in the dump() method with no null value
   * @throws java.lang.Exception
   */
  @Test
  public void dumpNullExceptionHappyTest() throws Exception {
    createOwners();
    this.impl.emptyList();
    addAllOwners();
    
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
    createOwners();
    this.impl.emptyList();
    addAllOwners();
    
    try {
      this.impl.add(null);
      this.impl.dump();
    } catch (NullPointerException ne) {
      System.out.println(ne.getMessage());
    }
  }
}
