/**
 *
 * @author David Beltran
 * File: CarShowMainMenuController.java
 * This file contains the CarShowMainMenuController class which is responsible for
 * handling data that is displayed on the CarShowMainMenu class
 */
package edu.du.beltrandavid.controllor;

import edu.du.beltrandavid.model.business.manager.persistmanager.PersistManager;
import edu.du.beltrandavid.view.CarShowMainMenu;
import edu.du.beltrandavid.view.CarShowOwnerUI;
import edu.du.beltrandavid.view.CarShowUI;
import edu.du.beltrandavid.view.OwnerUI;
import edu.du.beltrandavid.view.PrintUI;
import edu.du.beltrandavid.view.VehicleUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class CarShowMainMenuController implements ActionListener, WindowListener {
  private CarShowMainMenu carShowMainMenu = null;
  private int count = 3;
  private final String USERID = "david";
  private final String PASSWORD = "beltran";

  /**
   *
   */
  public CarShowMainMenuController() {
  }

  /**
   *
   * @param carShowMainMenu
   * Constructor that adds action listener to when button's are triggered on GUI
   */
  public CarShowMainMenuController(CarShowMainMenu carShowMainMenu) {
    this.carShowMainMenu = carShowMainMenu;
    
    //carShowMainMenu.addWindowListener(this);
    carShowMainMenu.getExitMenuItem().addActionListener(this);
    carShowMainMenu.getOwnerMainMenuButton().addActionListener(this);
    carShowMainMenu.getCarShowMainMenuButton().addActionListener(this);
    carShowMainMenu.getCarShowOwnerMainMenuButton().addActionListener(this);
    carShowMainMenu.getVehicleMainMenuButton().addActionListener(this);
    carShowMainMenu.getPrintReportMainMenuButton().addActionListener(this);
    carShowMainMenu.getEditMainMenuItem().addActionListener(this);
    carShowMainMenu.getFileMainMenuItem().addActionListener(this);
    carShowMainMenu.getSubmitMainMenuButton().addActionListener(this);
  }
  
  /**
   * 
   * @param event 
   * Determines which method to run depending on which object handling button is triggered
   */
  @Override
  public void actionPerformed(ActionEvent event) {
    try {
      if (event.getSource().equals(carShowMainMenu.getExitMenuItem())) {
        exitMenuItem_actionPerformed(event);
      } else if (event.getSource().equals(carShowMainMenu.getOwnerMainMenuButton())) {
        ownerMainMenuButton_actionPerformed(event);
      } else if (event.getSource().equals(carShowMainMenu.getVehicleMainMenuButton())) {
        vehicleMainMenuButton_actionPerformed(event);
      } else if (event.getSource().equals(carShowMainMenu.getCarShowMainMenuButton())) {
        carShowMainMenuButton_actionPerformed(event);
      } else if (event.getSource().equals(carShowMainMenu.getCarShowOwnerMainMenuButton())) {
        carShowOwnerMainMenuButton_actionPerformed(event);
      } else if (event.getSource().equals(carShowMainMenu.getPrintReportMainMenuButton())) {
        printReportMainMenuButton_actionPerformed(event);
      } else if (event.getSource().equals(carShowMainMenu.getSubmitMainMenuButton())) {
        submitMainMenuButton_actionPerformed(event);
      }
    } catch (Exception e) {
      try {
        throw e;
      } catch (Exception ex) {
        Logger.getLogger(CarShowMainMenuController.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
  }
  
  /**
   * 
   * @param event
   * @throws Exception 
   * Handles ExitMenuItem when exiting the UI window
   */
  private void exitMenuItem_actionPerformed(ActionEvent event) throws Exception  {
    PersistManager persistManager = carShowMainMenu.getPersistManager();
    persistManager.putPeristData(carShowMainMenu.getOwnerManager(), 
        carShowMainMenu.getVehicleManager(), carShowMainMenu.getCarShowManager(), 
        carShowMainMenu.getCarShowOwnerManager());
    System.exit(0);
  }
  
  /**
   * 
   * @param event
   * @throws Exception 
   * Handles displaying OwnerUI when Owner button is triggered
   */
  private void ownerMainMenuButton_actionPerformed(ActionEvent event) throws Exception {
    OwnerUI ownerUI = new OwnerUI(carShowMainMenu);
    ownerUI.setVisible(true);
  }
  
  /**
   * 
   * @param event
   * @throws Exception 
   * Handles displaying VehicleUI when Vehicle button is triggered
   */
  private void vehicleMainMenuButton_actionPerformed(ActionEvent event) throws Exception {
    VehicleUI vehicleUI = new VehicleUI(carShowMainMenu);
    vehicleUI.setVisible(true);
  }
  
  /**
   * 
   * @param event
   * @throws Exception 
   * Handles displaying CarShowUI when Car Show button is triggered
   */
  private void carShowMainMenuButton_actionPerformed(ActionEvent event) throws Exception {
    CarShowUI carShowUI = new CarShowUI(carShowMainMenu);
    carShowUI.setVisible(true);
  }
  
  /**
   * 
   * @param event
   * @throws Exception 
   * Handles displaying CarShowOwnerUI when Car Show Owner button is triggered
   */
  private void carShowOwnerMainMenuButton_actionPerformed(ActionEvent event) throws Exception {
    CarShowOwnerUI carShowOwnerUI = new CarShowOwnerUI(carShowMainMenu);
    carShowOwnerUI.setVisible(true);
  }
  
  /**
   * 
   * @param event
   * @throws Exception 
   * Handles displaying PrintUI when Print Report button is triggered
   */
  private void printReportMainMenuButton_actionPerformed(ActionEvent event) throws Exception {
    PrintUI printUI = new PrintUI(carShowMainMenu);
    printUI.setVisible(true);
  }
  
  /**
   * 
   * @param event
   * @throws Exception 
   * Authenticates entered login input. Accepted
   * credentials allows use of CarShowMainMenu buttons when Submit button is triggered
   */
  private void submitMainMenuButton_actionPerformed(ActionEvent event) throws Exception {
    String response = "";

    if (carShowMainMenu.getUserIdTextField() != null) {
      if (carShowMainMenu.getPasswordTextField() != null) {
        try {
          if ((carShowMainMenu.getUserIdTextField().getText().equals(USERID)) && 
              (String.valueOf(carShowMainMenu.getPasswordTextField().getPassword())
                  .equals(PASSWORD))) {
            response = "SUCCESS";
          } else {
            response = "FAILURE";
          }
          if (response.equals("SUCCESS")) {
            count = 0;
            carShowMainMenu.getOwnerMainMenuButton().setEnabled(true);
            carShowMainMenu.getVehicleMainMenuButton().setEnabled(true);
            carShowMainMenu.getCarShowMainMenuButton().setEnabled(true);
            carShowMainMenu.getCarShowOwnerMainMenuButton().setEnabled(true);
            carShowMainMenu.getPrintReportMainMenuButton().setEnabled(true);
            carShowMainMenu.getSubmitMainMenuButton().setVisible(false);
            carShowMainMenu.getLoginHeaderLabel().setVisible(false);
            carShowMainMenu.getUserIdLabel().setVisible(false);
            carShowMainMenu.getPasswordLabel().setVisible(false);
            carShowMainMenu.getUserIdTextField().setVisible(false);
            carShowMainMenu.getPasswordTextField().setVisible(false);
          } else if (response.equals("FAILURE")){
            count--;
            if (count <=0) {
              JOptionPane.showMessageDialog(carShowMainMenu.getContainer(), 
                "Three attempts. System shutting down.");
              System.exit(0);
            }
            JOptionPane.showMessageDialog(carShowMainMenu.getContainer(), 
                "Incorrect login\n" + count + " attempts left");
          } 
        } catch (Exception e) {
          throw e;
        }
      }
    }
  }

  /**
   * 
   * @param e 
   */
  @Override
  public void windowOpened(WindowEvent e) {
  }

  /**
   * 
   * @param e 
   */
  @Override
  public void windowClosing(WindowEvent e) {
    PersistManager persistManager = carShowMainMenu.getPersistManager();
    try {
      persistManager.putPeristData(carShowMainMenu.getOwnerManager(), 
          carShowMainMenu.getVehicleManager(), carShowMainMenu.getCarShowManager(), 
          carShowMainMenu.getCarShowOwnerManager());
    } catch (Exception exc) {
      try {
        throw exc;
      } catch (Exception ex) {
        Logger.getLogger(CarShowMainMenuController.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
    System.exit(0);
  }

  /**
   * 
   * @param e 
   */
  @Override
  public void windowClosed(WindowEvent e) {
  }

  /**
   * 
   * @param e 
   */
  @Override
  public void windowIconified(WindowEvent e) {
  }

  /**
   * 
   * @param e 
   */
  @Override
  public void windowDeiconified(WindowEvent e) {
  }

  /**
   * 
   * @param e 
   */
  @Override
  public void windowActivated(WindowEvent e) {
  }

  /**
   * 
   * @param e 
   */
  @Override
  public void windowDeactivated(WindowEvent e) {
  }
  
}
