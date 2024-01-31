/**
 *
 * @author David Beltran
 * File: CarShowOwnerHashSetImpl.java
 * This file contains the CarShowOwnerHashSetImpl class which is responsible for
 * creating and managing the HashSet that stores CarShowOwner objects.
 */
package edu.du.beltrandavid.model.services.carshowownerservice;

import edu.du.beltrandavid.model.domain.CarShowOwner;
import java.util.HashSet;
import java.util.Iterator;

public class CarShowOwnerHashSetImpl implements ICarShowOwnerService {
  private static final HashSet<CarShowOwner> carShowOwnerHashSet = new HashSet<>();
  private static int hold = 1;

  /**
   * Constructor with no arguments
   */
  public CarShowOwnerHashSetImpl() {
  }

  /**
   *
   * @return
   */
  public static int getHold() {
    return hold;
  }

  /**
   *
   * @param hold
   */
  public static void setHold(int hold) {
    CarShowOwnerHashSetImpl.hold = hold;
  }

  /**
   *
   * @param carShowOwner
   * @return
   * Adds a CarShowOwner object to the HashSet.
   */
  @Override
  public boolean add(CarShowOwner carShowOwner) {
    boolean bool = carShowOwnerHashSet.add(carShowOwner);
    if (bool == true) {
      System.out.println("Car show owner " + carShowOwner.getOwnerId() + 
          " with car show ID " + carShowOwner.getCarShowId() + 
          " was added as a car show owner successfully.\n");
    }
    return bool;
  }

  /**
   *
   * @param carShowOwner
   * @return
   * Removes a CarShowOwner object from HashSet using a CarShowOwner object as an argument.
   */
  @Override
  public boolean remove(CarShowOwner carShowOwner) {
    return carShowOwnerHashSet.remove(carShowOwner);
  }

  /**
   *
   * @param carShowId
   * @param ownerId
   * @return
   * Returns a CarShowOwner object using String arguments from the HashSet
   */
  @Override
  public CarShowOwner find(String carShowId, String ownerId) {
    CarShowOwner carShowOwner = null;
    for (CarShowOwner cso: carShowOwnerHashSet) {
      if ((cso.getCarShowId().equalsIgnoreCase(carShowId)) && 
          (cso.getOwnerId().equalsIgnoreCase(ownerId))) {
        carShowOwner = cso;
      }
    }
    return carShowOwner;
  }

  /**
   *
   * @param ownerId
   * @return
   * Returns a Boolean indicating whether a CarShowOwner object is stored 
   * in the HashSet using one String value as an argument.
   */
  @Override
  public boolean isPresent(String ownerId) {
    boolean bool = false;
    for (CarShowOwner cso: carShowOwnerHashSet) {
      if (cso.getOwnerId().equals(ownerId)) {
        bool = true;
      }
    }
    return bool;
  }

  /**
   *
   * @param carShowId
   * @param ownerId
   * @return
   * Returns a Boolean indicating whether a CarShowOwner object is stored 
   * in the HashSet using two String values as arguments.
   */
  @Override
  public boolean isPresent(String carShowId, String ownerId) {
    boolean bool = false;
    for (CarShowOwner cso: carShowOwnerHashSet) {
      if ((cso.getOwnerId().equals(ownerId)) && (cso.getCarShowId().equals(carShowId))) {
        bool = true;
      }
    }
    return bool;
  }

  /**
   *
   * @param carShowOwner
   * @return
   * Returns a Boolean indicating whether a CarShowOwner object is stored 
   * in the HashSet using a CarShowOwner object as an argument.
   */
  @Override
  public boolean isPresent(CarShowOwner carShowOwner) {
    boolean bool = false;
    for (CarShowOwner cso: carShowOwnerHashSet) {
      if (cso.equals(carShowOwner)) {
        bool = true;
      }
    }
    return bool;
  }

  /**
   * Displays all CarShowOwner objects stored within the HashSet
   */
  @Override
  public void dump() {
    for (CarShowOwner cso: carShowOwnerHashSet) {
      System.out.println(cso.toString());
    }
  }

  /**
   *
   * @return
   * Returns an Iterator object filled with HashSet content
   */
  @Override
  public Iterator<CarShowOwner> getCarShowOwners() {
    return carShowOwnerHashSet.iterator();
  }

  /**
   * Removes all items from the HashSet
   */
  @Override
  public void emptyList() {
    carShowOwnerHashSet.clear();
  }
  
  @Override
  public String getName() {
    return CarShowOwnerHashSetImpl.NAME;
  }
}
