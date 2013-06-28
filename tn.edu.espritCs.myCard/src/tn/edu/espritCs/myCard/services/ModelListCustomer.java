package tn.edu.espritCs.myCard.services;

import javax.swing.table.AbstractTableModel;

import tn.edu.espritCs.myCard.dao.CustomerDao;

public class ModelListCustomer  extends AbstractTableModel 
{
	{
		CustomerDao customerDao = new CustomerDao();
		customerDao.fillAllCustomer();
	}
	//private UtilJdbc utilJdbc = new UtilJdbc();
	private CustomerDao customerDao = new CustomerDao();
	//private final List<Cashier> cashiers; 
	//private final List<String> cashiersIndex; 
    private final String[] entetes = {"First Name", "Last Name", "Phone Number", "Email", "BarCode"};
  
    
    public ModelListCustomer() 
    {
        super();
        customerDao.fillAllCustomer();
      //  cashiers = new ArrayList<Cashier>(cashierDao.getListCashiers());
      //  cashiersIndex = new ArrayList<>(cashierDao.getListCashiersIndex());
        
    }
 
    public int getRowCount() 
    {
        return customerDao.getListCustomers().size();
    }
 
    public int getColumnCount() 
    {
        return entetes.length;
    }
 
    public String getColumnName(int columnIndex)
    {
        return entetes[columnIndex];
    }
 
    public Object getValueAt(int rowIndex, int columnIndex) 
    {
        switch(columnIndex)
        {
            case 0:
                return customerDao.getListCustomers().get(rowIndex).getFirstNameUser();
            case 1:
                return customerDao.getListCustomers().get(rowIndex).getLastNameUser();
            case 2:
                return customerDao.getListCustomers().get(rowIndex).getPhoneNumberUser();
            case 3:
                return customerDao.getListCustomers().get(rowIndex).getEmailUser();
            case 4:
                return customerDao.getListCustomers().get(rowIndex).getBarCode();
            default:
                return null; 
        }
    }
 
    public void removeCustomer(int rowIndex) 
    {
    	customerDao.getListCustomers().remove(rowIndex);
        fireTableRowsDeleted(rowIndex, rowIndex);
        Integer idUserToDelete=Integer.parseInt((customerDao.getListCustomersIndex().get(rowIndex)));
        System.out.println("The Id of the Customer to remove : "+idUserToDelete);
        try
        {
        	customerDao.deleteCustomerById(idUserToDelete);
        }
        catch (Exception e)
        { 
        	e.printStackTrace();
        }
    }
}
