/**
 *
 * @author David Beltran
 * File: OwnerManager.java
 * This file contains the OwnerManager class that manages the service implementation returned
 * from the ServiceFactory object. All methods except setServiceProperties() handle service class
 * methods using the selected implementation.
 */
package edu.du.beltrandavid.model.business.manager.ownermanager;

import edu.du.beltrandavid.model.business.manager.Manager;
import edu.du.beltrandavid.model.domain.Owner;
import edu.du.beltrandavid.model.services.ownerservice.IOwnerService;
import java.util.Iterator;

public class OwnerManager extends Manager{
  
  /**
   *
   * @param owner
   * @return
   * @throws Exception
   * Manages add() method after applying selected collection type
   */
  public boolean add (Owner owner) throws Exception {
    boolean retVal = false;
    try {
      IOwnerService ownerService = (IOwnerService) getService(IOwnerService.NAME);
      retVal = ownerService.add(owner);
    } catch (Exception e) {
      throw e;
    }
    System.out.println();
    return retVal;
  }
  
  /**
   *
   * @param owner
   * @return
   * @throws Exception
   * Manages remove() method after applying selected collection type
   */
  public boolean remove(Owner owner) throws Exception {
    boolean retVal = false;
    try {
      IOwnerService ownerService = (IOwnerService) getService(IOwnerService.NAME);
      retVal = ownerService.remove(owner);
    } catch (Exception e) {
      throw e;
    }
    return retVal;
  }
  
  /**
   *
   * @param ownerId
   * @return
   * @throws Exception
   * Manages remove() method after applying selected collection type
   */
  public boolean remove(String ownerId) throws Exception {
    boolean retVal = false;
    try {
      IOwnerService ownerService = (IOwnerService) getService(IOwnerService.NAME);
      retVal = ownerService.remove(ownerId);
    } catch (Exception e) {
      throw e;
    }
    return retVal;
  }
  
  /**
   *
   * @param ownerId
   * @return
   * @throws Exception
   * Manages find() method after applying selected collection type
   */
  public Owner find(String ownerId) throws Exception {
    Owner owner = null;
    try {
      IOwnerService ownerService = (IOwnerService) getService(IOwnerService.NAME);
      owner = ownerService.find(ownerId);
    } catch (Exception e) {
      throw e;
    }
    return owner;
  }
  
  /**
   *
   * @param owner
   * @return
   * @throws Exception
   * Manages isPresent() method after applying selected collection type
   */
  public boolean isPresent(Owner owner) throws Exception {
    boolean retVal = false;
    try {
      IOwnerService ownerService = (IOwnerService) getService(IOwnerService.NAME);
      retVal = ownerService.isPresent(owner);
    } catch (Exception e) {
      throw e;
    }
    return retVal;
  }
  
  /**
   *
   * @param ownerId
   * @return
   * @throws Exception
   * Manages isPresent() method after applying selected collection type
   */
  public boolean isPresent(String ownerId) throws Exception {
    boolean retVal = false;
    try {
      IOwnerService ownerService = (IOwnerService) getService(IOwnerService.NAME);
      retVal = ownerService.isPresent(ownerId);
    } catch (Exception e) {
      throw e;
    }
    return retVal;
  }
  
  /**
   *
   * @throws Exception
   * Manages dump() method after applying selected collection type
   */
  public void dump() throws Exception {
    try {
      IOwnerService ownerService = (IOwnerService) getService(IOwnerService.NAME);
      ownerService.dump();
    } catch (Exception e) {
      throw e;
    }
  }
  
  /**
   *
   * @return
   * @throws Exception
   * Manages getOwners() method after applying selected collection type
   */
  public Iterator<Owner> getOwners() throws Exception {
    Iterator<Owner> owners = null;
    try {
      IOwnerService ownerService = (IOwnerService) getService(IOwnerService.NAME);
      owners = ownerService.getOwners();
    } catch (Exception e) {
      throw e;
    }
    return owners;
  }
  
  /**
   *
   * @throws Exception
   * Manages emptyList() method after applying selected collection type
   */
  public void emptyList() throws Exception {
    try {
      IOwnerService ownerService = (IOwnerService) getService(IOwnerService.NAME);
      ownerService.emptyList();
    } catch (Exception e) {
      throw e;
    }
  }
  
  /**
   * 
   * @param file 
   * sets the text file that gives command on which service implementation to use
   */
  public void setServiceProperties(String file) {
    this.file = file;
  }
}
