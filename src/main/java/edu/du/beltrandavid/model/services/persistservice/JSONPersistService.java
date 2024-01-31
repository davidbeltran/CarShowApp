/**
 *
 * @author David Beltran
 * File: JSONPersistService.java
 * This file contains the JSONPersistService class which is responsible for
 * persisting car show data to a json file.
 */
package edu.du.beltrandavid.model.services.persistservice;

import edu.du.beltrandavid.model.business.manager.carshowmanager.CarShowManager;
import edu.du.beltrandavid.model.business.manager.carshowownermanager.CarShowOwnerManager;
import edu.du.beltrandavid.model.business.manager.ownermanager.OwnerManager;
import edu.du.beltrandavid.model.business.manager.vehiclemanager.VehicleManager;
import edu.du.beltrandavid.model.domain.Address;
import edu.du.beltrandavid.model.domain.CarShow;
import edu.du.beltrandavid.model.domain.CarShowOwner;
import edu.du.beltrandavid.model.domain.Owner;
import edu.du.beltrandavid.model.domain.Vehicle;
import edu.du.beltrandavid.model.domain.VehicleClassification;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

public class JSONPersistService implements IPersistService {
  private static final String jsonFile = "carshow_data.json";

  /**
   *
   * @param ownerManager
   * @param vehicleManager
   * @param carShowManager
   * @param carShowOwnerManager
   * @throws Exception
   * adds json file data to application collection 
   */
  @Override
  public void loadPersistData(OwnerManager ownerManager, VehicleManager vehicleManager, 
      CarShowManager carShowManager, CarShowOwnerManager carShowOwnerManager) throws Exception {
    System.out.println ("JSONService loadPersistData");
    String jsonString = null;
    try {
      BufferedReader br = new BufferedReader(new FileReader(jsonFile));
      StringBuilder sb = new StringBuilder();
      String line = br.readLine();
      while (line != null) {
        sb.append(line);
        line = br.readLine();
      }
      jsonString = sb.toString();
    } catch(Exception e) {
        e.printStackTrace();
    }

        // load the owners
    JSONObject obj = new JSONObject(jsonString);
    JSONArray JSONownerArray = obj.getJSONArray("Owner");
    for (int idx = 0;idx < JSONownerArray.length();idx++) {
      Owner owner = new Owner();
      owner.setOwnerId(JSONownerArray.getJSONObject(idx).getString("ownerId"));
      owner.setLastName(JSONownerArray.getJSONObject(idx).getString("lastName"));
      owner.setFirstName(JSONownerArray.getJSONObject(idx).getString("firstName"));
      owner.setPhoneNumber(JSONownerArray.getJSONObject(idx).getString("phoneNumber"));
      owner.setNumYears(JSONownerArray.getJSONObject(idx).getInt("numYears"));
      Address address = new Address();
      JSONObject jsonAddress = JSONownerArray.getJSONObject(idx).getJSONObject("address");

      address.setStreet1(jsonAddress.getString("street1"));
      address.setStreet2(jsonAddress.getString("street2"));
      address.setCity(jsonAddress.getString("city"));
      address.setState(jsonAddress.getString("state"));
      address.setZipCode(jsonAddress.getString("zipCode"));
      owner.setAddress(address);
      System.out.println("JSON load = " + owner.toString());
      try {
        ownerManager.add(owner);
      } catch (Exception ex) {
        Logger.getLogger(JSONPersistService.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
    loadVehicle(jsonString, vehicleManager);
    loadCarShow(jsonString, carShowManager);
    loadCarShowOwner(jsonString, carShowOwnerManager);
  }

  /**
   *
   * @param ownerManager
   * @param vehilceManager
   * @param carShowManager
   * @param carShowOwnerManager
   * @throws Exception
   * persists application collections to json file
   */
  @Override
  public void putPersistData(OwnerManager ownerManager, VehicleManager vehilceManager, 
    CarShowManager carShowManager, CarShowOwnerManager carShowOwnerManager) throws Exception {
    System.out.println ("JSONService putPersistData");
    try {
      Iterator<Owner> itr = ownerManager.getOwners();
      ArrayList<Owner> ownerArrayList = new ArrayList<>();
      while (itr.hasNext()) {
        ownerArrayList.add((Owner) itr.next());
      }
      JSONObject JSONowner = null;
      JSONArray JSONownerArray = new JSONArray();

      for (Owner owner : ownerArrayList) {
        JSONowner = new JSONObject(owner);
        JSONownerArray.put(JSONowner);
      }
      JSONObject carShowReport = new JSONObject();
      carShowReport.put("CarShowOwner", putCarShowOwner(carShowOwnerManager));
      carShowReport.put("CarShow", putCarShow(carShowManager));
      carShowReport.put("Vehicle", putVehicle(vehilceManager));
      carShowReport.put("Owner",JSONownerArray);
      FileWriter file = new FileWriter(jsonFile) ;
      file.write(carShowReport.toString(2));
            // integer value to toString will allow for "pretty printing"
      System.out.println(carShowReport.toString(4));
      file.flush();
      file.close();
    } catch (Exception e1) {
      System.out.println ("error " + e1.getMessage());
    }
  }
  
  /**
   * 
   * @param jsonString
   * @param vehicleManager 
   * Takes vehicle object from JSON file and adds to collection
   */
  private void loadVehicle(String jsonString, VehicleManager vehicleManager) {
    JSONObject obj = new JSONObject(jsonString);
    JSONArray JSONVehicleArray = obj.getJSONArray("Vehicle");
    for (int idx = 0;idx < JSONVehicleArray.length();idx++) {
      Vehicle car = new Vehicle();
      car.setVehicleId(JSONVehicleArray.getJSONObject(idx).getString("vehicleId"));
      car.setOwnerId(JSONVehicleArray.getJSONObject(idx).getString("ownerId"));
      car.setManufacturer(JSONVehicleArray.getJSONObject(idx).getString("manufacturer"));
      car.setModelYear(JSONVehicleArray.getJSONObject(idx).getInt("modelYear"));
      car.setModel(JSONVehicleArray.getJSONObject(idx).getString("model"));
      car.setSubmodel(JSONVehicleArray.getJSONObject(idx).getString("submodel"));
      car.setVehicleClassification(VehicleClassification
          .valueOf(JSONVehicleArray.getJSONObject(idx).getString("vehicleClassification")));
      car.setIsInsured(JSONVehicleArray.getJSONObject(idx).getBoolean("isInsured"));
      System.out.println("JSON load = " + car.toString());
      try {
        vehicleManager.add(car);
      } catch (Exception ex) {
        Logger.getLogger(JSONPersistService.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
  }
  
  /**
   * 
   * @param jsonString
   * @param carShowManager 
   * Takes CarShow object from JSON file and adds to collection
   */
  private void loadCarShow(String jsonString, CarShowManager carShowManager) {
    JSONObject obj = new JSONObject(jsonString);
    JSONArray JSONCarShowArray = obj.getJSONArray("CarShow");
    for (int idx = 0;idx < JSONCarShowArray.length();idx++) {
      CarShow cs = new CarShow();
      cs.setCarShowId(JSONCarShowArray.getJSONObject(idx).getString("carShowId"));
      cs.setCarShowTitle(JSONCarShowArray.getJSONObject(idx).getString("carShowTitle"));
      cs.setIsSanctioned(JSONCarShowArray.getJSONObject(idx).getBoolean("isSanctioned"));
      DateTimeFormatter format = DateTimeFormatter.ofPattern("MM/d/yyyy");
      cs.setCarShowDate(LocalDate.parse(JSONCarShowArray
          .getJSONObject(idx).getString("carShowDate"), format));
      System.out.println("JSON load = " + cs.toString());
      try {
        carShowManager.add(cs);
      } catch (Exception ex) {
        Logger.getLogger(JSONPersistService.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
  }
  
  /**
   * 
   * @param jsonString
   * @param carShowOwnerManager 
   * Takes CarShowOwner object from JSON file and adds to collection
   */
  private void loadCarShowOwner(String jsonString, CarShowOwnerManager carShowOwnerManager) {
    JSONObject obj = new JSONObject(jsonString);
    JSONArray JSONCarShowOwnerArray = obj.getJSONArray("CarShowOwner");
    for (int idx = 0;idx < JSONCarShowOwnerArray.length();idx++) {
      CarShowOwner cso = new CarShowOwner();
      cso.setCarShowId(JSONCarShowOwnerArray.getJSONObject(idx).getString("carShowId"));
      cso.setOwnerId(JSONCarShowOwnerArray.getJSONObject(idx).getString("ownerId"));
      System.out.println("JSON load = " + cso.toString());
      try {
        carShowOwnerManager.add(cso);
      } catch (Exception ex) {
        Logger.getLogger(JSONPersistService.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
  }
  
  /**
   * 
   * @param vehicleManager
   * @return 
   * Persists Vehicle object to JSON file
   */
  private JSONArray putVehicle(VehicleManager vehicleManager) {
    JSONArray JSONVehicleArray = new JSONArray();
    try {
      Iterator<Vehicle> itr = vehicleManager.getVehicles();
      ArrayList<Vehicle> vehicleArrayList = new ArrayList<>();
      while (itr.hasNext()) {
        vehicleArrayList.add((Vehicle) itr.next());
      }
      JSONObject JSONVehicle = null;

      for (Vehicle car : vehicleArrayList) {
        JSONVehicle = new JSONObject(car);
        JSONVehicle.remove("insured");
        JSONVehicle.remove("vehicleClassification");
        JSONVehicle.put("vehicleClassification", car.getVehicleClassification().name());
        JSONVehicleArray.put(JSONVehicle);
      }
    } catch (Exception e1) {
      System.out.println ("error " + e1.getMessage());
    }
    return JSONVehicleArray;
  }
  
  /**
   * 
   * @param carShowManager
   * @return 
   * Persists CarShow object to JSON file
   */
  private JSONArray putCarShow(CarShowManager carShowManager) {
    JSONArray JSONCarShowArray = new JSONArray();
    try {
      Iterator<CarShow> itr = carShowManager.getCarShows();
      ArrayList<CarShow> carShowArrayList = new ArrayList<>();
      while (itr.hasNext()) {
        carShowArrayList.add((CarShow) itr.next());
      }
      JSONObject JSONCarShow = null;
      DateTimeFormatter format = DateTimeFormatter.ofPattern("MM/d/yyyy");

      for (CarShow cs : carShowArrayList) {
        JSONCarShow = new JSONObject(cs);
        JSONCarShow.remove("sanctioned");
        JSONCarShow.remove("carShowDate");
        JSONCarShow.put("carShowDate", format.format(cs.getCarShowDate()));
        JSONCarShowArray.put(JSONCarShow);
      }
    } catch (Exception e1) {
      System.out.println ("error " + e1.getMessage());
    }
    return JSONCarShowArray;
  }
  
  /**
   * 
   * @param carShowOwnerManager
   * @return 
   * Persists CarShowOwner object to JSON file
   */
  private JSONArray putCarShowOwner(CarShowOwnerManager carShowOwnerManager) {
    JSONArray JSONCarShowOwnerArray = new JSONArray();
    try {
      Iterator<CarShowOwner> itr = carShowOwnerManager.getCarShowOwners();
      ArrayList<CarShowOwner> carShowOwnerArrayList = new ArrayList<>();
      while (itr.hasNext()) {
        carShowOwnerArrayList.add((CarShowOwner) itr.next());
      }
      JSONObject JSONCarShowOwner = null;

      for (CarShowOwner cso : carShowOwnerArrayList) {
        JSONCarShowOwner = new JSONObject(cso);
        JSONCarShowOwnerArray.put(JSONCarShowOwner);
      }
    } catch (Exception e1) {
      System.out.println ("error " + e1.getMessage());
    }
    return JSONCarShowOwnerArray;
  }
  
  /**
   *
   * @return
   * returns json file name for purposes of unit testing
   */
  @Override
  public String getFile() {
    return this.jsonFile;
  }
}
