package tn.edu.espritCs.myCard.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import tn.edu.espritCs.myCard.dao.CashierDao;
import tn.edu.espritCs.myCard.dao.UserDao;
import tn.edu.espritCs.myCard.domain.Cashier;
import tn.edu.espritCs.myCard.services.ModelListCashier;
import tn.edu.espritCs.myCard.technical.UtilJdbc;


public class UpdateCashier extends JFrame
{
    private JTable tableChasier;
    CashierDao cashierDao = new CashierDao();
	DefaultTableModel modelDefautTable =new DefaultTableModel();
	
	public static void main(String[] args) 
	{
		new UpdateCashier();
	}
	
	
    public UpdateCashier() 
    {
        super();
        try {
    		modelDefautTable.addColumn("First Name");
    		modelDefautTable.addColumn("Last Name");
    		modelDefautTable.addColumn("Phone Number");
    		modelDefautTable.addColumn("Email");
    		modelDefautTable.addColumn("Login");
    		modelDefautTable.addColumn("Password");
    		
    		cashierDao.fillAllCashiers();
    	    
    		for (Cashier chasier : cashierDao.getListCashiers())
    		{
    			String data[] = {chasier.getFirstNameUser() ,chasier.getLastNameUser(),chasier.getPhoneNumberUser(),chasier.getEmailUser(),chasier.getLogin(),chasier.getPwd()};	
    			//System.out.println(chasier.getFirstNameUser());
    			modelDefautTable.addRow(data);
    		}
                 
    		JFrame frame = new JFrame("Update Chasier's Data from cell");
    		JPanel panel = new JPanel();

    		tableChasier = new JTable(modelDefautTable);
    	
    		JTableHeader header = tableChasier.getTableHeader();
    		header.setBackground(Color.yellow);
    		JScrollPane pane = new JScrollPane(tableChasier);
    		JButton btnNewButton = new JButton("Apply Changes");
    		btnNewButton.addActionListener(new ActionListener()
    		{
    			public void actionPerformed(ActionEvent arg0) 
    			{
    				int[] selection = tableChasier.getSelectedRows();
    				Integer updateId=-1;
    				int cashierIndex=-1;
    				Cashier updatedCashier = new Cashier();
    				
    				
    				//Cashier cashierUpdated = new Cashier();
    				 
    	             for(int i = selection.length - 1; i >= 0; i--)
    	             {
    	            	 updateId = Integer.parseInt(cashierDao.getListCashiersIndex().get(selection[i]));
    	            	 cashierIndex = selection[i];
    	            	 // System.out.println("updateId "+updateId);	
    	            	 // System.out.println("selection[i] "+selection[i]);
    	             }
    	             
    	             updatedCashier.setFirstNameUser(tableChasier.getValueAt(cashierIndex, 0).toString());
    	             updatedCashier.setLastNameUser(tableChasier.getValueAt(cashierIndex, 1).toString());
    	             updatedCashier.setPhoneNumberUser(tableChasier.getValueAt(cashierIndex, 2).toString());
    	             updatedCashier.setEmailUser(tableChasier.getValueAt(cashierIndex, 3).toString());
    	             updatedCashier.setLogin(tableChasier.getValueAt(cashierIndex, 4).toString());
    	             updatedCashier.setPwd(tableChasier.getValueAt(cashierIndex, 5).toString());
    	             
    	             cashierDao.UpdateCashierDao(updatedCashier,updateId);
    	            
    			}
    		});
    		 
    		panel.add(pane);
    		panel.add(btnNewButton);
    		frame.add(panel);
    		
    		frame.setSize(500,600);
    		frame.setUndecorated(false);
    		
    		//frame.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
    		frame.setVisible(true);
    		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }catch (Exception e) {

		   	}
    }
 
 
    
}