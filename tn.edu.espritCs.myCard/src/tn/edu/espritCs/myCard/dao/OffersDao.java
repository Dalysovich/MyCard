package tn.edu.espritCs.myCard.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import tn.edu.espritCs.myCard.domain.Offers;
import tn.edu.espritCs.myCard.gui.ListCashier;
import tn.edu.espritCs.myCard.technical.UtilJdbc;

public class OffersDao
{
	UtilJdbc utilJdbc = new UtilJdbc();

	public boolean addOffers(Offers offers) 
	{
		boolean b = false;
		try 
		{
			Statement statement = utilJdbc.dataBaseConnetion().createStatement();
			String sql = "insert into offers (pointNumber, discount) " +"values('"+ offers.getPointNumber() + "','"+ offers.getDiscount()+ "')";
			statement.executeUpdate(sql);
		
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



	public boolean updateOffers(Offers offers) {
		boolean b = false;
		try {
			Statement statement = utilJdbc.dataBaseConnetion().createStatement();
			String sql = "update offers set pointNumber='"+ offers.getPointNumber() + "',discount='"+ offers.getDiscount() + "'";
			statement.executeUpdate(sql);
			b = true;
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return b;
	}
    
}
