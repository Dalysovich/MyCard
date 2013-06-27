package tn.edu.espritCs.myCard.gui;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import tn.edu.espritCs.myCard.domain.Cashier;
import tn.edu.espritCs.myCard.services.ModelListCashier;
import tn.edu.espritCs.myCard.technical.UtilJdbc;

public class ListCashier extends JFrame 
{
    private ModelListCashier modelListCashier = new ModelListCashier();
    private JTable tableCashier;

    public ListCashier()
    {
        super();
        
        setTitle("Show all Cashier");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tableCashier = new JTable(modelListCashier);
        getContentPane().add(new JScrollPane(tableCashier), BorderLayout.CENTER);
        JPanel boutons = new JPanel();
        boutons.add(new JButton(new RemoveAction()));
        getContentPane().add(boutons, BorderLayout.SOUTH);
        pack();
    }
 
    public static void main(String[] args)
    {
        new ListCashier().setVisible(true);
    }

    private class RemoveAction extends AbstractAction
    {
        private RemoveAction() 
        {
            super("Delete");
        }
 
        public void actionPerformed(ActionEvent e) {
            int[] selection = tableCashier.getSelectedRows();
            
            for(int i = selection.length - 1; i >= 0; i--)
            {
            	modelListCashier.removeCashier(selection[i]);
            }
  
        }
    }
}