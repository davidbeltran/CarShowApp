/**
 *
 * @author David Beltran
 * File: OwnerUIController.java
 * This file contains the OwnerUIController class which is responsible for
 * handling data that is displayed on the OwnerUI class
 */
package edu.du.beltrandavid.controllor.ownercontroller;

import edu.du.beltrandavid.model.business.manager.carshowownermanager.CarShowOwnerManager;
import edu.du.beltrandavid.model.business.manager.ownermanager.OwnerManager;
import edu.du.beltrandavid.model.business.manager.vehiclemanager.VehicleManager;
import edu.du.beltrandavid.model.domain.CarShowOwner;
import edu.du.beltrandavid.model.domain.Owner;
import edu.du.beltrandavid.model.domain.Vehicle;
import edu.du.beltrandavid.view.OwnerUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class OwnerUIController  implements ActionListener {
  
  OwnerUI ownerUI = null;

  /**
   *
   */
  public OwnerUIController() {
  }

  /**
   *
   * @param ownerUI
   * Constructor that adds action listener to when button's are triggered on GUI
   */
  public OwnerUIController(OwnerUI ownerUI) {
    this.ownerUI = ownerUI;
    
    ownerUI.getFindOwnerButton().addActionListener(this);
    ownerUI.getAddOwnerButton().addActionListener(this);
    ownerUI.getRemoveOwnerButton().addActionListener(this);
    ownerUI.getExitOwnerMenuItem().addActionListener(this);
  }
  
  /**
   * 
   * @param event 
   * Determines which method to run depending on which object handling button is triggered
   */
  @Override
  public void actionPerformed(ActionEvent event) {
    try {
      if (event.getSource().equals(ownerUI.getFindOwnerButton())) {
        findOwnerButton_actionPerformed(event);
      } else {
        if (event.getSource().equals(ownerUI.getAddOwnerButton())) {
          addOwnerButton_actionPerformed(event);
        } else {
          if (event.getSource().equals(ownerUI.getRemoveOwnerButton())) {
            removeOwnerButton_actionPerformed(event);
          } else {
            if (event.getSource().equals(ownerUI.getExitOwnerMenuItem())) {
              exitOwnerMenuItem_actionPerformed(event);
            }
          }
        }
      }
    } catch (Exception e) {
      try {
        throw e;
      } catch (Exception ex) {
        Logger.getLogger(OwnerUIController.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
  }
  
  /**
   * 
   * @param event
   * @throws Exception 
   * Method that handles displaying object data when FIND button is triggered
   */
  private void findOwnerButton_actionPerformed(ActionEvent event) throws Exception {
    String ownerId = (String) ownerUI.getOwnerIdComboBox().getSelectedItem();
    
    OwnerManager ownerManager = ownerUI.getOwnerManager();
    Owner owner = ownerManager.find(ownerId);
    if (owner != null) {
      ownerUI.putOwnerInfo(owner);
    } else {
      JOptionPane.showMessageDialog(ownerUI.getContainer(), "Owner was not found");
    }
  }
  
  /**
   * 
   * @param event
   * @throws Exception 
   * Method that handles adding object data to collection when ADD button is triggered
   */
  private void addOwnerButton_actionPerformed(ActionEvent event) throws Exception {
    Owner owner = ownerUI.getOwnerInfo();
    OwnerManager ownerManager = ownerUI.getOwnerManager();
    if (ownerManager.isPresent(owner)) {
      JOptionPane.showMessageDialog(ownerUI.getContainer(), 
          owner.getFirstName() + " " + owner.getLastName() + " already exists");
    } else {
      ownerManager.add(owner);
      JOptionPane.showMessageDialog(ownerUI.getContainer(), "Owner with ID " + 
          owner.getOwnerId() + " added succesfully");
    }
  }
  
  /**
   * 
   * @param event
   * @throws Exception 
   * Method that handles removing object data from collection when REMOVE button is triggered
   */
  private void removeOwnerButton_actionPerformed(ActionEvent event) throws Exception {
    String ownerId = (String) ownerUI.getOwnerIdComboBox().getSelectedItem();
    OwnerManager ownerManager = ownerUI.getOwnerManager();
    if (!(ownerManager.isPresent(ownerId))) {
      JOptionPane.showMessageDialog(ownerUI.getContainer(), "Owner with ID " + ownerId + 
          " does not exist");
    } else {
      VehicleManager vehicleManager = ownerUI.getVehicleManager();
      CarShowOwnerManager carShowOwnerManager = ownerUI.getCarShowOwnerManager();
      Iterator<Vehicle> vitr = vehicleManager.getVehicles();
      Iterator<CarShowOwner> csoitr = carShowOwnerManager.getCarShowOwners();
      while (vitr.hasNext()) {
        Vehicle car = vitr.next();
        if (car.getOwnerId().equals(ownerId)) {
          vitr.remove();
        }
      }
      while (csoitr.hasNext()) {
        CarShowOwner cso = csoitr.next();
        if (cso.getOwnerId().equals(ownerId)) {
          csoitr.remove();
        }
      }
      ownerManager.remove(ownerId);
      ownerUI.clearOwnerInfo();
      JOptionPane.showMessageDialog(ownerUI.getContainer(), "Owner with ID " + ownerId + 
          " was removed from the owner collection");
    }
  }
  
  /**
   * 
   * @param event
   * @throws Exception 
   * Handles ExitMenuItem when exiting the UI window
   */
  private void exitOwnerMenuItem_actionPerformed(ActionEvent event) throws Exception {
    ownerUI.setVisible(false);
  }
}
