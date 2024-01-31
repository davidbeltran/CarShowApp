/**
 *
 * @author David Beltran
 * File: XMLPersistService.java
 * This file contains the XMLPersistService class which is responsible for
 * persisting car show data to a xml file.
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
import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLPersistService implements IPersistService {

  private final static String xmlFile = "carshow_data.xml";

  /**
   *
   * @param ownerManager
   * @param vehilceManager
   * @param carShowManager
   * @param carShowOwnerManager
   * @throws Exception
   * adds xml file data to application collection 
   */
  @Override
  public void loadPersistData(OwnerManager ownerManager, VehicleManager vehilceManager,
      CarShowManager carShowManager, CarShowOwnerManager carShowOwnerManager) throws Exception {
    System.out.println("XML loadPersistData");

    try {
      DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
      DocumentBuilder db = dbf.newDocumentBuilder();
      File file = new File(xmlFile);
      if (file.exists()) {
        Document doc = db.parse(file);
        Element rootElement = doc.getDocumentElement();
        NodeList ownerList = rootElement.getElementsByTagName("Owner");

        for (int idx = 0;idx < ownerList.getLength();idx++) {
          Owner owner = new Owner();
          Node node = ownerList.item(idx);
          if (node.getNodeType() == Node.ELEMENT_NODE){
            Element ownerElement = (Element)node;
            NodeList nodeList = ownerElement.getElementsByTagName("ownerId");
            owner.setOwnerId(nodeList.item(0).getChildNodes().item(0).getNodeValue());
            nodeList = ownerElement.getElementsByTagName("lastName");
            owner.setLastName(nodeList.item(0).getChildNodes().item(0).getNodeValue());
            nodeList = ownerElement.getElementsByTagName("firstName");
            owner.setFirstName(nodeList.item(0).getChildNodes().item(0).getNodeValue());
            nodeList = ownerElement.getElementsByTagName("phoneNumber");
            owner.setPhoneNumber(nodeList.item(0).getChildNodes().item(0).getNodeValue());
            nodeList = ownerElement.getElementsByTagName("numYears");
            owner.setNumYears(Integer.parseInt(nodeList
                .item(0).getChildNodes().item(0).getNodeValue()));
            NodeList addressList = ownerElement.getElementsByTagName("Address");
            Address address = new Address();
            node = addressList.item(0);

            if (node.getNodeType() == Node.ELEMENT_NODE){
              Element addressElement = (Element)node;
              nodeList = addressElement.getElementsByTagName("street1");
              address.setStreet1(nodeList.item(0).getChildNodes().item(0).getNodeValue());
              nodeList = addressElement.getElementsByTagName("city");
              address.setCity(nodeList.item(0).getChildNodes().item(0).getNodeValue());
              nodeList = addressElement.getElementsByTagName("state");
              address.setState(nodeList.item(0).getChildNodes().item(0).getNodeValue());
              nodeList = addressElement.getElementsByTagName("zipCode");
              address.setZipCode(nodeList.item(0).getChildNodes().item(0).getNodeValue());
            }

            owner.setAddress(address);
            ownerManager.add(owner);
          }
        }
        loadVehicle(vehilceManager, rootElement);
        loadCarShow(carShowManager, rootElement);
        loadCarShowOwner(carShowOwnerManager, rootElement);
      }
    } catch (Exception e1) {
            e1.printStackTrace();
           System.out.println("exception " + e1.getMessage());
    }
  }
  
  /**
   * 
   * @param vehicleManager
   * @param rootElement
   * @throws Exception 
   * Takes vehicle object from XML file and adds to collection
   */
  private void loadVehicle(VehicleManager vehicleManager, Element rootElement) throws Exception {
    NodeList vehicleList = rootElement.getElementsByTagName("Vehicle");

    for (int idx = 0;idx < vehicleList.getLength();idx++) {
      Vehicle car = new Vehicle();
      Node node = vehicleList.item(idx);
      if (node.getNodeType() == Node.ELEMENT_NODE){
        Element vehicleElement = (Element)node;
        NodeList nodeList = vehicleElement.getElementsByTagName("vehicleId");
        car.setVehicleId(nodeList.item(0).getChildNodes().item(0).getNodeValue());
        nodeList = vehicleElement.getElementsByTagName("ownerId");
        car.setOwnerId(nodeList.item(0).getChildNodes().item(0).getNodeValue());
        nodeList = vehicleElement.getElementsByTagName("manufacturer");
        car.setManufacturer(nodeList.item(0).getChildNodes().item(0).getNodeValue());
        nodeList = vehicleElement.getElementsByTagName("modelYear");
        car.setModelYear(Integer.parseInt(nodeList
            .item(0).getChildNodes().item(0).getNodeValue()));
        nodeList = vehicleElement.getElementsByTagName("model");
        car.setModel(nodeList.item(0).getChildNodes().item(0).getNodeValue());
        nodeList = vehicleElement.getElementsByTagName("submodel");
        if (nodeList.item(0).getChildNodes().item(0) == null) {
          car.setSubmodel("");
        } else {
          car.setSubmodel(nodeList.item(0).getChildNodes().item(0).getNodeValue());
        }
        nodeList = vehicleElement.getElementsByTagName("vehicleClassification");
        car.setVehicleClassification(VehicleClassification.valueOf(nodeList.item(0)
            .getChildNodes().item(0).getNodeValue()));
        nodeList = vehicleElement.getElementsByTagName("isInsured");
        car.setIsInsured(nodeList.item(0).getChildNodes().item(0).getNodeValue());
        vehicleManager.add(car);
      }
    }
  }
  
  /**
   * 
   * @param carShowManager
   * @param rootElement
   * @throws Exception 
   * Takes CarShow object from XML file and adds to collection
   */
  private void loadCarShow(CarShowManager carShowManager, Element rootElement) throws Exception {
    NodeList carShowList = rootElement.getElementsByTagName("CarShow");

    for (int idx = 0;idx < carShowList.getLength();idx++) {
      CarShow cs = new CarShow();
      Node node = carShowList.item(idx);
      if (node.getNodeType() == Node.ELEMENT_NODE){
        Element carShowElement = (Element)node;
        NodeList nodeList = carShowElement.getElementsByTagName("carShowId");
        cs.setCarShowId(nodeList.item(0).getChildNodes().item(0).getNodeValue());
        nodeList = carShowElement.getElementsByTagName("carShowTitle");
        cs.setCarShowTitle(nodeList.item(0).getChildNodes().item(0).getNodeValue());
        nodeList = carShowElement.getElementsByTagName("carShowDate");
        String date = nodeList.item(0).getChildNodes().item(0).getNodeValue();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MM/d/yyyy");
        cs.setCarShowDate(LocalDate.parse(date, format));
        /*
        cs.setCarShowDate(LocalDate.parse(nodeList.item(0)
            .getChildNodes().item(0).getNodeValue()));
        */
        nodeList = carShowElement.getElementsByTagName("isSanctioned");
        cs.setIsSanctioned(nodeList.item(0).getChildNodes().item(0).getNodeValue());
        carShowManager.add(cs);
      }
    }
  }

  /**
   * 
   * @param carShowOwnerManager
   * @param rootElement
   * @throws Exception 
   * Takes CarShowOwner object from XML file and adds to collection
   */
  private void loadCarShowOwner(CarShowOwnerManager carShowOwnerManager, Element rootElement)
      throws Exception {
    NodeList carShowOwnerList = rootElement.getElementsByTagName("CarShowOwner");

    for (int idx = 0;idx < carShowOwnerList.getLength();idx++) {
      CarShowOwner cso = new CarShowOwner();
      Node node = carShowOwnerList.item(idx);
      if (node.getNodeType() == Node.ELEMENT_NODE){
        Element carShowOwnerElement = (Element)node;
        NodeList nodeList = carShowOwnerElement.getElementsByTagName("carShowId");
        cso.setCarShowId(nodeList.item(0).getChildNodes().item(0).getNodeValue());
        nodeList = carShowOwnerElement.getElementsByTagName("ownerId");
        cso.setOwnerId(nodeList.item(0).getChildNodes().item(0).getNodeValue());
        carShowOwnerManager.add(cso);
      }
    }
  }
  
  /**
   *
   * @param ownerManager
   * @param vehilceManager
   * @param carShowManager
   * @param carShowOwnerManager
   * @throws Exception
   * persists application collections to xml file
   */
  @Override
  public void putPersistData(OwnerManager ownerManager, VehicleManager vehilceManager, 
      CarShowManager carShowManager, CarShowOwnerManager carShowOwnerManager) throws Exception {
    System.out.println ("XMLService putPersistData");
    try {
      DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
      DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
      Document document = documentBuilder.newDocument();

      Element rootElement = document.createElement("CarShowData");
      document.appendChild(rootElement);
      
      Element collectionElement = document.createElement("Owners");
      rootElement.appendChild(collectionElement);

      Iterator<Owner> itr = ownerManager.getOwners();
      ArrayList<Owner> ownerArrayList = new ArrayList<>();
      while (itr.hasNext()) {
        ownerArrayList.add((Owner) itr.next());
      }

      for (Owner owner : ownerArrayList) {
        Element ownerElement = document.createElement("Owner");
        collectionElement.appendChild(ownerElement);

        Element ownerID = document.createElement("ownerId");
        ownerID.appendChild(document.createTextNode(owner.getOwnerId()));
        ownerElement.appendChild(ownerID);

        Element lastName = document.createElement("lastName");
        lastName.appendChild(document.createTextNode(owner.getLastName()));
        ownerElement.appendChild(lastName);

        Element firstName = document.createElement("firstName");
        firstName.appendChild(document.createTextNode(owner.getFirstName()));
        ownerElement.appendChild(firstName);

        Element phoneNumber = document.createElement("phoneNumber");
        phoneNumber.appendChild(document.createTextNode(owner.getPhoneNumber()));
        ownerElement.appendChild(phoneNumber);

        Element numYears = document.createElement("numYears");
        String numYearsString = Integer.toString(owner.getNumYears());
        numYears.appendChild(document.createTextNode(numYearsString));
        ownerElement.appendChild(numYears);

        Element addressElement = document.createElement("Address");
        ownerElement.appendChild(addressElement);

        Address address = owner.getAddress();

        Element street1 = document.createElement("street1");
        street1.appendChild(document.createTextNode(address.getStreet1()));
        addressElement.appendChild(street1);

        Element street2 = document.createElement("street2");
        street2.appendChild(document.createTextNode(address.getStreet2()));
        addressElement.appendChild(street2);

        Element city = document.createElement("city");
        city.appendChild(document.createTextNode(address.getCity()));
        addressElement.appendChild(city);

        Element state = document.createElement("state");
        state.appendChild(document.createTextNode(address.getState()));
        addressElement.appendChild(state);

        Element zipCode = document.createElement("zipCode");
        zipCode.appendChild(document.createTextNode(address.getZipCode()));
        addressElement.appendChild(zipCode);
      }
      putVehicle(vehilceManager, document, rootElement);
      putCarShow(carShowManager, document, rootElement);
      putCarShowOwner(carShowOwnerManager, document, rootElement);

      TransformerFactory transformerFactory = TransformerFactory.newInstance();
      Transformer transformer = transformerFactory.newTransformer();
      transformer.setOutputProperty(OutputKeys.INDENT, "yes");
      DOMSource source = new DOMSource(document);
      StreamResult result = new StreamResult(new File(xmlFile));
      transformer.transform(source, result);


            // Output to console for testing
      StreamResult consoleResult = new StreamResult(System.out);
      transformer.transform(source, consoleResult);

    } catch (IllegalArgumentException | ParserConfigurationException | 
        TransformerException | DOMException e) {
      System.out.println (e.getMessage());
    }
  }
  
  /**
   * 
   * @param vehicleManager
   * @param document
   * @param rootElement
   * @throws Exception 
   * Persists Vehicle object to XML file
   */
  private void putVehicle(VehicleManager vehicleManager, Document document, 
      Element rootElement) throws Exception {
    Element collectionElement = document.createElement("Vehicles");
    rootElement.appendChild(collectionElement);
    Iterator<Vehicle> itr = vehicleManager.getVehicles();
    ArrayList<Vehicle> vehicleArrayList = new ArrayList<>();
    while (itr.hasNext()) {
      vehicleArrayList.add((Vehicle) itr.next());
    }

    for (Vehicle car : vehicleArrayList) {
      Element vehicleElement = document.createElement("Vehicle");
      collectionElement.appendChild(vehicleElement);

      Element vehicleId = document.createElement("vehicleId");
      vehicleId.appendChild(document.createTextNode(car.getVehicleId()));
      vehicleElement.appendChild(vehicleId);

      Element ownerId = document.createElement("ownerId");
      ownerId.appendChild(document.createTextNode(car.getOwnerId()));
      vehicleElement.appendChild(ownerId);

      Element manufacturer = document.createElement("manufacturer");
      manufacturer.appendChild(document.createTextNode(car.getManufacturer()));
      vehicleElement.appendChild(manufacturer);

      Element modelYear = document.createElement("modelYear");
      modelYear.appendChild(document.createTextNode(String.valueOf(car.getModelYear())));
      vehicleElement.appendChild(modelYear);

      Element model = document.createElement("model");
      model.appendChild(document.createTextNode(car.getModel()));
      vehicleElement.appendChild(model);

      Element submodel = document.createElement("submodel");
      String carSubmodel = car.getSubmodel();
      if (carSubmodel == null) {
        carSubmodel = "";
      }
      submodel.appendChild(document.createTextNode(carSubmodel));
      vehicleElement.appendChild(submodel);

      Element vehicleClassification = document.createElement("vehicleClassification");
      vehicleClassification.appendChild(document
          .createTextNode(car.getVehicleClassification().name()));
      vehicleElement.appendChild(vehicleClassification);

      Element isInsured = document.createElement("isInsured");
      isInsured.appendChild(document.createTextNode(String.valueOf(car.getIsInsured())));
      vehicleElement.appendChild(isInsured);
    }
  }
  
  /**
   * 
   * @param carShowManager
   * @param document
   * @param rootElement
   * @throws Exception 
   * Persists CarShow object to XML file
   */
  private void putCarShow(CarShowManager carShowManager, Document document, Element rootElement)
      throws Exception {
    Element collectionElement = document.createElement("CarShows");
    rootElement.appendChild(collectionElement);
    Iterator<CarShow> itr = carShowManager.getCarShows();
    ArrayList<CarShow> carShowArrayList = new ArrayList<>();
    DateTimeFormatter format = DateTimeFormatter.ofPattern("MM/d/yyyy");
    
    while (itr.hasNext()) {
      carShowArrayList.add((CarShow) itr.next());
    }

    for (CarShow cs : carShowArrayList) {
      Element carShowElement = document.createElement("CarShow");
      collectionElement.appendChild(carShowElement);

      Element carShowId = document.createElement("carShowId");
      carShowId.appendChild(document.createTextNode(cs.getCarShowId()));
      carShowElement.appendChild(carShowId);

      Element carShowTitle = document.createElement("carShowTitle");
      carShowTitle.appendChild(document.createTextNode(cs.getCarShowTitle()));
      carShowElement.appendChild(carShowTitle);

      Element carShowDate = document.createElement("carShowDate");
      carShowDate.appendChild(document.createTextNode(format.format(cs.getCarShowDate())));
      carShowElement.appendChild(carShowDate);

      Element isSanctioned = document.createElement("isSanctioned");
      isSanctioned.appendChild(document.createTextNode(String.valueOf(cs.getIsSanctioned())));
      carShowElement.appendChild(isSanctioned);
    }
  }
  
  /**
   * 
   * @param carShowOwnerManager
   * @param document
   * @param rootElement
   * @throws Exception 
   * Persists CarShowOwner object to XML file
   */
  private void putCarShowOwner(CarShowOwnerManager carShowOwnerManager, Document document, 
      Element rootElement) throws Exception {
    Element collectionElement = document.createElement("CarShowOwners");
    rootElement.appendChild(collectionElement);
    Iterator<CarShowOwner> itr = carShowOwnerManager.getCarShowOwners();
    ArrayList<CarShowOwner> carShowOwnerArrayList = new ArrayList<>();
    while (itr.hasNext()) {
      carShowOwnerArrayList.add((CarShowOwner) itr.next());
    }

    for (CarShowOwner cso : carShowOwnerArrayList) {
      Element carShowOwnerElement = document.createElement("CarShowOwner");
      collectionElement.appendChild(carShowOwnerElement);

      Element carShowId = document.createElement("carShowId");
      carShowId.appendChild(document.createTextNode(cso.getCarShowId()));
      carShowOwnerElement.appendChild(carShowId);

      Element ownerId = document.createElement("ownerId");
      ownerId.appendChild(document.createTextNode(cso.getOwnerId()));
      carShowOwnerElement.appendChild(ownerId);
    }
  }
  
  /**
   *
   * @return
   * returns xml file name for purposes of unit testing
   */
  @Override
  public String getFile() {
    return this.xmlFile;
  }
}
