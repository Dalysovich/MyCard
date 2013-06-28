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
  private JMenuItem menuItemDeleteCashiers = new JMenuItem("Delete Cashier");
  private JMenuItem menuItemUpdateCashiers = new JMenuItem("Update Cashier");
  private JMenuItem menuItemClose = new JMenuItem("Close");
  private JMenuItem menuItemAddCustomer = new JMenuItem("Add Customer");
  private JMenuItem menuItemDeleteCustomer = new JMenuItem("Delete Customer");
  private JMenuItem menuItemUpdateCustomer = new JMenuItem("Update Cashier");
  
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
    this.menuCashierAccountManagement.add(menuItemDeleteCashiers);
    this.menuCashierAccountManagement.add(menuItemUpdateCashiers);
    //Ajout d'un séparateur
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
    menuItemDeleteCashiers.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent arg0) {
        	
        ListCashier deleteCashier=new ListCashier();
        deleteCashier.setVisible(true);
        deleteCashier.setSize(800, 600);
        }        
      });
    menuItemUpdateCashiers.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent arg0) {       	
        UpdateCashier updateCashier=new UpdateCashier();
        updateCashier.setVisible(false);
        }        
      });
    this.menuCashierAccountManagement.add(menuItemClose); 
    
    this.menuCustomerAccountManagment.add(menuItemAddCustomer);
    this.menuCustomerAccountManagment.add(menuItemDeleteCustomer);
    this.menuCustomerAccountManagment.add(menuItemUpdateCustomer);
    
    menuItemAddCustomer.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent arg0) {
        	
        AddCustomer newCustomer=new AddCustomer();
       	newCustomer.setVisible(true);
       	newCustomer.setSize(800, 600);
        }        
      });
    menuItemDeleteCustomer.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent arg0) {
        	
        ListCustomer deleteCustomer=new ListCustomer();
        deleteCustomer.setVisible(true);
        deleteCustomer.setSize(800, 600);
        }        
      });
    menuItemUpdateCustomer.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent arg0) {       	
        UpdateCustomer updateCustomer=new UpdateCustomer();
       // updateCustomer.setVisible(false);
        }        
      });
    
    this.menuFidelityOffersManagement.add(menuItemUpdateOffers);
    
    menuItemUpdateOffers.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent arg0) {       	
        NewOffers newOffers=new NewOffers();
        newOffers.setVisible(true);
        }        
      });
    //L'ordre d'ajout va déterminer l'ordre d'apparition dans le menu de gauche à droite
    //Le premier ajouté sera tout à gauche de la barre de menu et inversement pour le dernier
    this.menuBar.add(menuCashierAccountManagement);
    this.menuBar.add(menuCustomerAccountManagment);
    this.menuBar.add(menuFidelityOffersManagement);
    this.setJMenuBar(menuBar);
    this.setVisible(true);
  }
}