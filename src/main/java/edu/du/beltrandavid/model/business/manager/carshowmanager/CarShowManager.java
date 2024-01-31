/**
 *
 * @author David Beltran
 * File: CarShowManager.java
 * This file contains the CarShowManager class that manages the service implementation returned
 * from the ServiceFactory object. All methods except setServiceProperties() handle service class
 * methods using the selected implementation.
 */
package edu.du.beltrandavid.model.business.manager.carshowmanager;

import edu.du.beltrandavid.model.business.manager.Manager;
import edu.du.beltrandavid.model.domain.CarShow;
import edu.du.beltrandavid.model.services.carshowservice.ICarShowService;
import java.util.Iterator;

public class CarShowManager extends Manager {
  
  /**
   *
   * @param carShow
   * @return
   * @throws Exception
   * Manages add() method after applying selected collection type
   */
  public boolean add (CarShow carShow) throws Exception {
    boolean retVal = false;
    try {
      ICarShowService carShowService = (ICarShowService) getService(ICarShowService.NAME);
      retVal = carShowService.add(carShow);
    } catch (Exception e) {
      throw e;
    }
    return retVal;
  }
  
  /**
   *
   * @param carShow
   * @return
   * @throws Exception
   * Manages remove() method after applying selected collection type
   */
  public boolean remove(CarShow carShow) throws Exception {
    boolean retVal = false;
    try {
      ICarShowService carShowService = (ICarShowService) getService(ICarShowService.NAME);
      retVal = carShowService.remove(carShow);
    } catch (Exception e) {
      throw e;
    }
    return retVal;
  }
  
  /**
   *
   * @param carShowId
   * @return
   * @throws Exception
   * Manages remove() method after applying selected collection type
   */
  public boolean remove(String carShowId) throws Exception {
    boolean retVal = false;
    try {
      ICarShowService carShowService = (ICarShowService) getService(ICarShowService.NAME);
      retVal = carShowService.remove(carShowId);
    } catch (Exception e) {
      throw e;
    }
    return retVal;
  }
  
  /**
   *
   * @param carShowId
   * @return
   * @throws Exception
   * Manages find() method after applying selected collection type
   */
  public CarShow find(String carShowId) throws Exception {
    CarShow cs = null;
    try {
      ICarShowService carShowService = (ICarShowService) getService(ICarShowService.NAME);
      cs = carShowService.find(carShowId);
    } catch (Exception e) {
      throw e;
    }
    return cs;
  }
  
  /**
   *
   * @param carShow
   * @return
   * @throws Exception
   * Manages isPresent() method after applying selected collection type
   */
  public boolean isPresent(CarShow carShow) throws Exception {
    boolean retVal = false;
    try {
      ICarShowService carShowService = (ICarShowService) getService(ICarShowService.NAME);
      retVal = carShowService.isPresent(carShow);
    } catch (Exception e) {
      throw e;
    }
    return retVal;
  }
  
  /**
   *
   * @param carShowId
   * @return
   * @throws Exception
   * Manages isPresent() method after applying selected collection type
   */
  public boolean isPresent(String carShowId) throws Exception {
    boolean retVal = false;
    try {
      ICarShowService carShowService = (ICarShowService) getService(ICarShowService.NAME);
      retVal = carShowService.isPresent(carShowId);
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
      ICarShowService carShowService = (ICarShowService) getService(ICarShowService.NAME);
      carShowService.dump();
    } catch (Exception e) {
      throw e;
    }
  }
  
  /**
   *
   * @return
   * @throws Exception
   * Manages getCarShows() method after applying selected collection type
   */
  public Iterator<CarShow> getCarShows() throws Exception {
    Iterator<CarShow> carShows = null;
    try {
      ICarShowService carShowService = (ICarShowService) getService(ICarShowService.NAME);
      carShows = carShowService.getCarShows();
    } catch (Exception e) {
      throw e;
    }
    return carShows;
  }
  
  /**
   *
   * @throws Exception
   * Manages emptyList() method after applying selected collection type
   */
  public void emptyList() throws Exception {
    try {
      ICarShowService carShowService = (ICarShowService) getService(ICarShowService.NAME);
      carShowService.emptyList();
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
