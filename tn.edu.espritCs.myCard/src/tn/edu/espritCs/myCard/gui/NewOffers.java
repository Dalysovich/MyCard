package tn.edu.espritCs.myCard.gui;

import java.awt.*;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import tn.edu.espritCs.myCard.dao.CashierDao;
import tn.edu.espritCs.myCard.dao.OffersDao;
import tn.edu.espritCs.myCard.domain.Cashier;
import tn.edu.espritCs.myCard.domain.Offers;
import tn.edu.espritCs.myCard.services.LoginService;
import tn.edu.espritCs.myCard.technical.UtilJdbc;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.Statement;

import junit.framework.Assert;

public class NewOffers extends JFrame{
	private JPanel contentPane;
	private JTextField textFieldPointNumber;
	private JTextField textFieldDiscount;
	UtilJdbc utilJdbc = new UtilJdbc();
	private JLabel lblError; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					
					NewOffers frame = new NewOffers();
					frame.setSize(400, 400);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NewOffers() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		textFieldPointNumber = new JTextField();
		textFieldPointNumber.setColumns(10);
		
		textFieldDiscount = new JTextField();
		textFieldDiscount.setColumns(10);
		try
		{
		Statement statement = utilJdbc.dataBaseConnetion().createStatement();
		String sql = "select * from offers";
		ResultSet resultSet = statement.executeQuery(sql);
		while (resultSet.next()) 
    	{
			textFieldPointNumber.setText(resultSet.getString(2));
			textFieldDiscount.setText(resultSet.getString(3));
    	}
		}
		catch(Exception e){
			
		}
		JLabel lblLogin = new JLabel("Point Number");
		
		JLabel lblPassword = new JLabel("Discount");
		
		lblError = new JLabel("Please fill the fields");
		
		lblError.setForeground(Color.RED);
		lblError.setVisible(false);
		
		JButton btnNewButton = new JButton("Validate");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int count=0;
					Statement statement = utilJdbc.dataBaseConnetion().createStatement();
					String sql = "select count(*) from offers";
					ResultSet resultSet = statement.executeQuery(sql);
					while (resultSet.next()) 
		        	{
					count=Integer.parseInt(resultSet.getString(1));
		        	}
					
				if("".equals(textFieldPointNumber.getText())||"".equals(textFieldDiscount.getText()))
				{lblError.setVisible(true);}
			else{		
				lblError.setVisible(false);
 				OffersDao offersDao = new OffersDao();
				Offers offers = new Offers(Integer.parseInt(textFieldPointNumber.getText()),Float.parseFloat( textFieldDiscount.getText()));
					if(count==0)
					Assert.assertTrue(offersDao.addOffers(offers));
					else
					{
						Assert.assertTrue(offersDao.updateOffers(offers));
					}
					
			}	
				} catch (Exception e) {
					System.err.println("hoops");
					e.printStackTrace();
				}
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(53)
							.addComponent(lblLogin)
							.addGap(63))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblPassword)							
							.addGap(54))
							
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblError)							
							.addGap(35))	
							)
					
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(textFieldDiscount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldPointNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(176, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(197, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addGap(138))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(82)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldPointNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblLogin))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldDiscount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPassword))
					.addGap(41)
					
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblError))
					.addGap(20)
					
					.addComponent(btnNewButton)
					.addContainerGap(48, Short.MAX_VALUE))
		);
		
		contentPane.setLayout(gl_contentPane);
	}
}
