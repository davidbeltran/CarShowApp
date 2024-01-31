/**
 *
 * @author David Beltran
 * File: IVehicleService.java
 * This file contains the IVehicleService interface which is responsible for
 * creating and managing the collection that stores Vehicle objects.
 */
package edu.du.beltrandavid.model.services.vehicleservice;

import edu.du.beltrandavid.model.domain.Vehicle;
import edu.du.beltrandavid.model.services.IServices;
import java.util.Iterator;

public interface IVehicleService extends IServices{
  public final String NAME = "IVehicleService";
  
  public boolean add(Vehicle vehicle);
  public boolean remove(Vehicle vehicle);
  public boolean remove(String vehicleId);
  public Vehicle find(String vehicleId);
  public boolean isPresent(Vehicle vehicle);
  public boolean isPresent(String vehicleId);
  public void dump();
  public Iterator<Vehicle> getVehicles();
  public void emptyList();
  public String getName();
}
