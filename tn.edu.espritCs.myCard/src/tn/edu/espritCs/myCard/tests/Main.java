package tn.edu.espritCs.myCard.tests;

import junit.framework.Assert;

import org.junit.Test;

import tn.edu.espritCs.myCard.dao.UserDao;
import tn.edu.espritCs.myCard.domain.Admin;
//import tn.edu.espritCs.funTime.services.LoginService;
import tn.edu.espritCs.myCard.technical.UtilJdbc;

public class Main {
	private UserDao userDao = new UserDao();

	@Test
	public void testAddUser() {
		Admin admin = new Admin("Ali", "ben salah", "198", "salah@bensalah.com","admin","admin");
		Assert.assertTrue(userDao.addAdmin(admin));
	}

	@Test
	public void testFindUserById() {
		Admin admin = userDao.findAdminById(1);
		//Assert.assertEquals("Ali", admin.getFirstNameUser());
	}
	
}
