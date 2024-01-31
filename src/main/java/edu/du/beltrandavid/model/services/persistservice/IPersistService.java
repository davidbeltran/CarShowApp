/**
 *
 * @author David Beltran
 * File: IPersistService.java
 * This file contains the IPersistService interface which is responsible for
 * creating and managing the file that persists car show data.
 */
package edu.du.beltrandavid.model.services.persistservice;

import edu.du.beltrandavid.model.business.manager.carshowmanager.CarShowManager;
import edu.du.beltrandavid.model.business.manager.carshowownermanager.CarShowOwnerManager;
import edu.du.beltrandavid.model.business.manager.ownermanager.OwnerManager;
import edu.du.beltrandavid.model.business.manager.vehiclemanager.VehicleManager;
import edu.du.beltrandavid.model.services.IPersistServices;


public interface IPersistService extends IPersistServices {
  public final String NAME = "PersistService";
  
  public void loadPersistData(OwnerManager ownerManager, VehicleManager vehilceManager,
      CarShowManager carShowManager, CarShowOwnerManager carShowOwnerManager) throws Exception;
  public void putPersistData(OwnerManager ownerManager, VehicleManager vehilceManager, 
      CarShowManager carShowManager, CarShowOwnerManager carShowOwnerManager) throws Exception;
  public String getFile();
}
