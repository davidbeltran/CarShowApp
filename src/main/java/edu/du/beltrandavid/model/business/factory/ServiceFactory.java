/**
 *
 * @author instructor, modified by David Beltran
 * File: ServiceFactory.java
 * This file contains the ServiceFactory class that helps the Manager classes
 * instantiate the correct collection type service implementation
 */
package edu.du.beltrandavid.model.business.factory;

import edu.du.beltrandavid.model.services.IServices;

/**
 * This will dynamically provide a service to caller
 */
public class ServiceFactory {

  /**
   *
   */
  public ServiceFactory() {
  }
    
  private static final ServiceFactory serviceFactory = new ServiceFactory();
  private String servicePropertyFile;
    
    /**
     * This is using the Java singleton pattern, where only one instance of the
     * ServiceFactory will exist
     * @return ServiceFactory
     */
    
  public static ServiceFactory getInstance() {
    return serviceFactory;
  }
    
    /**
     * This is where the service name will be dynamically loaded into a class
     * @param serviceName
     * @return
     * @throws Exception 
     */
    
  public IServices getService (String serviceName) throws Exception {
    Class<?> c = null;
    try {
      String className = getImplName(serviceName);
    	c = Class.forName(className);
		  
    }catch(Exception e1) {
      throw e1;
    }
    IServices instanceName =(IServices) c.getConstructor().newInstance();
    return instanceName;
  }
    
    
    /**
     * The service properties file is where the classes are associated with the
     * service names.  Use of the Java Properties API makes life a bit easier
     * here - provide the service name and the class is returned.
     * @param serviceName
     * @return
     * @throws Exception 
     */
  private String getImplName (String serviceName) throws Exception {
    //System.out.println("\t\t\t\tEntering ServiceFactory:getImplName - " + serviceName);
    String retName = null;
	  try {
      java.util.Properties props = new java.util.Properties();

      //String propFile = "serviceproperties.txt";
      String propFile = this.servicePropertyFile;
      java.io.FileInputStream fis = new java.io.FileInputStream(propFile);

      props.load(fis);
      fis.close();
      String implName = new String(props.getProperty(serviceName));
      retName = implName;
	  } catch (Exception e1) {
      System.out.println ("throw property exception" + e1.toString());
      throw new Exception ("Service properties file not found");
    }
    //System.out.println("\t\t\t\tLeaving ServiceFactory:getImplName - " + retName);
    return retName;
  }
  
  /**
   * 
   * @param file 
   * sets the name of the .txt file that holds commands on which service implementation to use.
   */
  public void setServiceProperties(String file) {
    this.servicePropertyFile = file;
  }
}
