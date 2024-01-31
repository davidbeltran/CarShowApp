/**
 *
 * @author David Beltran
 * File: CarShowOwnerManager.java
 * This file contains the CarShowOwnerManager class that manages the service 
 * implementation returned from the ServiceFactory object. 
 * All methods except setServiceProperties() handle service class
 * methods using the selected implementation.
 */
package edu.du.beltrandavid.model.business.manager.carshowownermanager;

import edu.du.beltrandavid.model.business.manager.Manager;
import edu.du.beltrandavid.model.domain.CarShowOwner;
import edu.du.beltrandavid.model.services.carshowownerservice.ICarShowOwnerService;
import java.util.Iterator;

public class CarShowOwnerManager extends Manager {
  
  /**
   *
   * @param cso
   * @return
   * @throws Exception
   * Manages add() method after applying selected collection type
   */
  public boolean add(CarShowOwner cso) throws Exception {
    boolean retVal = false;
    try {
      ICarShowOwnerService csoService = 
          (ICarShowOwnerService) getService(ICarShowOwnerService.NAME);
      retVal = csoService.add(cso);
    } catch (Exception e) {
      throw e;
    }
    return retVal;
  }
  
  /**
   *
   * @param cso
   * @return
   * @throws Exception
   * Manages remove() method after applying selected collection type
   */
  public boolean remove(CarShowOwner cso) throws Exception {
    boolean retVal = false;
    try {
      ICarShowOwnerService csoService = 
          (ICarShowOwnerService) getService(ICarShowOwnerService.NAME);
      retVal = csoService.remove(cso);
    } catch (Exception e) {
      throw e;
    }
    return retVal;
  }
  
  /**
   *
   * @param carShowId
   * @param OwnerId
   * @return
   * @throws Exception
   * Manages find() method after applying selected collection type
   */
  public CarShowOwner find(String carShowId, String OwnerId) throws Exception {
    CarShowOwner carShowOwner = null;
    try {
      ICarShowOwnerService csoService = 
          (ICarShowOwnerService) getService(ICarShowOwnerService.NAME);
      carShowOwner = csoService.find(carShowId, OwnerId);
    } catch (Exception e) {
      throw e;
    }
    return carShowOwner;
  }
  
  /**
   *
   * @param ownerId
   * @return
   * @throws Exception
   * Manages isPresent() method after applying selected collection type
   */
  public boolean isPresent(String ownerId) throws Exception {
    boolean retVal = false;
    try {
      ICarShowOwnerService csoService = 
          (ICarShowOwnerService) getService(ICarShowOwnerService.NAME);
      retVal = csoService.isPresent(ownerId);
    } catch (Exception e) {
      throw e;
    }
    return retVal;
  }
  
  /**
   *
   * @param carShowId
   * @param ownerId
   * @return
   * @throws Exception
   * Manages isPresent() method after applying selected collection type
   */
  public boolean isPresent(String carShowId, String ownerId) throws Exception {
    boolean retVal = false;
    try {
      ICarShowOwnerService csoService = 
          (ICarShowOwnerService) getService(ICarShowOwnerService.NAME);
      retVal = csoService.isPresent(carShowId, ownerId);
    } catch (Exception e) {
      throw e;
    }
    return retVal;
  }
  
  /**
   *
   * @param cso
   * @return
   * @throws Exception
   * Manages isPresent() method after applying selected collection type
   */
  public boolean isPresent(CarShowOwner cso) throws Exception {
    boolean retVal = false;
    try {
      ICarShowOwnerService csoService = 
          (ICarShowOwnerService) getService(ICarShowOwnerService.NAME);
      retVal = csoService.isPresent(cso);
    } catch (Exception e) {
      throw e;
    }
    return retVal;
  }
  
  /**
   *
   * @throws Exception
   * Manages dump() method after applying selected collection type
   */
  public void dump() throws Exception {
    try {
      ICarShowOwnerService csoService = 
          (ICarShowOwnerService) getService(ICarShowOwnerService.NAME);
      csoService.dump();
    } catch (Exception e) {
      throw e;
    }
  }
  
  /**
   *
   * @return
   * @throws Exception
   * Manages getCarShowOwners() method after applying selected collection type
   */
  public Iterator<CarShowOwner> getCarShowOwners() throws Exception {
    Iterator<CarShowOwner> carShowOwners = null;
    try {
      ICarShowOwnerService csoService = 
          (ICarShowOwnerService) getService(ICarShowOwnerService.NAME);
      carShowOwners = csoService.getCarShowOwners();
    } catch (Exception e) {
      throw e;
    }
    return carShowOwners;
  }
  
  /**
   *
   * @throws Exception
   * Manages emptyList() method after applying selected collection type
   */
  public void emptyList() throws Exception {
    try {
      ICarShowOwnerService csoService = 
          (ICarShowOwnerService) getService(ICarShowOwnerService.NAME);
      csoService.emptyList();
    } catch (Exception e) {
      throw e;
    }
  }
  
  /**
   * 
   * @param file 
   * sets the text file that gives command on which service implementation to use
   */
  public void setServiceProperties(String file) {
    this.file = file;
  }
}
