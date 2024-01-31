/**
 *
 * @author David Beltran
 * File: PersistFactory.java
 * This file contains the PersistFactory class that helps the PersistenceManager classes
 * instantiate the correct collection type service implementation
 */
package edu.du.beltrandavid.model.business.factory;

import edu.du.beltrandavid.model.services.IPersistServices;

public class PersistFactory {

  /**
   *
   */
  public PersistFactory() {
  }
  
  private static final PersistFactory persistFactory = new PersistFactory();
  private String persistPropertyFile;
  
  /**
   *
   * @return
   */
  public static PersistFactory getInstance() {
    return persistFactory;
  }
  
  /**
   *
   * @param serviceName
   * @return
   * @throws Exception
   * Returns Service object described by argument
   */
  public IPersistServices getService(String serviceName) throws Exception {
    Class<?> c = null;
    try {
      String className = getPersistName(serviceName);
      c = Class.forName(className);
    } catch (Exception e) {
      throw e;
    }
    IPersistServices instanceName = (IPersistServices) c.getConstructor().newInstance();
    return instanceName;
  }
  
  /**
   * 
   * @param serviceName
   * @return
   * @throws Exception 
   * Returns name of persist type to be used on getService() method
   */
  private String getPersistName(String serviceName) throws Exception {
    String retName = null;
    try {
      java.util.Properties props = new java.util.Properties();
      String propFile = this.persistPropertyFile;
      java.io.FileInputStream fis = new java.io.FileInputStream(propFile);
      
      props.load(fis);
      fis.close();
      String persistName = new String(props.getProperty(serviceName));
      retName = persistName;
    } catch(Exception e) {
      throw e;
    }
    return retName;
  }
  
  /**
   * 
   * @param file 
   * sets the name of the .txt file that holds commands on which service implementation to use.
   */
  public void setPersistProperties(String file) {
    this.persistPropertyFile = file;
  }
}
