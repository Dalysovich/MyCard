package tn.edu.espritCs.myCard.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
 
public class HomeAdmin extends JFrame {
  private JMenuBar menuBar = new JMenuBar();
  private JMenu menuCashierAccountManagement = new JMenu("Cashier Account Management");
  private JMenu menuCustomerAccountManagment = new JMenu("Customer Account Managment");
  private JMenu menuFidelityOffersManagement = new JMenu("Fidelity Offers Management");
  
  private JMenuItem menuItemAddCashier = new JMenuItem("Add Cashier");
  private JMenuItem menuItemListCashiers = new JMenuItem("List Cashiers");
  private JMenuItem menuItemClose = new JMenuItem("Close");
  private JMenuItem menuItemAddCustomer = new JMenuItem("Add Customer");
  private JMenuItem menuItemListCustomers = new JMenuItem("List Customers");
  private JMenuItem menuItemUpdateOffers = new JMenuItem("Update Offers");

  public static void main(String[] args){
    HomeAdmin zFen = new HomeAdmin();
  }
 
  public HomeAdmin(){
    this.setSize(800, 600);
    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    this.setLocationRelativeTo(null);
 
    //On initialise nos menus      
    this.menuCashierAccountManagement.add(menuItemAddCashier);
    this.menuCashierAccountManagement.add(menuItemListCashiers);
    //Ajout d'un s�parateur
    this.menuCashierAccountManagement.addSeparator();
    menuItemClose.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent arg0) {
        System.exit(0);
      }        
    });
    menuItemAddCashier.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent arg0) {
        	
        AddCashier newCashier=new AddCashier();
       	newCashier.setVisible(true);
       	newCashier.setSize(800, 600);
        }        
      });
    this.menuCashierAccountManagement.add(menuItemClose); 
    
    this.menuCustomerAccountManagment.add(menuItemAddCustomer);
    this.menuCustomerAccountManagment.add(menuItemListCustomers);
 
    this.menuFidelityOffersManagement.add(menuItemUpdateOffers);
    //L'ordre d'ajout va d�terminer l'ordre d'apparition dans le menu de gauche � droite
    //Le premier ajout� sera tout � gauche de la barre de menu et inversement pour le dernier
    this.menuBar.add(menuCashierAccountManagement);
    this.menuBar.add(menuCustomerAccountManagment);
    this.menuBar.add(menuFidelityOffersManagement);
    this.setJMenuBar(menuBar);
    this.setVisible(true);
  }
}