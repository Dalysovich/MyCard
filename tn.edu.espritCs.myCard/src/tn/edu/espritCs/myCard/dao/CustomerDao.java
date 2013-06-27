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
		try 
		{
			Statement statement = utilJdbc.dataBaseConnetion().createStatement();
			String sql = "insert into Customer (firstNameCustomer, lastNameCustomer,phoneNumberCustomer,emailCustomer) " +"values('"+ customer.getFirstNameUser() + "','"+ customer.getLastNameUser() + "','"+ customer.getPhoneNumberUser() + "','"+ customer.getEmailUser() + "')";
			statement.executeUpdate(sql);
			System.out.println("New Customer has been succefully added");
			b = true;
			statement.close();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return b;
	}
	
    public boolean deleteCustomerById(int idUserToDelete)
    {
		boolean b = false;
		try 
		{
			Statement statement = utilJdbc.dataBaseConnetion().createStatement();
        	String sql = "Delete from customer where idCustomer='" + idUserToDelete + "'";
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

    public void fillAllCashiers()
    {
        try 
        {
        	Statement statement = utilJdbc.dataBaseConnetion().createStatement();
        	String sql = "select * from customer ";
        	ResultSet resultSet = statement.executeQuery(sql);
        	while (resultSet.next()) 
        	{
        		listCustomersIndex.add(resultSet.getString(1));
        		listCustomers.add(new Customer(resultSet.getString(2) ,resultSet.getString(3),resultSet.getString(4),resultSet.getString(5)));
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
    		String sql = "update customer set firstNameCustomer='"+ customer.getFirstNameUser() + "',lastNameCustomer='"+ customer.getLastNameUser() + "',phoneNumberCustomer='"+ customer.getPhoneNumberUser() + "',emailCustomer='"+ customer.getEmailUser() + "',login='" + "'  where idCustomer='"+ idCustomerToUpdate + "'  ";
    		statement.executeUpdate(sql);
    	}
    	catch (SQLException e) 
        {
        	e.printStackTrace();
        }
    }
    
 
	public List<Customer> getListCashiers() 
	{
		return listCustomers;
	}

	public List<String> getListCashiersIndex()
	{
		return listCustomersIndex;
	}
}
