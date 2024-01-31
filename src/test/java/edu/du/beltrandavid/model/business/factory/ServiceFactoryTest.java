/**
 *
 * @author David Beltran
 * File: ServiceFactoryTest.java
 * This file contains the ServiceFactoryTest class which is responsible for
 * testing the ServiceFactory object receives the correct text file.
 */
package edu.du.beltrandavid.model.business.factory;

import edu.du.beltrandavid.model.business.manager.ownermanager.OwnerManager;
import edu.du.beltrandavid.model.business.manager.vehiclemanager.VehicleManager;
import static org.junit.Assert.fail;
import org.junit.Test; 

public class ServiceFactoryTest {
  
  /**
   * Tests that no exception was thrown with existing text file
   */
  @Test
  public void serviceFactoryHappyTest() {
    OwnerManager om = new OwnerManager();
    VehicleManager vm = new VehicleManager();
    try {
      om.setServiceProperties("serviceproperties.txt");
      vm.setServiceProperties("serviceproperties.txt");
    } catch (Exception e) {
      fail("An exception should not be thrown.");
    }
  }
  
  /**
   * Tests that exception was thrown with non-existing text file
   */
  @Test
  public void serviceFactoryNegativeTest() {
    OwnerManager om = new OwnerManager();
    VehicleManager vm = new VehicleManager();
    try {
      om.setServiceProperties("service.txt");
      vm.setServiceProperties("service.txt");
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}
