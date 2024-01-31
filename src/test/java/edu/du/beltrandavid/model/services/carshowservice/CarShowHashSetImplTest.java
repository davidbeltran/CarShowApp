/**
 * @author David Beltran
 * File: CarShowHashSetImplTest.java
 * This file contains the CarShowHashSetImplTest class which is responsible for
 * testing methods added to the CarShowHashSetImplTest class.
 */
package edu.du.beltrandavid.model.services.carshowservice;

import edu.du.beltrandavid.model.business.manager.carshowmanager.CarShowManager;
import edu.du.beltrandavid.model.domain.CarShow;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;
import org.junit.Test; 

public class CarShowHashSetImplTest {
  /**
   * Declared variables need to run tests
   */
  CarShowManager impl = new CarShowManager();
  public CarShow show1, show2, show3;
  
  /**
   * Instantiated CarShow objects
   */
  public void createCarShows() {
    show1 = new CarShow("cs1", "Dynamite", LocalDate.of(2022, 4, 15), true);
    show2 = new CarShow("cs2", "Rampage", LocalDate.of(2022, 7, 28), true);
    show3 = new CarShow("cs2", "Dark", LocalDate.of(2023, 4, 14), true);
    this.impl.setServiceProperties("servicepropertieshashsettest.txt");
  }
  
  /**
   * CarShow objects added to HashSet
   * @throws java.lang.Exception
   */
  public void addAllCarShows() throws Exception {
    this.impl.add(this.show1);
    this.impl.add(this.show2);
    this.impl.add(this.show3);
  }
  
  /**
   * @return
   * @throws Exception 
   * Receives Iterator object from Manager object and fills HashSet to test
   * contents of a collection
   */
  public ArrayList<CarShow> createList() throws Exception {
    Iterator itr = this.impl.getCarShows();
    ArrayList<CarShow> al = new ArrayList<>();
    while (itr.hasNext()) {
      al.add((CarShow) itr.next());
    }
    return al;
  }
  
  /**
   * Tests the add() method
   * @throws java.lang.Exception
   */
  @Test
  public void addTest() throws Exception {
    createCarShows();
    this.impl.emptyList();  
    this.impl.add(show1);
    
    ArrayList<CarShow> al = createList();
    //Checks the "happy path" for HashSet size and contained object
    assertEquals(1, al.size());
    assertEquals(this.show1, al.get(0));
    
    //Checks the negative path for HashSet size and contained object
    assertNotEquals(2, al.size());
    assertNotEquals(this.show2, al.get(0));
  }
  
  /**
   * Tests the addDuplicateTest() method
   * @throws java.lang.Exception
   */
  @Test
  public void addDuplicateTest() throws Exception {
    createCarShows();
    this.impl.emptyList();  
    addAllCarShows();
    
    //Checks "happy path" that object with duplicate ID was adjusted to a unique value
    assertEquals("CS21", this.show3.getCarShowId());
    
    //Checks negative path that object with duplicate ID was not kept the same
    assertNotEquals("CS2", this.show3.getCarShowId());
  }
  
  /**
   *
   * Tests the remove() method that takes an object as an argument
   * @throws java.lang.Exception
   */
  @Test
  public void removeObjectTest() throws Exception {
    createCarShows();
    this.impl.emptyList();  
    addAllCarShows();
    
    ArrayList<CarShow> al = createList();
    //Checks "happy path"
    assertEquals(3, al.size());//HashSet size before remove()
    this.impl.remove(this.show1);
    al = createList();
    assertEquals(2, al.size());//HashSet size after remove()
    //Checks object was correctly moved to different ArrayList index
    assertEquals(this.show2, al.get(0));
    
    //Checks negative path that HashSet size is no longer as before and
    //removed object is no longer in the HashSet index as before.
    assertNotEquals(3, al.size());
    assertNotEquals(this.show1, al.get(0));
  }
  
  /**
   *
   * Tests the remove() method that takes a String as an argument
   * @throws java.lang.Exception
   */
  @Test
  public void removeStringTest() throws Exception {
    createCarShows();
    this.impl.emptyList();  
    addAllCarShows();
    
    ArrayList<CarShow> al = createList();
    //Checks "happy path"
    assertEquals(3, al.size());//HashSet size before remove()
    this.impl.remove("cs2");
    al = createList();
    assertEquals(2, al.size());//HashSet size after remove()
    //Checks object was correctly moved to different HashSet index
    assertEquals(this.show3, al.get(1));
    
    //Checks negative path that HashSet size is no longer as before and
    //removed object is no longer in the HashSet index as before.
    assertNotEquals(3, al.size());
    assertNotEquals(this.show2, al.get(1));
  }
  
  /**
   *
   * Tests the find() method
   * @throws java.lang.Exception
   */
  @Test
  public void findTest() throws Exception {
    createCarShows();
    this.impl.emptyList();
    addAllCarShows();
    
    //Checks "happy path" that entered arguments return the correct object.
    assertEquals(this.show1, this.impl.find("cs1"));
    
    //Checks negative path that entered arguments of non-existing object returns a null value and
    //entered arguments of one stored object does not return a different stored object. 
    assertEquals(null, this.impl.find("sc1"));
    assertNotEquals(this.show1, this.impl.find("cs21"));
  }
  
  /**
   *
   * Tests the isPresent() method which uses a String argument
   * @throws java.lang.Exception
   */
  @Test
  public void isPresentStringTest() throws Exception {
    createCarShows();
    this.impl.emptyList();
    addAllCarShows();
    
    //Checks "happy path" String ID value locates a stored object in HashSet
    assertEquals(true, this.impl.isPresent("cs2"));
    
    //Checks negative path String ID value does not locate an object not stored in HashSet
    assertEquals(false, this.impl.isPresent("cs211"));
  }
  
  /**
   * Tests isPresent() method which uses an object argument
   * @throws java.lang.Exception
   */
  @Test
  public void isPresentObjectTest() throws Exception {
    createCarShows();
    this.impl.emptyList();
    addAllCarShows();
    CarShow show4 = new CarShow();//dummy object not stored in HashSet
    
    //Checks "happy path" object argument locates a stored object in HashSet 
    assertEquals(true, this.impl.isPresent(this.show3));
    
    //Checks negative path object argument does not locate an object not stored in HashSet
    assertEquals(false, this.impl.isPresent(show4));
  }
  
  /**
   * Tests the NullPointerException in the dump() method with no null value
   * @throws java.lang.Exception
   */
  @Test
  public void dumpNullExceptionHappyTest() throws Exception {
    createCarShows();
    addAllCarShows();
    
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
    createCarShows();
    addAllCarShows();
    
    try {
      this.impl.add(null);
      this.impl.dump();
    } catch (NullPointerException ne) {
      System.out.println(ne.getMessage());
    }
  }
}
