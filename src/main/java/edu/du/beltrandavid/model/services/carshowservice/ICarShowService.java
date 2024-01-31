/**
 *
 * @author David Beltran
 * File: ICarShowService.java
 * This file contains the ICarShowService interface which is responsible for
 * creating and managing the collection that stores CarShow objects.
 */
package edu.du.beltrandavid.model.services.carshowservice;

import edu.du.beltrandavid.model.domain.CarShow;
import edu.du.beltrandavid.model.services.IServices;
import java.util.Iterator;

public interface ICarShowService extends IServices {
  public final String NAME = "ICarShowService";
  
  public boolean add(CarShow carShow);
  public boolean remove(CarShow carShow);
  public boolean remove(String carShowId);
  public CarShow find(String carShowId);
  public boolean isPresent(CarShow carShow);
  public boolean isPresent(String carShowId);
  public void dump();
  public Iterator<CarShow> getCarShows();
  public void emptyList();
  public String getName();
}
