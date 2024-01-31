/**
 *
 * @author instructor, modified by David Beltran
 * File: Manager.java
 * This file contains the Manager class that manages the service implementation returned
 * from the ServiceFactory object.
 */
package edu.du.beltrandavid.model.business.manager;

import edu.du.beltrandavid.model.business.factory.ServiceFactory;
import edu.du.beltrandavid.model.services.IServices;

public class Manager {
  private final ServiceFactory serviceFactory = ServiceFactory.getInstance();

  /**
   *
   */
  protected String file;
  
  /**
   *
   * @param name
   * @return
   * @throws Exception
   * Returns service class with selected collection type
   */
  protected IServices getService (String name) throws Exception {
    serviceFactory.setServiceProperties(file);
    IServices serviceName = serviceFactory.getService(name);
    return serviceName;
  }
}
