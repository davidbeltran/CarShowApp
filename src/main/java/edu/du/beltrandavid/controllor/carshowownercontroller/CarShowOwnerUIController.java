/**
 *
 * @author David Beltran
 * File: CarShowOwnerUIController.java
 * This file contains the CarShowOwnerUIController class which is responsible for
 * handling data that is displayed on the CarShowOwnerUI class
 */
package edu.du.beltrandavid.controllor.carshowownercontroller;

import edu.du.beltrandavid.model.business.manager.carshowownermanager.CarShowOwnerManager;
import edu.du.beltrandavid.model.domain.CarShowOwner;
import edu.du.beltrandavid.view.CarShowOwnerUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class CarShowOwnerUIController implements ActionListener {
  
  CarShowOwnerUI carShowOwnerUI = null;

  /**
   *
   */
  public CarShowOwnerUIController() {
  }

  /**
   *
   * @param carShowOwnerUI
   * Constructor that adds action listener to when button's are triggered on GUI
   */
  public CarShowOwnerUIController(CarShowOwnerUI carShowOwnerUI) {
    this.carShowOwnerUI = carShowOwnerUI;
    carShowOwnerUI.getFindCarShowOwnerButton().addActionListener(this);
    carShowOwnerUI.getAddCarShowOwnerButton().addActionListener(this);
    carShowOwnerUI.getRemoveCarShowOwnerButton().addActionListener(this);
    carShowOwnerUI.getExitCarShowOwnerMenuItem().addActionListener(this);
  }
  
  /**
   * 
   * @param event 
   * Determines which method to run depending on which object handling button is triggered
   */
  @Override
  public void actionPerformed(ActionEvent event) {
    try {
      if (event.getSource().equals(carShowOwnerUI.getFindCarShowOwnerButton())) {
        findCarShowOwnerButton_actionPerformed(event);
      } else {
        if (event.getSource().equals(carShowOwnerUI.getAddCarShowOwnerButton())) {
          addCarShowOwnerButton_actionPerformed(event);
        } else {
          if (event.getSource().equals(carShowOwnerUI.getRemoveCarShowOwnerButton())) {
            removeCarShowOwnerButton_actionPerformed(event);
          } else {
            if (event.getSource().equals(carShowOwnerUI.getExitCarShowOwnerMenuItem())) {
              exitCarShowOwnerMenuItem_actionPerformed(event);
            }
          }
        }
      }
    } catch (Exception e) {
      try {
        throw e;
      } catch (Exception ex) {
        Logger.getLogger(CarShowOwnerUIController.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
  }
  
  /**
   * 
   * @param event
   * @throws Exception 
   * Method that handles displaying object data when FIND button is triggered
   */
  private void findCarShowOwnerButton_actionPerformed(ActionEvent event) throws Exception {
    String carShowId = (String) carShowOwnerUI.getCarShowIdComboBox().getSelectedItem();
    String ownerId = (String) carShowOwnerUI.getOwnerIdComboBox().getSelectedItem();
    
    CarShowOwnerManager carShowOwnerManager = carShowOwnerUI.getCarShowOwnerManager();
    CarShowOwner carShowOwner = carShowOwnerManager.find(carShowId, ownerId);
    if (carShowOwner != null) {
      carShowOwnerUI.putCarShowOwnerInfo(carShowOwner);
      JOptionPane.showMessageDialog(carShowOwnerUI.getContainer(), "Owner with ID " + 
          carShowOwner.getOwnerId() + " is the owner of car show with ID " + 
          carShowOwner.getCarShowId());
    } else {
      JOptionPane.showMessageDialog(carShowOwnerUI.getContainer(), 
          "Car show ownership was not found");
    }
  }
  
  /**
   * 
   * @param event
   * @throws Exception 
   * Method that handles adding object data to collection when ADD button is triggered
   */
  private void addCarShowOwnerButton_actionPerformed(ActionEvent event) throws Exception {
    CarShowOwner carShowOwner = carShowOwnerUI.getCarShowOwnerInfo();
    CarShowOwnerManager carShowOwnerManager = carShowOwnerUI.getCarShowOwnerManager();
    if (carShowOwnerManager.isPresent(carShowOwner)) {
      JOptionPane.showMessageDialog(carShowOwnerUI.getContainer(), 
          "Owner with ID " + carShowOwner.getOwnerId() + 
              " already exists owning car show with ID " + carShowOwner.getCarShowId());
    } else {
      carShowOwnerManager.add(carShowOwner);
      JOptionPane.showMessageDialog(carShowOwnerUI.getContainer(), 
          "Car show owner with owner ID " + carShowOwner.getOwnerId() + " and car show ID " +
          carShowOwner.getCarShowId() + " added succesfully");
    }
  }
  
  /**
   * 
   * @param event
   * @throws Exception 
   * Method that handles removing object data from collection when REMOVE button is triggered
   */
  private void removeCarShowOwnerButton_actionPerformed(ActionEvent event) throws Exception {
    String ownerId = (String) carShowOwnerUI.getOwnerIdComboBox().getSelectedItem();
    String carShowId = (String) carShowOwnerUI.getCarShowIdComboBox().getSelectedItem();
    CarShowOwnerManager carShowOwnerManager = carShowOwnerUI.getCarShowOwnerManager();
    CarShowOwner cso = carShowOwnerManager.find(carShowId, ownerId);
    if (!(carShowOwnerManager.isPresent(cso))) {
      JOptionPane.showMessageDialog(carShowOwnerUI.getContainer(), "Car show owner with owner ID "
      + ownerId + " does not exist owning car show with ID " + carShowId);
    } else {
      carShowOwnerManager.remove(cso);
      JOptionPane.showMessageDialog(carShowOwnerUI.getContainer(), 
          "Car show owner with owner ID " + ownerId + " and car show ID " + carShowId +
              " was removed from the car show owner collection");
    }
  }
  
  /**
   * 
   * @param event
   * @throws Exception
   * Handles ExitMenuItem when exiting the UI window 
   */
  private void exitCarShowOwnerMenuItem_actionPerformed(ActionEvent event) throws Exception {
    carShowOwnerUI.setVisible(false);
  }
}
