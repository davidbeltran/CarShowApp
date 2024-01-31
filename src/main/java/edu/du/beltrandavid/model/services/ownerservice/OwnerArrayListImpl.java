/**
 *
 * @author David Beltran
 * File: OwnerArrayListImpl.java
 * This file contains the OwnerArrayListImpl class which is responsible for
 * creating and managing the ArrayList that stores Owner objects.
 */
package edu.du.beltrandavid.model.services.ownerservice;

import edu.du.beltrandavid.model.domain.Owner;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class OwnerArrayListImpl implements IOwnerService {
  private static final ArrayList<Owner> ownerArrayList = new ArrayList<>();
  private static int hold = 1;

  /**
   * Constructor with no arguments
   */
  public OwnerArrayListImpl() {
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
    OwnerArrayListImpl.hold = hold;
  }

  /**
   *
   * @return
   * Returns an Iterator object filled with HashSet content
   */
  @Override
  public Iterator<Owner> getOwners() {
    return ownerArrayList.iterator();
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
    final OwnerArrayListImpl other = (OwnerArrayListImpl) obj;
    if (!Objects.equals(ownerArrayList, other.ownerArrayList)) {
      return false;
    }
    return true;
  }
  
  /**
   *
   * @param owner
   * @return
   * Adds a Owner object to the ArrayList.
   */
  @Override
  public boolean add(Owner owner) {
    checkDuplicateId(owner);
    return ownerArrayList.add(owner);
  }
  
  /**
   * 
   * @param owner 
   * Checks Owner ID if a duplicate. 
   * Duplicate ID is then updated to have a unique value from all other 
   * Owner objects in ArrayList. Used within the add() method.
   */
  private void checkDuplicateId(Owner owner) {
    int check = 1;
    do {
      for (Owner o: ownerArrayList) {
        check = 1;
        if (o.getOwnerId().equals(owner.getOwnerId())) {
          check = 0;
          System.out.println(owner.getFirstName() + " " + owner.getLastName() + 
              " was given duplicate ID number " + o.getOwnerId() + ".");
          hold = hold++;
          owner.setOwnerId(owner.getOwnerId() + hold);
          System.out.println(owner.getFirstName() + " " + owner.getLastName() + 
              "'s owner ID was changed to " + owner.getOwnerId() + ".\n");
        }
      }
    } while (check == 0);
    System.out.println(owner.getFirstName() + " " + owner.getLastName() + 
        " was added as an owner successfully.\n");
  }
  
  /**
   *
   * @param owner
   * @return
   * Removes a Owner object from ArrayList using a Owner object as an argument.
   */
  @Override
  public boolean remove(Owner owner) {
    return ownerArrayList.remove(owner);
  }
  
  /**
   *
   * @param ownerId
   * @return
   * Removes a Owner object from ArrayList using a String as an argument.
   */
  @Override
  public boolean remove(String ownerId) {
    boolean bool = false;
    Iterator<Owner> itr = ownerArrayList.iterator();
    while (itr.hasNext()) {
      Owner owner = itr.next();
      if (owner.getOwnerId().equals(ownerId)) {
        itr.remove();
        bool = true;
      }
    }
    return bool;
  }
  
  /**
   *
   * @param ownerId
   * @return
   * Returns a Owner object using a String argument from the ArrayList
   */
  @Override
  public Owner find(String ownerId) {
    Owner owner = null;
    for (Owner o: ownerArrayList) {
      if (o.getOwnerId().equalsIgnoreCase(ownerId)) {
        owner = o;
      }
    }
    return owner;
  }
  
  /**
   *
   * @param ownerId
   * @return
   * Returns a Boolean indicating whether a Owner object is stored 
   * in the ArrayList using one String value as an argument.
   */
  @Override
  public boolean isPresent(String ownerId) {
    boolean bool = false;
    for (Owner o: ownerArrayList) {
      if (o.getOwnerId().equals(ownerId)) {
        bool = true;
      }
    }
    return bool;
  }
  
  /**
   *
   * @param owner
   * @return
   * Returns a Boolean indicating whether a Owner object is stored 
   * in the ArrayList using a Owner object as an argument.
   */
  @Override
  public boolean isPresent(Owner owner) {
    boolean bool = false;
    for (Owner o: ownerArrayList) {
      if (o.equals(owner)) {
        bool = true;
      }
    }
    return bool;
  }
  
  /**
   * Displays all CarShow objects stored within the ArrayList
   */
  @Override
  public void dump() {
    for (Owner o: ownerArrayList) {
      System.out.println(o.toString());
    }
  }
  
  /**
   * Removes all items from the HashSet
   */
  @Override
  public void emptyList() {
    ownerArrayList.clear();
  }
  
  @Override
  public String getName() {
    return OwnerArrayListImpl.NAME;
  }
  
  @Override
  public String[] getOwnerIds() {
    List<String> ids = new ArrayList<>();
    for (Owner o: ownerArrayList) {
      ids.add(o.getOwnerId());
    }
    return ids.toArray(new String[0]);
  }
}
