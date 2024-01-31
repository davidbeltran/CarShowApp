/**
 *
 * @author David Beltran
 * File: OwnerHashSetImpl.java
 * This file contains the OwnerHashSetImpl class which is responsible for
 * creating and managing the HashSet that stores Owner objects.
 */
package edu.du.beltrandavid.model.services.ownerservice;

import edu.du.beltrandavid.model.domain.Owner;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class OwnerHashSetImpl implements IOwnerService{
  private static final HashSet<Owner> ownerHashSet = new HashSet<>();
  private static int hold = 1;

  /**
   * Constructor with no arguments
   */
  public OwnerHashSetImpl() {
  }

  /**
   *
   * @return
   * Returns an Iterator object filled with HashSet content
   */
  @Override
  public Iterator<Owner> getOwners() {
    return ownerHashSet.iterator();
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
    OwnerHashSetImpl.hold = hold;
  }

  /**
   *
   * @param owner
   * @return
   * Adds a Owner object to the HashSet.
   */
  @Override
  public boolean add(Owner owner) {
    checkDuplicate(owner);
    return ownerHashSet.add(owner);
  }

  /**
   * 
   * @param owner 
   * Checks Owner ID if a duplicate. 
   * Duplicate ID is then updated to have a unique value from all other 
   * Owner objects in HashSet. Used within the add() method.
   */
  private void checkDuplicate(Owner owner) {
    int check = 1;
    do {
      for (Owner o: ownerHashSet) {
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
   * Removes a Owner object from HashSet using a Owner object as an argument.
   */
  @Override
  public boolean remove(Owner owner) {
    return ownerHashSet.remove(owner);
  }

  /**
   *
   * @param ownerId
   * @return
   * Removes a Owner object from HashSet using a String as an argument.
   */
  @Override
  public boolean remove(String ownerId) {
    boolean bool = false;
    Iterator<Owner> itr = ownerHashSet.iterator();
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
   * Returns a Owner object using a String argument from the HashSet
   */
  @Override
  public Owner find(String ownerId) {
    Owner owner = null;
    for (Owner o: ownerHashSet) {
      if (o.getOwnerId().equalsIgnoreCase(ownerId)) {
        owner = o;
      }
    }
    return owner;
  }
  
  /**
   * Displays all CarShow objects stored within the ArrayList
   */
  @Override
  public void dump() {
    for (Owner o: ownerHashSet) {
      System.out.println(o.toString());
    }
  }

  /**
   *
   * @param owner
   * @return
   * Returns a Boolean indicating whether a Owner object is stored 
   * in the HashSet using a Owner object as an argument.
   */
  @Override
  public boolean isPresent(Owner owner) {
    boolean bool = false;
    for (Owner o: ownerHashSet) {
      if (o.equals(owner)) {
        bool = true;
      }
    }
    return bool;
  }

  /**
   *
   * @param ownerId
   * @return
   * Returns a Boolean indicating whether a Owner object is stored 
   * in the HashSet using one String value as an argument.
   */
  @Override
  public boolean isPresent(String ownerId) {
    boolean bool = false;
    for (Owner o: ownerHashSet) {
      if (o.getOwnerId().equals(ownerId)) {
        bool = true;
      }
    }
    return bool;
  }

  /**
   * Removes all items from the HashSet
   */
  @Override
  public void emptyList() {
    ownerHashSet.clear();
  }
  
  @Override
  public String getName() {
    return OwnerHashSetImpl.NAME;
  }
  
  @Override
  public String[] getOwnerIds() {
    Set<String> ids = new HashSet<>();
    for (Owner o: ownerHashSet) {
      ids.add(o.getOwnerId());
    }
    return ids.toArray(new String[0]);
  }
}
