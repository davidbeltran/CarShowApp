/**
 *
 * @author David Beltran
 * File: PrintUIController.java
 * This file contains the PrintUIController class which is responsible for
 * handling data that is displayed on the PrintUI class
 */
package edu.du.beltrandavid.controllor.printcontroller;

import edu.du.beltrandavid.view.PrintUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PrintUIController implements ActionListener {
  
  PrintUI printUI = null;

  /**
   *
   */
  public PrintUIController() {
  }
  
  /**
   *
   * @param printUI
   * Constructor that adds action listener to when button's are triggered on GUI
   */
  public PrintUIController(PrintUI printUI) {
    this.printUI = printUI;
    printUI.getExitButton().addActionListener(this);
  }

  /**
   * 
   * @param event 
   * Runs exitReportButton_actionPerformed method when Exit button is triggered
   */
  @Override
  public void actionPerformed(ActionEvent event) {
    try {
      if (event.getSource().equals(printUI.getExitButton())) {
        exitReportButton_actionPerformed(event);
      }
    } catch (Exception e) {
      try {
        throw e;
      } catch (Exception ex) {
        Logger.getLogger(PrintUIController.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
  }
  
  /**
   * 
   * @param event
   * @throws Exception 
   * Removes PrintUI GUI when Exit button is triggered
   */
  private void exitReportButton_actionPerformed(ActionEvent event) throws Exception {
    printUI.setVisible(false);
  }
}
