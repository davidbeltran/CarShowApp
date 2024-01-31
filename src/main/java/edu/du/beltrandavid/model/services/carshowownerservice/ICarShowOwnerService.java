/**
 *
 * @author David Beltran
 * File: ICarShowOwnerService.java
 * This file contains the ICarShowOwnerService interface which is responsible for
 * creating and managing the collection that stores CarShowOwner objects.
 */
package edu.du.beltrandavid.model.services.carshowownerservice;

import edu.du.beltrandavid.model.domain.CarShowOwner;
import edu.du.beltrandavid.model.services.IServices;
import java.util.Iterator;


public interface ICarShowOwnerService extends IServices {
  public final String NAME = "ICarShowOwnerService";
  
  public boolean add(CarShowOwner carShowOwner);
  public boolean remove(CarShowOwner carShowOwner);
  public CarShowOwner find(String carShowId, String ownerId);
  public boolean isPresent(String ownerId);
  public boolean isPresent(String carShowId, String ownerId);
  public boolean isPresent(CarShowOwner carShowOwner);
  public void dump();
  public Iterator<CarShowOwner> getCarShowOwners();
  public void emptyList();
  public String getName();
}
