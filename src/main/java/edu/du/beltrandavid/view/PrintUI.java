/**
 *
 * @author David Beltran
 * File: PrintUI.java
 * This file contains the PrintUI class which is responsible for
 * displaying and running the car show application's Print Report GUI
 */
package edu.du.beltrandavid.view;

import edu.du.beltrandavid.controllor.printcontroller.PrintUIController;
import edu.du.beltrandavid.model.business.manager.carshowmanager.CarShowManager;
import edu.du.beltrandavid.model.business.manager.carshowownermanager.CarShowOwnerManager;
import edu.du.beltrandavid.model.business.manager.ownermanager.OwnerManager;
import edu.du.beltrandavid.model.business.manager.vehiclemanager.VehicleManager;
import edu.du.beltrandavid.model.domain.CarShow;
import edu.du.beltrandavid.model.domain.CarShowOwner;
import edu.du.beltrandavid.model.domain.Owner;
import edu.du.beltrandavid.model.domain.Vehicle;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Iterator;

public class PrintUI extends javax.swing.JFrame {
  
  private OwnerManager ownerManager = null;
  private VehicleManager vehicleManager = null;
  private CarShowManager carShowManager = null;
  private CarShowOwnerManager carShowOwnerManager = null;
  private CarShowMainMenu carShowMainMenu = null;
  
  private final Container container = getContentPane();

  /**
   * Creates new form PrintUI
   */
  public PrintUI() {
    
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    Dimension windowSize = new Dimension((screenSize.width / 2) - 400, 
        (screenSize.height / 2) - 100);
    setPreferredSize(windowSize);
    setLocation(((screenSize.width - windowSize.width) / 2), 
        ((screenSize.height - windowSize.height) / 2));
    
    initComponents();
    setTitle("Owner Report");
  }

  /**
   *
   * @param carShowMainMenu
   * @throws Exception
   * Constructor formats collection data into a report
   */
  public PrintUI(CarShowMainMenu carShowMainMenu) throws Exception {
    
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    Dimension windowSize = new Dimension((screenSize.width / 2) - 400, 
        (screenSize.height / 2) - 100);
    setPreferredSize(windowSize);
    setLocation(((screenSize.width - windowSize.width) / 2), 
        ((screenSize.height - windowSize.height) / 2));
    
    initComponents();
    setTitle("Owner Report");
    
    this.carShowMainMenu = carShowMainMenu;
    ownerManager = carShowMainMenu.getOwnerManager();
    vehicleManager = carShowMainMenu.getVehicleManager();
    carShowManager = carShowMainMenu.getCarShowManager();
    carShowOwnerManager = carShowMainMenu.getCarShowOwnerManager();
    
    String output = "";
    Iterator<Owner> ownerItr = ownerManager.getOwners();
    Iterator<Vehicle> vehicleItr = vehicleManager.getVehicles();
    Iterator<CarShow> carShowItr = carShowManager.getCarShows();
    Iterator<CarShowOwner> carShowOwnerItr = carShowOwnerManager.getCarShowOwners();
    ArrayList<Owner> owners = new ArrayList<>();
    ArrayList<Vehicle> vehicles = new ArrayList<>();
    ArrayList<CarShow> carShows = new ArrayList<>();
    ArrayList<CarShowOwner> carShowOwners = new ArrayList<>();
    while (ownerItr.hasNext()) {
      owners.add((Owner) ownerItr.next());
    }
    while (vehicleItr.hasNext()) {
      vehicles.add((Vehicle) vehicleItr.next());
    }
    while (carShowItr.hasNext()) {
      carShows.add((CarShow) carShowItr.next());
    }
    while (carShowOwnerItr.hasNext()) {
      carShowOwners.add((CarShowOwner) carShowOwnerItr.next());
    }
    for (Owner o: owners) {
        if (o.isSeniorOwner()) {
          output += "OWNER " + o.getFirstName() + " " + o.getLastName() + "  **SO**\n";
        } else {
          output += "OWNER " + o.getFirstName() + " " + o.getLastName() + "\n";
        }
        output += "   VEHICLES\n";
        for (Vehicle v: vehicles) {
          if (v.getOwnerId().equals(o.getOwnerId())) {
            output += "       " + v.getModelYear() + " " + v.getManufacturer() + 
                " " + v.getModel() + " " + v.getSubmodel() + "\n";
          }
        }
        output += "   CAR SHOWS\n";
        for (CarShowOwner cso: carShowOwners) {
          if (cso.getOwnerId().equals(o.getOwnerId())) {
            for (CarShow cs: carShows) {
              if (cs.getCarShowId().equals(cso.getCarShowId())) {
                if (cs.isSanctioned()) {
                  output += "       " + cs.getCarShowTitle() + "\n";
                } else {
                  output += "       " + cs.getCarShowTitle() + "   !!!!\n";
                }
              }
            }
          }
        }
    }
    
    populateReport(output);
    
    PrintUIController printUIController = new PrintUIController(this);
    
    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent ev){
      }
    });
  }
  /**
   * This method is called from within the constructor to initialize the form. WARNING: Do NOT
   * modify this code. The content of this method is always regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jScrollPane1 = new javax.swing.JScrollPane();
    reportTextPane = new javax.swing.JTextPane();
    exitButton = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    jScrollPane1.setViewportView(reportTextPane);

    exitButton.setText("EXIT");
    exitButton.setToolTipText("Exit report page");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jScrollPane1)
        .addContainerGap())
      .addGroup(layout.createSequentialGroup()
        .addGap(163, 163, 163)
        .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(164, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addComponent(exitButton)
        .addContainerGap(12, Short.MAX_VALUE))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  /**
   * @param args the command line arguments
   */
  public static void main(String args[]) {
    /* Set the Nimbus look and feel */
    //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
    /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
     */
    try {
      for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (ClassNotFoundException ex) {
      java.util.logging.Logger.getLogger(PrintUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(PrintUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(PrintUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(PrintUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new PrintUI().setVisible(true);
      }
    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton exitButton;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JTextPane reportTextPane;
  // End of variables declaration//GEN-END:variables

  private void populateReport(String report) {
    reportTextPane.setText(report);
  }

  /**
   *
   * @return
   */
  public OwnerManager getOwnerManager() {
    return ownerManager;
  }

  /**
   *
   * @return
   */
  public VehicleManager getVehicleManager() {
    return vehicleManager;
  }

  /**
   *
   * @return
   */
  public CarShowManager getCarShowManager() {
    return carShowManager;
  }

  /**
   *
   * @return
   */
  public CarShowOwnerManager getCarShowOwnerManager() {
    return carShowOwnerManager;
  }

  /**
   *
   * @return
   */
  public CarShowMainMenu getCarShowMainMenu() {
    return carShowMainMenu;
  }

  /**
   *
   * @return
   */
  public Container getContainer() {
    return container;
  }

  /**
   *
   * @return
   */
  public javax.swing.JButton getExitButton() {
    return exitButton;
  }

  /**
   *
   * @return
   */
  public javax.swing.JScrollPane getjScrollPane1() {
    return jScrollPane1;
  }

  /**
   *
   * @return
   */
  public javax.swing.JTextPane getReportTextPane() {
    return reportTextPane;
  }
}
