/**
 *
 * @author David Beltran
 * File: PersistFactoryTest.java
 * This file contains the PersistFactoryTest class which is responsible for
 * testing the PersistFactory object is writing to the correct file type.
 */
package edu.du.beltrandavid.model.business.factory; 

import edu.du.beltrandavid.model.business.manager.persistmanager.PersistManager;
import static org.junit.Assert.*;
import org.junit.Test;

public class PersistFactoryTest {
  
  /**
   *
   * @throws Exception
   * txt file created to run XML service.
   * Ensures PersistFactory instantiated correct PersistManager object
   * by checking if the returned file is a xml file
   */
  @Test
  public void persistXMLManagerTest() throws Exception {
    PersistManager persistManager = new PersistManager();
  
    persistManager.setPersistProperties("xmlpersistencepropertiestest.txt");
    assertEquals(persistManager.getFile(), "carshow_data.xml");
  }
  
  /**
   *
   * @throws Exception
   * txt file created to run JSON service.
   * Ensures PersistFactory instantiated correct PersistManager object
   * by checking if the returned file is a json file
   */
  @Test
  public void persistJSONManagerTest() throws Exception {
    PersistManager persistManager = new PersistManager();
  
    persistManager.setPersistProperties("jsonpersistencepropertiestest.txt");
    assertEquals(persistManager.getFile(), "carshow_data.json");
  }
}
