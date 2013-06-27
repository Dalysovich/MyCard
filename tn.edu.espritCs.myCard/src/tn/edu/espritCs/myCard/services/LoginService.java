package tn.edu.espritCs.myCard.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import tn.edu.espritCs.myCard.technical.UtilJdbc;

public class LoginService
{
	UtilJdbc utilJdbc = new UtilJdbc();
	Connection connection = utilJdbc.dataBaseConnetion();

	public boolean loginAdmin(String login, String password) {
		boolean b = false;
		try {
			Statement statement = connection.createStatement();
			String sql = "select * from admin where login='" + login
					+ "' and pwd ='" + password + "' ";
			//System.out.println(sql);
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				//System.out.println("l9inah ...");
				b = true;
			}
		} catch (Exception e) {

		}
		return b;
	}
	
	
	public boolean loginCashier(String login, String password) {
		boolean a = false;
		try {
			Statement statement = connection.createStatement();
			String sql = "select * from cashier where login='" + login
					+ "' and pwd ='" + password + "' ";
			//System.out.println(sql);
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				//System.out.println("l9inah ...");
				a = true;
			}
		} catch (Exception e) {

		}
		return a;
	}

}
