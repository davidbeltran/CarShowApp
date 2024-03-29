/**
 *
 * @author David Beltran
 * File: CarShowOwnerUI.java
 * This file contains the CarShowOwnerUI class which is responsible for
 * displaying and running the car show application's CarShowOwner GUI
 */
package edu.du.beltrandavid.view;

import edu.du.beltrandavid.controllor.carshowcontroller.CarShowUIController;
import edu.du.beltrandavid.controllor.carshowownercontroller.CarShowOwnerUIController;
import edu.du.beltrandavid.model.business.manager.carshowmanager.CarShowManager;
import edu.du.beltrandavid.model.business.manager.carshowownermanager.CarShowOwnerManager;
import edu.du.beltrandavid.model.business.manager.ownermanager.OwnerManager;
import edu.du.beltrandavid.model.business.manager.vehiclemanager.VehicleManager;
import edu.du.beltrandavid.model.domain.CarShow;
import edu.du.beltrandavid.model.domain.CarShowOwner;
import edu.du.beltrandavid.model.domain.Owner;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/**
 *
 * @author David Beltran
 */
public class CarShowOwnerUI extends javax.swing.JFrame {
  
  private OwnerManager ownerManager = null;
  private VehicleManager vehicleManager = null;
  private CarShowManager carShowManager = null;
  private CarShowOwnerManager carShowOwnerManager = null;
  private CarShowMainMenu carShowMainMenu = null;
  
  private final Container container = getContentPane();
  
  /**
   * Creates new form CarShowOwnerUI
   */
  public CarShowOwnerUI() {
    
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    Dimension windowSize = new Dimension((screenSize.width / 2) - 425, 
        (screenSize.height / 2) - 175);
    setPreferredSize(windowSize);
    setLocation(((screenSize.width - windowSize.width) / 2), 
        ((screenSize.height - windowSize.height) / 2));
    
    initComponents();
    setTitle("Car show owner Collection");
  }

  public CarShowOwnerUI(CarShowMainMenu carShowMainMenu) throws Exception {
    
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    Dimension windowSize = new Dimension((screenSize.width / 2) - 425, 
        (screenSize.height / 2) - 175);
    setPreferredSize(windowSize);
    setLocation(((screenSize.width - windowSize.width) / 2), 
        ((screenSize.height - windowSize.height) / 2));
    
    initComponents();
    setTitle("Car show owner Collection");
    
    this.carShowMainMenu = carShowMainMenu;
    ownerManager = carShowMainMenu.getOwnerManager();
    vehicleManager = carShowMainMenu.getVehicleManager();
    carShowManager = carShowMainMenu.getCarShowManager();
    carShowOwnerManager = carShowMainMenu.getCarShowOwnerManager();
    
    Iterator<CarShow> itr = carShowManager.getCarShows();
    ArrayList<CarShow> carShowArrayList = new ArrayList<>();
    while (itr.hasNext()) {
      carShowArrayList.add((CarShow) itr.next());
    }
    
    carShowIdComboBox.removeAllItems();
    for (CarShow carShow : carShowArrayList) {
      carShowIdComboBox.addItem(carShow.getCarShowId());
    }
    carShowIdComboBox.setSelectedIndex(0);
    carShowIdComboBox.setEditable(false);
    
    Iterator<Owner> oitr = ownerManager.getOwners();
    ArrayList<Owner> ownerArrayList = new ArrayList<>();
    while (oitr.hasNext()) {
      ownerArrayList.add((Owner) oitr.next());
    }
    
    ownerIdComboBox.removeAllItems();
    for (Owner owner : ownerArrayList) {
      ownerIdComboBox.addItem(owner.getOwnerId());
    }
    ownerIdComboBox.setSelectedIndex(0);
    ownerIdComboBox.setEditable(false);
    
    CarShowOwnerUIController carShowOwnerUIController = new CarShowOwnerUIController(this);
    
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

    carShowIdLabel = new javax.swing.JLabel();
    ownerIdLabel = new javax.swing.JLabel();
    carShowIdComboBox = new javax.swing.JComboBox<>();
    ownerIdComboBox = new javax.swing.JComboBox<>();
    carShowOwnerInformationHeader = new javax.swing.JLabel();
    findCarShowOwnerButton = new javax.swing.JButton();
    addCarShowOwnerButton = new javax.swing.JButton();
    removeCarShowOwnerButton = new javax.swing.JButton();
    carShowOwnerMenuBar = new javax.swing.JMenuBar();
    fileCarShowOwnerMenuItem = new javax.swing.JMenu();
    exitCarShowOwnerMenuItem = new javax.swing.JMenuItem();
    editCarShowOwnerMenuItem = new javax.swing.JMenu();

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

    carShowIdLabel.setText("Car Show ID");
    carShowIdLabel.setToolTipText("");

    ownerIdLabel.setText("Owner ID");
    ownerIdLabel.setToolTipText("");

    carShowIdComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
    carShowIdComboBox.setFocusCycleRoot(true);
    carShowIdComboBox.setNextFocusableComponent(ownerIdComboBox);

    ownerIdComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
    ownerIdComboBox.setNextFocusableComponent(findCarShowOwnerButton);

    carShowOwnerInformationHeader.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    carShowOwnerInformationHeader.setText("Car Show Owner Information");
    carShowOwnerInformationHeader.setToolTipText("");

    findCarShowOwnerButton.setText("FIND");
    findCarShowOwnerButton.setToolTipText("Find selected car show owner");
    findCarShowOwnerButton.setNextFocusableComponent(addCarShowOwnerButton);

    addCarShowOwnerButton.setText("ADD");
    addCarShowOwnerButton.setToolTipText("Add selected car show owner");
    addCarShowOwnerButton.setNextFocusableComponent(removeCarShowOwnerButton);

    removeCarShowOwnerButton.setText("REMOVE");
    removeCarShowOwnerButton.setToolTipText("Remove selected car show owner");
    removeCarShowOwnerButton.setNextFocusableComponent(fileCarShowOwnerMenuItem);

    fileCarShowOwnerMenuItem.setText("File");
    fileCarShowOwnerMenuItem.setNextFocusableComponent(editCarShowOwnerMenuItem);

    exitCarShowOwnerMenuItem.setText("Exit");
    exitCarShowOwnerMenuItem.setToolTipText("Exit the system");
    fileCarShowOwnerMenuItem.add(exitCarShowOwnerMenuItem);

    carShowOwnerMenuBar.add(fileCarShowOwnerMenuItem);

    editCarShowOwnerMenuItem.setText("Edit");
    editCarShowOwnerMenuItem.setNextFocusableComponent(carShowIdComboBox);
    carShowOwnerMenuBar.add(editCarShowOwnerMenuItem);

    setJMenuBar(carShowOwnerMenuBar);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(36, 36, 36)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(carShowOwnerInformationHeader)
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(carShowIdLabel)
              .addComponent(ownerIdLabel)
              .addComponent(findCarShowOwnerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(layout.createSequentialGroup()
                .addComponent(addCarShowOwnerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(removeCarShowOwnerButton))
              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(carShowIdComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ownerIdComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
        .addContainerGap(36, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(25, 25, 25)
        .addComponent(carShowOwnerInformationHeader)
        .addGap(14, 14, 14)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(carShowIdLabel)
          .addComponent(carShowIdComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(18, 18, 18)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(ownerIdLabel)
          .addComponent(ownerIdComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(18, 18, 18)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(removeCarShowOwnerButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(findCarShowOwnerButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(addCarShowOwnerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap(34, Short.MAX_VALUE))
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
      java.util.logging.Logger.getLogger(CarShowOwnerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(CarShowOwnerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(CarShowOwnerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(CarShowOwnerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new CarShowOwnerUI().setVisible(true);
      }
    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton addCarShowOwnerButton;
  private javax.swing.JComboBox<String> carShowIdComboBox;
  private javax.swing.JLabel carShowIdLabel;
  private javax.swing.JLabel carShowOwnerInformationHeader;
  private javax.swing.JMenuBar carShowOwnerMenuBar;
  private javax.swing.JMenu editCarShowOwnerMenuItem;
  private javax.swing.JMenuItem exitCarShowOwnerMenuItem;
  private javax.swing.JMenu fileCarShowOwnerMenuItem;
  private javax.swing.JButton findCarShowOwnerButton;
  private javax.swing.JComboBox<String> ownerIdComboBox;
  private javax.swing.JLabel ownerIdLabel;
  private javax.swing.JButton removeCarShowOwnerButton;
  // End of variables declaration//GEN-END:variables

  /**
   * 
   * @param carShowOwner 
   * Fills fields with selected object
   */
  public void putCarShowOwnerInfo(CarShowOwner carShowOwner) {
    carShowIdComboBox.setSelectedItem(carShowOwner.getCarShowId());
    ownerIdComboBox.setSelectedItem(carShowOwner.getOwnerId());
  }
  
  /**
   * 
   * @return 
   * Returns object from field inputs
   */
  public CarShowOwner getCarShowOwnerInfo() {
    CarShowOwner carShowOwner = new CarShowOwner();
    
    carShowOwner.setCarShowId((String) carShowIdComboBox.getSelectedItem());
    carShowOwner.setOwnerId((String) ownerIdComboBox.getSelectedItem());
    
    return carShowOwner;
  }
  
  /**
   * Empties input fields
   */
  public void clearCarShowOwnerInfo() {
    carShowIdComboBox.setSelectedIndex(0);
    ownerIdComboBox.setSelectedIndex(0);
  }

  public OwnerManager getOwnerManager() {
    return ownerManager;
  }

  public VehicleManager getVehicleManager() {
    return vehicleManager;
  }

  public CarShowManager getCarShowManager() {
    return carShowManager;
  }

  public CarShowOwnerManager getCarShowOwnerManager() {
    return carShowOwnerManager;
  }

  public CarShowMainMenu getCarShowMainMenu() {
    return carShowMainMenu;
  }

  public Container getContainer() {
    return container;
  }

  public javax.swing.JButton getAddCarShowOwnerButton() {
    return addCarShowOwnerButton;
  }

  public javax.swing.JComboBox<String> getCarShowIdComboBox() {
    return carShowIdComboBox;
  }

  public javax.swing.JLabel getCarShowIdLabel() {
    return carShowIdLabel;
  }

  public javax.swing.JLabel getCarShowOwnerInformationHeader() {
    return carShowOwnerInformationHeader;
  }

  public javax.swing.JMenuBar getCarShowOwnerMenuBar() {
    return carShowOwnerMenuBar;
  }

  public javax.swing.JMenu getEditCarShowOwnerMenuItem() {
    return editCarShowOwnerMenuItem;
  }

  public javax.swing.JMenuItem getExitCarShowOwnerMenuItem() {
    return exitCarShowOwnerMenuItem;
  }

  public javax.swing.JMenu getFileCarShowOwnerMenuItem() {
    return fileCarShowOwnerMenuItem;
  }

  public javax.swing.JButton getFindCarShowOwnerButton() {
    return findCarShowOwnerButton;
  }

  public javax.swing.JComboBox<String> getOwnerIdComboBox() {
    return ownerIdComboBox;
  }

  public javax.swing.JLabel getOwnerIdLabel() {
    return ownerIdLabel;
  }

  public javax.swing.JButton getRemoveCarShowOwnerButton() {
    return removeCarShowOwnerButton;
  }
}
