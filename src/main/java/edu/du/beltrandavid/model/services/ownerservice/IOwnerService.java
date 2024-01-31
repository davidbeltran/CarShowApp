/**
 *
 * @author David Beltran
 * File: IOwnerService.java
 * This file contains the IOwnerService interface which is responsible for
 * creating and managing the collection that stores Owner objects.
 */
package edu.du.beltrandavid.model.services.ownerservice;

import edu.du.beltrandavid.model.domain.Owner;
import edu.du.beltrandavid.model.services.IServices;
import java.util.Iterator;

public interface IOwnerService extends IServices{
  public final String NAME = "IOwnerService";
  
  public boolean add(Owner owner);
  public boolean remove(Owner owner);
  public boolean remove(String ownerId);
  public Owner find(String OwnerId);
  public boolean isPresent(Owner owner);
  public boolean isPresent(String ownerId);
  public void dump();
  public Iterator<Owner> getOwners();
  public void emptyList();
  public String getName();
  public String[] getOwnerIds();
}
