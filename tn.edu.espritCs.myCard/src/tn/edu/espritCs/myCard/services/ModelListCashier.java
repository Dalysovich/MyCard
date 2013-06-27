package tn.edu.espritCs.myCard.services;

import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.*;

import tn.edu.espritCs.myCard.dao.CashierDao;
import tn.edu.espritCs.myCard.dao.UserDao;
import tn.edu.espritCs.myCard.domain.Cashier;
import tn.edu.espritCs.myCard.technical.UtilJdbc;


public class ModelListCashier extends AbstractTableModel 
{
	{
		CashierDao cashierDao = new CashierDao();
        cashierDao.fillAllCashiers();
	}
	//private UtilJdbc utilJdbc = new UtilJdbc();
	private CashierDao cashierDao = new CashierDao();
	//private final List<Cashier> cashiers; 
	//private final List<String> cashiersIndex; 
    private final String[] entetes = {"First Name", "Last Name", "Phone Number", "Email", "Login", "Password"};
  
    
    public ModelListCashier() 
    {
        super();
        cashierDao.fillAllCashiers();
      //  cashiers = new ArrayList<Cashier>(cashierDao.getListCashiers());
      //  cashiersIndex = new ArrayList<>(cashierDao.getListCashiersIndex());
        
    }
 
    public int getRowCount() 
    {
        return cashierDao.getListCashiers().size();
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
                return cashierDao.getListCashiers().get(rowIndex).getFirstNameUser();
            case 1:
                return cashierDao.getListCashiers().get(rowIndex).getLastNameUser();
            case 2:
                return cashierDao.getListCashiers().get(rowIndex).getPhoneNumberUser();
            case 3:
                return cashierDao.getListCashiers().get(rowIndex).getEmailUser();
            case 4:
                return cashierDao.getListCashiers().get(rowIndex).getLogin();
            case 5:
                return cashierDao.getListCashiers().get(rowIndex).getPwd();
            default:
                return null; 
        }
    }
 
    public void removeCashier(int rowIndex) 
    {
    	cashierDao.getListCashiers().remove(rowIndex);
        fireTableRowsDeleted(rowIndex, rowIndex);
        Integer idUserToDelete=Integer.parseInt((cashierDao.getListCashiersIndex().get(rowIndex)));
        System.out.println("The Id of the Cashier to remove : "+idUserToDelete);
        try
        {
        	cashierDao.deleteCashierById(idUserToDelete);
        }
        catch (Exception e)
        { 
        	e.printStackTrace();
        }
    }	
}