/**
 *
 * @author David Beltran
 * File: PersistManager.java
 * This file contains the PersistManager class that manages the service implementation returned
 * from the PersistFactory object. All methods except setServiceProperties() handle service class
 * methods using the selected implementation.
 */
package edu.du.beltrandavid.model.business.manager.persistmanager;

import edu.du.beltrandavid.model.business.manager.PersistenceManager;
import edu.du.beltrandavid.model.business.manager.carshowmanager.CarShowManager;
import edu.du.beltrandavid.model.business.manager.carshowownermanager.CarShowOwnerManager;
import edu.du.beltrandavid.model.business.manager.ownermanager.OwnerManager;
import edu.du.beltrandavid.model.business.manager.vehiclemanager.VehicleManager;
import edu.du.beltrandavid.model.services.persistservice.IPersistService;

public class PersistManager extends PersistenceManager {
  
  /**
   *
   * @param ownerManager
   * @param vehicleManager
   * @param carShowManager
   * @param carShowOwnerManager
   * @throws Exception
   * Manages loadPersistData() method from service class
   */
  public void loadPersistData(OwnerManager ownerManager, VehicleManager vehicleManager, 
      CarShowManager carShowManager, CarShowOwnerManager carShowOwnerManager) throws Exception {
    try {
      IPersistService service = (IPersistService) getService(IPersistService.NAME);
      service.loadPersistData(ownerManager, vehicleManager, carShowManager, carShowOwnerManager);
    } catch(Exception e) {
      throw e;
    }
  }
  
  /**
   *
   * @param ownerManager
   * @param vehicleManager
   * @param carShowManager
   * @param carShowOwnerManager
   * @throws Exception
   * Manages putPersistData() method from service class
   */
  public void putPeristData(OwnerManager ownerManager, VehicleManager vehicleManager, 
      CarShowManager carShowManager, CarShowOwnerManager carShowOwnerManager) throws Exception {
    try {
      IPersistService service = (IPersistService) getService(IPersistService.NAME);
      service.putPersistData(ownerManager, vehicleManager, carShowManager, carShowOwnerManager);
    } catch (Exception e) {
      throw e;
    }
  }
  
  /**
   *
   * @return
   * @throws Exception
   * Manages getFile() method from service class
   */
  public String getFile() throws Exception {
      IPersistService service = (IPersistService) getService(IPersistService.NAME);
      return service.getFile();
  }
  
  /**
   * 
   * @param file 
   * sets the text file that gives command on which service implementation to use
   */
  public void setPersistProperties(String file) {
    this.file = file;
  }
}
