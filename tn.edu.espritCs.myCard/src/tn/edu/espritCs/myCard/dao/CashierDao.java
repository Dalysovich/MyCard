package tn.edu.espritCs.myCard.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import tn.edu.espritCs.myCard.domain.Cashier;
import tn.edu.espritCs.myCard.gui.ListCashier;
import tn.edu.espritCs.myCard.technical.UtilJdbc;

public class CashierDao
{
	UtilJdbc utilJdbc = new UtilJdbc();
	private final List<Cashier> listCashiers = new ArrayList<Cashier>();
	private final List<String> listCashiersIndex = new ArrayList<>();
	
	
	public boolean addCashier(Cashier cashier) 
	{
		boolean b = false;
		try 
		{
			Statement statement = utilJdbc.dataBaseConnetion().createStatement();
			String sql = "insert into cashier (firstNameCashier, lastNameCashier,phoneNumberCashier,emailCashier,login,pwd) " +"values('"+ cashier.getFirstNameUser() + "','"+ cashier.getLastNameUser() + "','"+ cashier.getPhoneNumberUser() + "','"+ cashier.getEmailUser() + "','"+ cashier.getLogin() + "','"+ cashier.getPwd() + "')";
			statement.executeUpdate(sql);
			System.out.println("New Cashier has been succefully added");
			b = true;
			statement.close();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return b;
	}
	
    public boolean deleteCashierById(int idUserToDelete)
    {
		boolean b = false;
		try 
		{
			Statement statement = utilJdbc.dataBaseConnetion().createStatement();
        	String sql = "Delete from cashier where idCashier='" + idUserToDelete + "'";
        	statement.executeUpdate(sql);
			System.out.println("The User has been deleted correctly");
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
        	String sql = "select * from cashier ";
        	ResultSet resultSet = statement.executeQuery(sql);
        	while (resultSet.next()) 
        	{
        		listCashiersIndex.add(resultSet.getString(1));
        		listCashiers.add(new Cashier(resultSet.getString(2) ,resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6),resultSet.getString(7)));
        	}	
        	statement.close();
        }
        catch (SQLException e) 
        {
        	e.printStackTrace();
        }
    }
    
    public void UpdateCashierDao(Cashier cashier, int idCashierToUpdate)
    {
    	try
    	{
    		Statement statement = utilJdbc.dataBaseConnetion().createStatement();   	           
    		String sql = "update cashier set firstNameCashier='"+ cashier.getFirstNameUser() + "',lastNameCashier='"+ cashier.getLastNameUser() + "',phoneNumberCashier='"+ cashier.getPhoneNumberUser() + "',emailCashier='"+ cashier.getEmailUser() + "',login='"+ cashier.getLogin() + "',pwd='"+ cashier.getPwd() + "'  where idCashier='"+ idCashierToUpdate + "'  ";
    		statement.executeUpdate(sql);
    	}
    	catch (SQLException e) 
        {
        	e.printStackTrace();
        }
    }
    
 
	public List<Cashier> getListCashiers() 
	{
		return listCashiers;
	}

	public List<String> getListCashiersIndex()
	{
		return listCashiersIndex;
	}
}
