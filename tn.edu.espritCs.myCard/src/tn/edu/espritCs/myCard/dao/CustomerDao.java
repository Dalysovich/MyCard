package tn.edu.espritCs.myCard.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import tn.edu.espritCs.myCard.domain.Cashier;
import tn.edu.espritCs.myCard.domain.Customer;
import tn.edu.espritCs.myCard.technical.UtilJdbc;

public class CustomerDao
{
	UtilJdbc utilJdbc = new UtilJdbc();
	private final List<Customer> listCustomers = new ArrayList<Customer>();
	private final List<String> listCustomersIndex = new ArrayList<>();
	
	
	public boolean addCustomer(Customer customer) 
	{
		boolean b = false;
		int idCustomer=-1;
		try 
		{
			Statement statement = utilJdbc.dataBaseConnetion().createStatement();
			String sqlId = "select MAX(idCustomer) from customer";
			ResultSet resultSet = statement.executeQuery(sqlId);
			while(resultSet.next())
			{
				idCustomer = Integer.parseInt(resultSet.getString(1));
			}
			idCustomer++;
			String sql = "insert into Customer (firstNameCustomer, lastNameCustomer,phoneNumberCustomer,emailCustomer,barCode) " +"values('"+ customer.getFirstNameUser() + "','"+ customer.getLastNameUser() + "','"+ customer.getPhoneNumberUser() + "','"+ customer.getEmailUser() + "','"+ customer.createBarCode(idCustomer) + "')";
			statement.executeUpdate(sql);
			
			String sqlCard = "insert into card (barCode,idCustomer,credit) " +"values('"+ customer.createBarCode(idCustomer) + "','"+ idCustomer + "',0)";
			statement.executeUpdate(sqlCard);
			//System.out.println("New Customer has been succefully added");
			b = true;
			statement.close();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return b;
	}
	
    public boolean deleteCustomerById(int idCustomerToDelete)
    {
		boolean b = false;
		try 
		{
			Statement statement = utilJdbc.dataBaseConnetion().createStatement();
        	String sql = "Delete from customer where idCustomer='" + idCustomerToDelete + "'";
        	statement.executeUpdate(sql);
			System.out.println("The Customer has been deleted correctly");
			b = true;
			statement.close();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return b;
	}

    public void fillAllCustomer()
    {
        try 
        {
        	Statement statement = utilJdbc.dataBaseConnetion().createStatement();
        	String sql = "select * from customer ";
        	ResultSet resultSet = statement.executeQuery(sql);
        	while (resultSet.next()) 
        	{
        		listCustomersIndex.add(resultSet.getString(1));
        		listCustomers.add(new Customer(resultSet.getString(2) ,resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6)));
        	}	
        	statement.close();
        }
        catch (SQLException e) 
        {
        	e.printStackTrace();
        }
    }
    
    public void UpdateCustomerDao(Customer customer, int idCustomerToUpdate)
    {
    	try
    	{
    		Statement statement = utilJdbc.dataBaseConnetion().createStatement();   	           
    		String sql = "update customer set firstNameCustomer='"+ customer.getFirstNameUser() + "',lastNameCustomer='"+ customer.getLastNameUser() + "',phoneNumberCustomer='"+ customer.getPhoneNumberUser() + "',emailCustomer='"+ customer.getEmailUser() + "'  where idCustomer='"+ idCustomerToUpdate + "'  ";
    		statement.executeUpdate(sql);
    	}
    	catch (SQLException e) 
        {
        	e.printStackTrace();
        }
    }
    
 
	public List<Customer> getListCustomers() 
	{
		return listCustomers;
	}

	public List<String> getListCustomersIndex()
	{
		return listCustomersIndex;
	}
}
