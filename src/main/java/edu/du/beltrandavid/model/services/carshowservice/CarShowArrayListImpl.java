/**
 *
 * @author David Beltran
 * File: CarShowArrayListImpl.java
 * This file contains the CarShowArrayListImpl class which is responsible for
 * creating and managing the ArrayList that stores CarShow objects.
 */
package edu.du.beltrandavid.model.services.carshowservice;

import edu.du.beltrandavid.model.domain.CarShow;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class CarShowArrayListImpl implements ICarShowService {
  private static final ArrayList<CarShow> carShowArrayList = new ArrayList<>();
  private static int hold = 1;

  /**
   * Constructor with no arguments 
   */
  public CarShowArrayListImpl() {
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
    CarShowArrayListImpl.hold = hold;
  }

  /**
   *
   * @return
   * Returns an Iterator object filled with ArrayList content
   */
  @Override
  public Iterator<CarShow> getCarShows() {
    return carShowArrayList.iterator();
  }

  @Override
  public int hashCode() {
    int hash = 7;
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
    final CarShowArrayListImpl other = (CarShowArrayListImpl) obj;
    if (!Objects.equals(carShowArrayList, other.carShowArrayList)) {
      return false;
    }
    return true;
  }

  /**
   *
   * @param carShow
   * @return
   * Adds a CarShow object to the ArrayList.
   */
  @Override
  public boolean add(CarShow carShow) {
    checkDuplicate(carShow);
    return carShowArrayList.add(carShow);
  }
  
  /**
   * 
   * @param carShow 
   * Checks CarShow ID if a duplicate. 
   * Duplicate ID is then updated to have a unique value from all other 
   * CarShow objects in ArrayList. Used within the add() method.
   */
  private void checkDuplicate(CarShow carShow) {
    int check = 1;
    do {
      for (CarShow cs: carShowArrayList) {
        check = 1;
        if (cs.getCarShowId().equals(carShow.getCarShowId())) {
          check = 0;
          System.out.println(carShow.getCarShowDate() + " " + carShow.getCarShowTitle() + 
              " was given duplicate ID number " + cs.getCarShowId());
          hold = hold++;
          carShow.setCarShowId(carShow.getCarShowId() + hold);
          System.out.println(carShow.getCarShowDate() + " " + carShow.getCarShowTitle() +
              "'s car show ID was changed to " + carShow.getCarShowId() + ".\n");
        }
      }
    } while (check == 0);
    System.out.println(carShow.getCarShowDate() + " " + carShow.getCarShowTitle() +
        " was added as a car show successfully.\n");
  }
  
  /**
   *
   * @param carShow
   * @return
   * Removes a CarShow object from ArrayList using a CarShow object as an argument.
   */
  @Override
  public boolean remove(CarShow carShow) {
    return carShowArrayList.remove(carShow);
  }
  
  /**
   *
   * @param carShowId
   * @return
   * Removes a CarShow object from ArrayList using a String as an argument.
   */
  @Override
  public boolean remove(String carShowId) {
    boolean bool = false;
    Iterator<CarShow> itr = carShowArrayList.iterator();
    while (itr.hasNext()) {
      CarShow show = itr.next();
      if (show.getCarShowId().equals(carShowId)) {
        itr.remove();
        bool = true;
      }
    }
    return bool;
  }
  
  /**
   *
   * @param carShowId
   * @return
   * Returns a CarShow object using a String argument from the ArrayList
   */
  @Override
  public CarShow find(String carShowId) {
    CarShow carShow = null;
    for (CarShow cs: carShowArrayList) {
      if (cs.getCarShowId().equalsIgnoreCase(carShowId)) {
        carShow = cs;
      }
    }
    return carShow;
  }
  
  /**
   *
   * @param carShowId
   * @return
   * Returns a Boolean indicating whether a CarShow object is stored 
   * in the ArrayList using one String value as an argument.
   */
  @Override
  public boolean isPresent(String carShowId) {
    boolean bool = false;
    for (CarShow cs: carShowArrayList) {
      if (cs.getCarShowId().equals(carShowId)){
        bool = true;
      }
    }
    return bool;
  }
  
  /**
   *
   * @param carShow
   * @return
   * Returns a Boolean indicating whether a CarShow object is stored 
   * in the ArrayList using a CarShow object as an argument.
   */
  @Override
  public boolean isPresent(CarShow carShow) {
    boolean bool = false;
    for (CarShow cs: carShowArrayList) {
      if (cs.equals(carShow)) {
        bool = true;
      }
    }
    return bool;
  }
  
  /**
   *
   * Displays all CarShow objects stored within the ArrayList
   */
  @Override
  public void dump() {
    for (CarShow cs: carShowArrayList) {
      System.out.println(cs.toString());
    }
  }

  /**
   * Removes all items from the ArrayList
   */
  @Override
  public void emptyList() {
    carShowArrayList.clear();
  }
  
  @Override
  public String getName() {
    return CarShowArrayListImpl.NAME;
  }
}
