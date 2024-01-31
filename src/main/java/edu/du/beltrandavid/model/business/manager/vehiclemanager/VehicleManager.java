/**
 *
 * @author David Beltran
 * File: VehicleManager.java
 * This file contains the VehicleManager class that manages the service implementation returned
 * from the ServiceFactory object. All methods except setServiceProperties() handle service class
 * methods using the selected implementation.
 */
package edu.du.beltrandavid.model.business.manager.vehiclemanager;

import edu.du.beltrandavid.model.business.manager.Manager;
import edu.du.beltrandavid.model.domain.Vehicle;
import edu.du.beltrandavid.model.services.vehicleservice.IVehicleService;
import java.util.Iterator;

public class VehicleManager extends Manager {
  
  /**
   *
   * @param vehicle
   * @return
   * @throws Exception
   * Manages add() method after applying selected collection type
   */
  public boolean add(Vehicle vehicle) throws Exception {
    boolean retVal = false;
    try {
      IVehicleService vehicleService = (IVehicleService) getService(IVehicleService.NAME);
      retVal = vehicleService.add(vehicle);
    } catch (Exception e) {
      throw e;
    }
    return retVal;
  }
  
  /**
   *
   * @param vehicle
   * @return
   * @throws Exception
   * Manages remove() method after applying selected collection type
   */
  public boolean remove(Vehicle vehicle) throws Exception {
    boolean retVal = false;
    try {
      IVehicleService vehicleService = (IVehicleService) getService(IVehicleService.NAME);
      retVal = vehicleService.remove(vehicle);
    } catch (Exception e) {
      throw e;
    }
    return retVal;
  }
  
  /**
   *
   * @param vehicleId
   * @return
   * @throws Exception
   * Manages remove() method after applying selected collection type
   */
  public boolean remove(String vehicleId) throws Exception {
    boolean retVal = false;
    try {
      IVehicleService vehicleService = (IVehicleService) getService(IVehicleService.NAME);
      retVal = vehicleService.remove(vehicleId);
    } catch (Exception e) {
      throw e;
    }
    return retVal;
  }
  
  /**
   *
   * @param vehicleId
   * @return
   * @throws Exception
   * Manages find() method after applying selected collection type
   */
  public Vehicle find(String vehicleId) throws Exception {
    Vehicle vehicle = null;
    try {
      IVehicleService vehicleService = (IVehicleService) getService(IVehicleService.NAME);
      vehicle = vehicleService.find(vehicleId);
    } catch (Exception e) {
      throw e;
    }
    return vehicle;
  }
  
  /**
   *
   * @param vehicle
   * @return
   * @throws Exception
   * Manages isPresent() method after applying selected collection type
   */
  public boolean isPresent(Vehicle vehicle) throws Exception {
    boolean retVal = false;
    try {
      IVehicleService vehicleService = (IVehicleService) getService(IVehicleService.NAME);
      retVal = vehicleService.isPresent(vehicle);
    } catch (Exception e) {
      throw e;
    }
    return retVal;
  }
  
  /**
   *
   * @param vehicleId
   * @return
   * @throws Exception
   * Manages isPresent() method after applying selected collection type
   */
  public boolean isPresent(String vehicleId) throws Exception {
    boolean retVal = false;
    try {
      IVehicleService vehicleService = (IVehicleService) getService(IVehicleService.NAME);
      retVal = vehicleService.isPresent(vehicleId);
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
    IVehicleService vehicleService = (IVehicleService) getService(IVehicleService.NAME);
    vehicleService.dump();
  }
  
  /**
   *
   * @return
   * @throws Exception
   * Manages getVehicles() method after applying selected collection type
   */
  public Iterator<Vehicle> getVehicles() throws Exception {
    Iterator<Vehicle> vehicles = null;
    try {
      IVehicleService vehicleService = (IVehicleService) getService(IVehicleService.NAME);
      vehicles = vehicleService.getVehicles();
    } catch (Exception e) {
      throw e;
    }
    return vehicles;
  }
  
  /**
   *
   * @throws Exception
   * Manages emptyList() method after applying selected collection type
   */
  public void emptyList() throws Exception {
    try {
      IVehicleService vehicleService = (IVehicleService) getService(IVehicleService.NAME);
      vehicleService.emptyList();
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
