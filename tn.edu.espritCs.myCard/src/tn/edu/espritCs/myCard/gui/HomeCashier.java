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
 
public class HomeCashier extends JFrame {
  private JMenuBar menuBar = new JMenuBar();
  private JMenu menuTransformFidelityPoints = new JMenu("Transform Fidelity Points");

  
  private JMenuItem menuItemAddCashier = new JMenuItem("Add Cashier");
  private JMenuItem menuItemListCashiers = new JMenuItem("List Cashiers");
  private JMenuItem menuItemClose = new JMenuItem("Close");
  

  public static void main(String[] args){
	  HomeCashier zFen = new HomeCashier();
  }
 
  public HomeCashier(){
    this.setSize(800, 600);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
 
    //On initialise nos menus      
    this.menuTransformFidelityPoints.add(menuItemAddCashier);
    this.menuTransformFidelityPoints.add(menuItemListCashiers);
    //Ajout d'un séparateur
    this.menuTransformFidelityPoints.addSeparator();
    menuItemClose.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent arg0) {
        System.exit(0);
      }        
    });
    this.menuTransformFidelityPoints.add(menuItemClose); 
    

    //L'ordre d'ajout va déterminer l'ordre d'apparition dans le menu de gauche à droite
    //Le premier ajouté sera tout à gauche de la barre de menu et inversement pour le dernier
    this.menuBar.add(menuTransformFidelityPoints);
    this.setJMenuBar(menuBar);
    this.setVisible(true);
  }
}