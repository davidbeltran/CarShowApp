/**
 *
 * @author David Beltran
 * File: VehicleUIController.java
 * This file contains the VehicleUIController class which is responsible for
 * handling data that is displayed on the VehicleUI class
 */
package edu.du.beltrandavid.controllor.vehiclecontroller;

import edu.du.beltrandavid.model.business.manager.vehiclemanager.VehicleManager;
import edu.du.beltrandavid.model.domain.Vehicle;
import edu.du.beltrandavid.view.VehicleUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class VehicleUIController implements ActionListener {
  
  VehicleUI vehicleUI = null;

  /**
   *
   */
  public VehicleUIController() {
  }

  /**
   *
   * @param vehicleUI
   * Constructor that adds action listener to when button's are triggered on GUI
   */
  public VehicleUIController(VehicleUI vehicleUI) {
    this.vehicleUI = vehicleUI;
    
    vehicleUI.getFindVehicleButton().addActionListener(this);
    vehicleUI.getAddVehicleButton().addActionListener(this);
    vehicleUI.getRemoveVehicleButton().addActionListener(this);
    vehicleUI.getExitVehicleMenuItem().addActionListener(this);
  }
  
  /**
   * 
   * @param event 
   * Determines which method to run depending on which object handling button is triggered
   */
  @Override
  public void actionPerformed(ActionEvent event) {
    try {
      if (event.getSource().equals(vehicleUI.getFindVehicleButton())) {
        findVehicleButton_actionPerformed(event);
      } else {
        if (event.getSource().equals(vehicleUI.getAddVehicleButton())) {
          addVehicleButton_actionPerformed(event);
        } else {
          if (event.getSource().equals(vehicleUI.getRemoveVehicleButton())) {
            removeVehicleButton_actionPerformed(event);
          } else {
            if (event.getSource().equals(vehicleUI.getExitVehicleMenuItem())) {
              exitVehicleMenuItem_actionPerformed(event);
            }
          }
        }
      }
    } catch (Exception e) {
      try { 
        throw e;
      } catch (Exception ex) {
        Logger.getLogger(VehicleUIController.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
  }
  
  /**
   * 
   * @param event
   * @throws Exception 
   * Method that handles displaying object data when FIND button is triggered
   */
  private void findVehicleButton_actionPerformed(ActionEvent event) throws Exception {
    String vehicleId = (String) vehicleUI.getVehicleIdComboBox().getSelectedItem();
    
    VehicleManager vehicleManager = vehicleUI.getVehicleManager();
    Vehicle vehicle = vehicleManager.find(vehicleId);
    if (vehicle != null) {
      vehicleUI.putVehicleInfo(vehicle);
    } else {
      JOptionPane.showMessageDialog(vehicleUI.getContainer(), "Vehicle was not found");
    }
  }
  
  /**
   * 
   * @param event
   * @throws Exception 
   * Method that handles adding object data to collection when ADD button is triggered
   */
  private void addVehicleButton_actionPerformed(ActionEvent event) throws Exception {
    Vehicle vehicle = vehicleUI.getVehicleInfo();
    VehicleManager vehicleManager = vehicleUI.getVehicleManager();
    if (vehicleManager.isPresent(vehicle)) {
      JOptionPane.showMessageDialog(vehicleUI.getContainer(), vehicle.getModelYear() + " " + 
          vehicle.getManufacturer() + " " + vehicle.getModel() + " " + vehicle.getSubmodel() + 
          " with owner ID " + vehicle.getOwnerId() + " already exists");
    } else {
      vehicle.adjustVehicleClassification(vehicle.validateVehicleClassification());
      vehicleManager.add(vehicle);
      JOptionPane.showMessageDialog(vehicleUI.getContainer(), "Vehicle with ID " + 
          vehicle.getVehicleId() + " added succesfully");
    }
  }
  
  /**
   * 
   * @param event
   * @throws Exception 
   * Method that handles removing object data from collection when REMOVE button is triggered
   */
  private void removeVehicleButton_actionPerformed(ActionEvent event) throws Exception {
    String vehicleId = (String) vehicleUI.getVehicleIdComboBox().getSelectedItem();
    VehicleManager vehicleManager = vehicleUI.getVehicleManager();
    if (!(vehicleManager.isPresent(vehicleId))) {
      JOptionPane.showMessageDialog(vehicleUI.getContainer(), "Vehicle with ID " + vehicleId +
          " does not exist");
    } else {
      vehicleManager.remove(vehicleId);
      vehicleUI.clearVehicleInfo();
      JOptionPane.showMessageDialog(vehicleUI.getContainer(), "Vehicle with ID " + vehicleId +
          " was removed from the vehicle collection"); 
    }
  }
  
  /**
   * 
   * @param event
   * @throws Exception 
   * Handles ExitMenuItem when exiting the UI window
   */
  private void exitVehicleMenuItem_actionPerformed(ActionEvent event) throws Exception {
    vehicleUI.setVisible(false);
  }
}
