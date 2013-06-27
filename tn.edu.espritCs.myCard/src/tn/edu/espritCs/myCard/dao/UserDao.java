package tn.edu.espritCs.myCard.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import tn.edu.espritCs.myCard.domain.Admin;
import tn.edu.espritCs.myCard.domain.User;
import tn.edu.espritCs.myCard.technical.UtilJdbc;

public class UserDao
{
	private UtilJdbc utilJdbc = new UtilJdbc();

	public boolean addAdmin(Admin admin) 
	{
		boolean b = false;
		try 
		{
			Statement statement = utilJdbc.dataBaseConnetion().createStatement();
			String sql = "insert into admin (firstNameAdmin, lastNameAdmin,phoneNumberAdmin,emailAdmin,login,pwd) " +"values('"+ admin.getFirstNameUser() + "','"+ admin.getLastNameUser() + "','"+ admin.getPhoneNumberUser() + "','"+ admin.getEmailUser() + "','"+ admin.getLogin() + "','"+ admin.getPwd() + "')";
			statement.executeUpdate(sql);
			System.out.println("Nouveau administrateur a été ajouté ...");
			b = true;
		} 
		catch (SQLException e1) 
		{
			e1.printStackTrace();
		}
		return b;
	}


	public Admin findAdminById(int idAdmin) {
		Admin adminTMP = new Admin();
		try {
			Statement statement = utilJdbc.dataBaseConnetion().createStatement();
			String sql = "select * from admin where idAdmin=" + idAdmin;
			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) 
			{
				adminTMP.setIdUser(resultSet.getInt("idAdmin"));
				adminTMP.setFirstNameUser(resultSet.getString("firstNameAdmin"));
				adminTMP.setLastNameUser(resultSet.getString("lastNameAdmin"));
				adminTMP.setPhoneNumberUser(resultSet.getString("phoneNumberAdmin"));
				adminTMP.setEmailUser(resultSet.getString("emailAdmin"));
				adminTMP.setLogin(resultSet.getString("login"));
				adminTMP.setPwd(resultSet.getString("pwd"));
				System.out.println("l9inah hakel user ...");
				System.out.println(adminTMP);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return adminTMP;
	}
	
	
	

	

	/*public boolean updateUser(User user) {
		boolean b = false;
		try {
			Statement statement = utilJdbc.hetliConnetionMrigla()
					.createStatement();
			String sql = "update user set firstNameUser='"
					+ user.getFirstNameUser() + "' where idUser="
					+ user.getIdUser();
			statement.executeUpdate(sql);
			System.out.println("youppy user modified ...");
			b = true;
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return b;
	}

*/
}
