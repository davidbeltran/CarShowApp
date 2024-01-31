/**
 *
 * @author David Beltran
 * File: CarShowOwnerArrayListImpl.java
 * This file contains the CarShowOwnerArrayListImpl class which is responsible for
 * creating and managing the ArrayList that stores CarShowOwner objects.
 */
package edu.du.beltrandavid.model.services.carshowownerservice;

import edu.du.beltrandavid.model.domain.CarShowOwner;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class CarShowOwnerArrayListImpl implements ICarShowOwnerService {
  private static final ArrayList<CarShowOwner> carShowOwnerArrayList = new ArrayList<>();
  private static int hold = 1;//var holds integer to adjust duplicate ID numbers.

  /**
   * Constructor with no arguments
   */
  public CarShowOwnerArrayListImpl() {
  }
  
  /**
   * @return
   * Returns an Iterator object filled with ArrayList content
   */
  @Override
  public Iterator<CarShowOwner> getCarShowOwners() {
    return carShowOwnerArrayList.iterator();
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
    CarShowOwnerArrayListImpl.hold = hold;
  }

  @Override
  public int hashCode() {
    int hash = 5;
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
    final CarShowOwnerArrayListImpl other = (CarShowOwnerArrayListImpl) obj;
    if (!Objects.equals(carShowOwnerArrayList, other.carShowOwnerArrayList)) {
      return false;
    }
    return true;
  }
  
  /**
   *
   * @param carShowOwner
   * @return
   * Adds a CarShowOwner object to the ArrayList.
   */
  @Override
  public boolean add(CarShowOwner carShowOwner) {
    boolean bool = carShowOwnerArrayList.add(carShowOwner);
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
   * Checks CarShowOwner owner ID if a duplicate. 
   * Duplicate ID is then updated to have a unique value from all other 
   * CarShowOwner objects in ArrayList. Used within the add() method.
   */
  private void checkDuplicate(CarShowOwner carShowOwner) {
    int check =1;
    do {
      for (CarShowOwner cso: carShowOwnerArrayList) {
        check = 1;
        if (cso.getOwnerId().equals(carShowOwner.getOwnerId())) {
          check = 0;
          System.out.println("Car show owner " + carShowOwner.getOwnerId() + 
              " was given a duplicate ID number.");
          hold = hold++;
          carShowOwner.setOwnerId(carShowOwner.getOwnerId() + hold);
          System.out.println("Car show owner's ID was changed to " + 
              carShowOwner.getOwnerId() + ".\n");
        }
      }
    } while (check == 0);
    System.out.println("Car show owner " + carShowOwner.getOwnerId() + 
        " was added as a car show owner successfully.\n");
  }
  
  /**
   *
   * @param carShowOwner
   * @return
   * Removes a CarShowOwner object from ArrayList using a CarShowOwner object as an argument.
   */
  @Override
  public boolean remove(CarShowOwner carShowOwner) {
    return carShowOwnerArrayList.remove(carShowOwner);
  }
  
  /**
   *
   * @param carShowId
   * @param ownerId
   * @return
   * Returns a CarShowOwner object using String arguments from the ArrayList
   */
  @Override
  public CarShowOwner find(String carShowId, String ownerId){
    CarShowOwner carShowOwner = null;
    for (CarShowOwner cso: carShowOwnerArrayList) {
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
   * in the ArrayList using one String value as an argument.
   */
  @Override
  public boolean isPresent(String ownerId) {
    boolean bool = false;
    for (CarShowOwner cso: carShowOwnerArrayList) {
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
   * in the ArrayList using two String values as arguments.
   */
  @Override
  public boolean isPresent(String carShowId, String ownerId) {
    boolean bool = false;
    for (CarShowOwner cso: carShowOwnerArrayList) {
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
   * in the ArrayList using a CarShowOwner object as an argument.
   */
  @Override
  public boolean isPresent(CarShowOwner carShowOwner) {
    boolean bool = false;
    for (CarShowOwner cso: carShowOwnerArrayList) {
      if (cso.equals(carShowOwner)) {
        bool = true;
      }
    }
    return bool;
  }
  
  /**
   * Displays all CarShowOwner objects stored within the ArrayList
   */
  @Override
  public void dump() {
    for (CarShowOwner cso: carShowOwnerArrayList) {
      System.out.println(cso.toString());
    }
  }

  /**
   * Removes all items from the HashSet
   */
  @Override
  public void emptyList() {
    carShowOwnerArrayList.clear();
  }
  
  @Override
  public String getName() {
    return CarShowOwnerArrayListImpl.NAME;
  }
}
