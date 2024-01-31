/**
 *
 * @author David Beltran
 * File: VehicleHashSetImpl.java
 * This file contains the VehicleHashSetImpl class which is responsible for
 * creating and managing the HashSet that stores CarShow objects.
 */
package edu.du.beltrandavid.model.services.vehicleservice;

import edu.du.beltrandavid.model.domain.Vehicle;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

public class VehicleHashSetImpl implements IVehicleService {
  private static final HashSet<Vehicle> vehicleHashSet = new HashSet<>();
  private static int hold = 1;

  /**
   * Constructor with no arguments
   */
  public VehicleHashSetImpl() {
  }

  /**
   *
   * @return
   * Returns an Iterator object filled with HashSet content
   */
  public HashSet<Vehicle> getVehicleHashSet() {
    return vehicleHashSet;
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
    VehicleHashSetImpl.hold = hold;
  }

  @Override
  public int hashCode() {
    int hash = 3;
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final VehicleHashSetImpl other = (VehicleHashSetImpl) obj;
    if (!Objects.equals(vehicleHashSet, other.vehicleHashSet)) {
      return false;
    }
    return true;
  }

  /**
   *
   * @param vehicle
   * @return
   * Adds a Vehicle object to the HashSet.
   */
  @Override
  public boolean add(Vehicle vehicle) {
    checkDuplicate(vehicle);
    return vehicleHashSet.add(vehicle);
  }

  /**
   * 
   * @param vehicle 
   * Checks Vehicle ID if a duplicate. 
   * Duplicate ID is then updated to have a unique value from all other 
   * Vehicle objects in HashSet. Used within the add() method.
   */
  private void checkDuplicate(Vehicle vehicle) {
    int check = 1;
    do {
      for (Vehicle v: vehicleHashSet) {
        check = 1;
        if (v.getVehicleId().equals(vehicle.getVehicleId())) {
          check = 0;
          System.out.println(vehicle.getModelYear() + " " + vehicle.getManufacturer() + 
              " " + vehicle.getModel() + " " + vehicle.getSubmodel() + 
              " was given duplicate ID number " + v.getVehicleId() + ".");
          hold = hold++;
          vehicle.setVehicleId(vehicle.getVehicleId() + hold);
          System.out.println(vehicle.getModelYear() + " " + vehicle.getManufacturer() + 
              " " + vehicle.getModel() + " " + vehicle.getSubmodel() + 
              "'s vehicle ID was changed to " + vehicle.getVehicleId() + ".\n");
        }
      }
    } while (check == 0);
    System.out.println(vehicle.getModelYear() + " " + vehicle.getManufacturer() + 
        " " + vehicle.getModel() + " " + vehicle.getSubmodel() + " for owner " + 
        vehicle.getOwnerId() + " was added as a vehicle succesfully.\n");
  }
  
  /**
   *
   * @param vehicle
   * @return
   * Removes a Vehicle object from HashSet using a Vehicle object as an argument.
   */
  @Override
  public boolean remove(Vehicle vehicle) {
    boolean bool = false;
    if (!(isPresent(vehicle))) {
      System.out.println("Vehicle with ID " + vehicle.getVehicleId() + 
          " is not present and cannot be removed.\n");
    } else {
      bool = vehicleHashSet.remove(vehicle);
      System.out.println("Vehicle with ID " + vehicle.getVehicleId() + 
          " was removed from the vehicle list.\n");
    }
    return bool;
  }

  /**
   *
   * @param vehicleId
   * Removes a Vehicle object from HashSet using a Vehicle ID as an argument.
   * @return
   */
  @Override
  public boolean remove(String vehicleId) {
    boolean bool = false;
    if (!(isPresent(vehicleId))) {
      System.out.println("Vehicle with ID " + vehicleId + 
          " is not present and cannot be removed.\n");
    } else {
      Iterator<Vehicle> itr = vehicleHashSet.iterator();
      while (itr.hasNext()) {
        Vehicle car = itr.next();
        if (car.getVehicleId().equals(vehicleId)) {
          itr.remove();
          bool = true;
      System.out.println("Vehicle with ID " + vehicleId + 
          " was removed from the vehicle list.\n");
        }
      }
    }
    return bool;
  }

  /**
   *
   * @param vehicleId
   * @return
   * Returns a Vehicle object using a String argument from the HashSet
   */
  @Override
  public Vehicle find(String vehicleId) {
    Vehicle car = null;
    for (Vehicle v: vehicleHashSet) {
      if (v.getVehicleId().equalsIgnoreCase(vehicleId)) {
        car = v;
      }
    }
    return car;
  }

  /**
   *
   * @param vehicle
   * @return
   * Returns a Boolean indicating whether a Vehicle object is stored 
   * in the HashSet using a Vehicle object as an argument.
   */
  @Override
  public boolean isPresent(Vehicle vehicle) {
    boolean bool = false;
    for (Vehicle v: vehicleHashSet) {
      if (v.equals(vehicle)) {
        bool = true;
      }
    }
    return bool;
  }

  /**
   *
   * @param vehicleId
   * @return
   * Returns a Boolean indicating whether a Vehicle object is stored 
   * in the HashSet using one String value as an argument.
   */
  @Override
  public boolean isPresent(String vehicleId) {
    boolean bool = false;
    for (Vehicle v: vehicleHashSet) {
      if(v.getVehicleId().equals(vehicleId)) {
        bool = true;
      }
    }
    return bool;
  }

  /**
   * Displays all Vehicle objects stored within the HashSet
   */
  @Override
  public void dump() {
    for (Vehicle v: vehicleHashSet) {
      System.out.println(v.toString());
    }
  }

  /**
   *
   * @return
   * Returns an Iterator object filled with HashSet content
   */
  @Override
  public Iterator<Vehicle> getVehicles() {
    return vehicleHashSet.iterator();
  }

  /**
   * Removes all items from the HashSet
   */
  @Override
  public void emptyList() {
    vehicleHashSet.clear();
  }
  
  @Override
  public String getName() {
    return VehicleHashSetImpl.NAME;
  }
}
