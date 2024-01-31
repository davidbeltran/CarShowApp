/**
 *
 * @author David Beltran
 * File: CarShowUIController.java
 * This file contains the CarShowUIController class that handles the events 
 * when buttons on the CarShowUI GUI are triggered
 */
package edu.du.beltrandavid.controllor.carshowcontroller;

import edu.du.beltrandavid.model.business.manager.carshowmanager.CarShowManager;
import edu.du.beltrandavid.model.domain.CarShow;
import edu.du.beltrandavid.view.CarShowUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class CarShowUIController implements ActionListener {
  
  CarShowUI carShowUI = null;

  /**
   *
   */
  public CarShowUIController() {
  }
  
  /**
   *
   * @param carShowUI
   * Constructor that adds action listener to when button's are triggered on GUI
   */
  public CarShowUIController(CarShowUI carShowUI) {
    this.carShowUI = carShowUI;
    carShowUI.getFindCarShowButton().addActionListener(this);
    carShowUI.getAddCarShowButton().addActionListener(this);
    carShowUI.getRemoveCarShowButton().addActionListener(this);
    carShowUI.getExitCarShowMenuItem().addActionListener(this);
  }

  /**
   * 
   * @param event 
   * Determines which method to run depending on which object handling button is triggered
   */
  @Override
  public void actionPerformed(ActionEvent event) {
    try {
      if (event.getSource().equals(carShowUI.getFindCarShowButton())) {
        findCarShowButton_actionPerformed(event);
      } else {
        if (event.getSource().equals(carShowUI.getAddCarShowButton())) {
          addCarShowButton_actionPerformed(event);
        } else {
          if (event.getSource().equals(carShowUI.getRemoveCarShowButton())) {
            removeCarShowButton_actionPerformed(event);
          } else {
            if (event.getSource().equals(carShowUI.getExitCarShowMenuItem())) {
              exitCarShowMenuItem_actionPerformed(event);
            }
          }
        }
      }
    } catch (Exception e) {
      try {
        throw e;
      } catch (Exception ex) {
        Logger.getLogger(CarShowUIController.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
  }
  
  /**
   * 
   * @param event
   * @throws Exception 
   * Method that handles displaying object data when FIND button is triggered
   */
  private void findCarShowButton_actionPerformed(ActionEvent event) throws Exception {
    String carShowId = (String) carShowUI.getCarShowIdComboBox().getSelectedItem();
    
    CarShowManager carShowManager = carShowUI.getCarShowManager();
    CarShow carShow = carShowManager.find(carShowId);
    if (carShow != null) {
      carShowUI.putCarShowInfo(carShow);
    } else {
      JOptionPane.showMessageDialog(carShowUI.getContainer(), "Car Show was not found");
    }
  }
  
  /**
   * 
   * @param event
   * @throws Exception 
   * Method that handles adding object data to collection when ADD button is triggered
   */
  private void addCarShowButton_actionPerformed(ActionEvent event) throws Exception { 
    CarShow carShow = carShowUI.getCarShowInfo();
    CarShowManager carShowManager = carShowUI.getCarShowManager();
    if (carShowManager.isPresent(carShow)) {
      JOptionPane.showMessageDialog(carShowUI.getContainer(), carShow.getCarShowDate() + " " + 
          carShow.getCarShowTitle() + " already exists");
    } else {
      carShowManager.add(carShow);
      JOptionPane.showMessageDialog(carShowUI.getContainer(), "Car Show with ID " + 
          carShow.getCarShowId() + " added succesfully");
    }
  }
  
  /**
   * 
   * @param event
   * @throws Exception 
   * Method that handles removing object data from collection when REMOVE button is triggered
   */
  private void removeCarShowButton_actionPerformed(ActionEvent event) throws Exception {
    String carShowId = (String) carShowUI.getCarShowIdComboBox().getSelectedItem();
    CarShowManager carShowManager = carShowUI.getCarShowManager();
    if (!(carShowManager.isPresent(carShowId))) {
      JOptionPane.showMessageDialog(carShowUI.getContainer(), "Car show with ID " + 
          carShowId + " does not exist");
    } else {
      carShowManager.remove(carShowId);
      carShowUI.clearCarShowInfo();
      JOptionPane.showMessageDialog(carShowUI.getContainer(), "Car show with ID " +
          carShowId + " was removed from the car show collection");
    }
  }
  
  /**
   * 
   * @param event
   * @throws Exception 
   * Handles ExitMenuItem when exiting the UI window
   */
  private void exitCarShowMenuItem_actionPerformed(ActionEvent event) throws Exception {
    carShowUI.setVisible(false);
  }
}
