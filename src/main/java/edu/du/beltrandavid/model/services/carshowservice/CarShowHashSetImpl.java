/**
 *
 * @author David Beltran
 * File: CarShowHashSetImpl.java
 * This file contains the CarShowHashSetImpl class which is responsible for
 * creating and managing the HashSet that stores CarShow objects.
 */
package edu.du.beltrandavid.model.services.carshowservice;

import edu.du.beltrandavid.model.domain.CarShow;
import java.util.HashSet;
import java.util.Iterator;

public class CarShowHashSetImpl implements ICarShowService {
  private static final HashSet<CarShow> carShowHashSet = new HashSet<>();
  private static int hold = 1;

  /**
   * Constructor with no arguments 
   */
  public CarShowHashSetImpl() {
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
    CarShowHashSetImpl.hold = hold;
  }

  /**
   *
   * @param carShow
   * @return
   * Adds a CarShow object to the HashSet.
   */
  @Override
  public boolean add(CarShow carShow) {
    checkDuplicate(carShow);
    return carShowHashSet.add(carShow);
  }

  /**
   * 
   * @param carShow 
   * Checks CarShow ID if a duplicate. 
   * Duplicate ID is then updated to have a unique value from all other 
   * CarShow objects in HashSet. Used within the add() method.
   */
  private void checkDuplicate(CarShow carShow) {
    int check = 1;
    do {
      for (CarShow cs: carShowHashSet) {
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
   * Removes a CarShow object from HashSet using a CarShow object as an argument.
   */
  @Override
  public boolean remove(CarShow carShow) {
    return carShowHashSet.remove(carShow);
  }

  /**
   *
   * @param carShowId
   * @return
   * Removes a CarShow object from HashSet using a String as an argument.
   */
  @Override
  public boolean remove(String carShowId) {
    boolean bool = false;
    Iterator<CarShow> itr = carShowHashSet.iterator();
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
   * Returns a CarShow object using a String argument from the HashSet
   */
  @Override
  public CarShow find(String carShowId) {
    CarShow carShow = null;
    for (CarShow cs: carShowHashSet) {
      if (cs.getCarShowId().equalsIgnoreCase(carShowId)) {
        carShow = cs;
      }
    }
    return carShow;
  }

  /**
   *
   * @param carShow
   * @return
   * Returns a Boolean indicating whether a CarShow object is stored 
   * in the HashSet using one String value as an argument.
   */
  @Override
  public boolean isPresent(CarShow carShow) {
    boolean bool = false;
    for (CarShow cs: carShowHashSet) {
      if (cs.equals(carShow)) {
        bool = true;
      }
    }
    return bool;
  }

  /**
   *
   * @param carShowId
   * @return
   * Returns a Boolean indicating whether a CarShow object is stored 
   * in the HashSet using a CarShow object as an argument.
   */
  @Override
  public boolean isPresent(String carShowId) {
    boolean bool = false;
    for (CarShow cs: carShowHashSet) {
      if (cs.getCarShowId().equals(carShowId)){
        bool = true;
      }
    }
    return bool;
  }

  /**
   * Displays all CarShow objects stored within the HashSet
   */
  @Override
  public void dump() {
    for (CarShow cs: carShowHashSet) {
      System.out.println(cs.toString());
    }
  }

  /**
   *
   * @return
   * Returns an Iterator object filled with HashSet content
   */
  @Override
  public Iterator<CarShow> getCarShows() {
    return carShowHashSet.iterator();
  }

  /**
   * Removes all items from the HashSet
   */
  @Override
  public void emptyList() {
    carShowHashSet.clear();
  }
  
  @Override
  public String getName() {
    return CarShowHashSetImpl.NAME;
  }
}
