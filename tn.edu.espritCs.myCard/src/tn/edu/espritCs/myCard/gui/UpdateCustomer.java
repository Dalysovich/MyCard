package tn.edu.espritCs.myCard.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import tn.edu.espritCs.myCard.dao.CustomerDao;
import tn.edu.espritCs.myCard.domain.Customer;

public class UpdateCustomer 
{
	 private JTable tableCustomer;
	 CustomerDao customerDao = new CustomerDao();
	 
		DefaultTableModel modelDefautTable =new DefaultTableModel()
		{ 
			public boolean isCellEditable(int row, int column) 
			{
		       return (column == 0)||(column == 1)||(column == 2)||(column == 3);
		   }
		};
		
		public static void main(String[] args) 
		{
			new UpdateCustomer();
		}
		
	
		
	    public UpdateCustomer() 
	    {
	        super();
	        try {
	    		modelDefautTable.addColumn("First Name");
	    		modelDefautTable.addColumn("Last Name");
	    		modelDefautTable.addColumn("Phone Number");
	    		modelDefautTable.addColumn("Email");
	    		modelDefautTable.addColumn("BarCode");
	    		
	    		customerDao.fillAllCustomer();
	    	    
	    		for (Customer customer : customerDao.getListCustomers())
	    		{
	    			String data[] = {customer.getFirstNameUser() ,customer.getLastNameUser(),customer.getPhoneNumberUser(),customer.getEmailUser(),customer.getBarCode()};	
	    			//System.out.println(chasier.getFirstNameUser());
	    			modelDefautTable.addRow(data);
	    		}
	    		
	    		
	                 
	    		JFrame frame = new JFrame("Update Chasier's Data from cell");
	    		JPanel panel = new JPanel();

	    		tableCustomer = new JTable(modelDefautTable);
	    	
	    	
	    		JTableHeader header = tableCustomer.getTableHeader();
	    		header.setBackground(Color.yellow);
	    		JScrollPane pane = new JScrollPane(tableCustomer);
	    		JButton btnNewButton = new JButton("Apply Changes");
	    		btnNewButton.addActionListener(new ActionListener()
	    		{
	    			public void actionPerformed(ActionEvent arg0) 
	    			{
	    				int[] selection = tableCustomer.getSelectedRows();
	    				Integer updateId=-1;
	    				int customerIndex=-1;
	    				Customer updatedCustomer = new Customer();
	    				 
	    	             for(int i = selection.length - 1; i >= 0; i--)
	    	             {
	    	            	 updateId = Integer.parseInt(customerDao.getListCustomersIndex().get(selection[i]));
	    	            	 customerIndex = selection[i];
	    	             }
	    	             
	    	             updatedCustomer.setFirstNameUser(tableCustomer.getValueAt(customerIndex, 0).toString());
	    	             updatedCustomer.setLastNameUser(tableCustomer.getValueAt(customerIndex, 1).toString());
	    	             updatedCustomer.setPhoneNumberUser(tableCustomer.getValueAt(customerIndex, 2).toString());
	    	             updatedCustomer.setEmailUser(tableCustomer.getValueAt(customerIndex, 3).toString());

	    	             
	    	             customerDao.UpdateCustomerDao(updatedCustomer,updateId);
	    	            
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
	        }
	        catch (Exception e) 
	        {
	        	e.printStackTrace();
	        }
	    }
}
