/**
 *
 * @author  David Beltran
 * File: PersistenceManager.java
 * This file contains the PersistenceManager class that manages the service 
 * implementation returned from the PersistFactory object.
 */
package edu.du.beltrandavid.model.business.manager;

import edu.du.beltrandavid.model.business.factory.PersistFactory;
import edu.du.beltrandavid.model.services.IPersistServices;

public class PersistenceManager {
  private final PersistFactory persistFactory = PersistFactory.getInstance();

  /**
   *
   */
  protected String file;
  
  /**
   *
   * @param name
   * @return
   * @throws Exception
   * Returns service class by selected persist file type
   */
  protected IPersistServices getService(String name) throws Exception {
    persistFactory.setPersistProperties(file);
    IPersistServices serviceName = persistFactory.getService(name);
    return serviceName;
  }
}
