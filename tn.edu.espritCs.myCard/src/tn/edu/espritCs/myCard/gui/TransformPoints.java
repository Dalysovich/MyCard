package tn.edu.espritCs.myCard.gui;

import java.awt.*;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import tn.edu.espritCs.myCard.services.LoginService;
import tn.edu.espritCs.myCard.technical.UtilJdbc;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.Statement;

public class TransformPoints extends JFrame{
	private JPanel contentPane;
	private JTextField textFieldBarCode;
	private JLabel lblPoint; 
	private JLabel lblSolde;
	UtilJdbc utilJdbc = new UtilJdbc();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TransformPoints frame = new TransformPoints();
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
	public TransformPoints() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		textFieldBarCode = new JTextField();
		textFieldBarCode.setColumns(10);
		
		
		
		JLabel lblCode = new JLabel("Scan your bar code");
		
		
		
		lblPoint = new JLabel();
		
		lblPoint.setForeground(Color.blue);
		lblPoint.setVisible(false);
		
		

		lblSolde = new JLabel();
		
		lblSolde.setForeground(Color.blue);
		lblSolde.setVisible(false);
	
		JButton btnNewButton = new JButton("Transform");
		textFieldBarCode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Consult();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Statement statement = utilJdbc.dataBaseConnetion().createStatement();
					String sqlCredit = "update card set credit=0 where barCode='"+ textFieldBarCode.getText() + "'  ";
					statement.executeUpdate(sqlCredit);
					
				} catch (Exception e) {
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
							.addComponent(lblCode)
							.addGap(63))
						
							
							.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblPoint)							
							.addGap(35))
							
							.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblSolde)							
							.addGap(35))
							)
					
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						
						.addComponent(textFieldBarCode, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
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
						.addComponent(textFieldBarCode, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCode))
					.addGap(18)
				
					
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldBarCode, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPoint))
					.addGap(20)
					
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldBarCode, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSolde))
					.addGap(20)
					
					.addComponent(btnNewButton)
					.addContainerGap(48, Short.MAX_VALUE))
		);
		
		contentPane.setLayout(gl_contentPane);
	}
	
	
	public void Consult()
    {	
		try{
	String barCode=null;
	Integer oldCredit=0;
	boolean x=false;
	Statement statement = utilJdbc.dataBaseConnetion().createStatement();

	String sql = "select * from card";
	ResultSet resultSet = statement.executeQuery(sql);
	//resultSet.first();
	while(resultSet.next())
	{
	
	if(textFieldBarCode.getText().equals(resultSet.getString(2)))
	{
	x=true;
	barCode = resultSet.getString(2);	
	oldCredit = Integer.parseInt(resultSet.getString(4));
	}
	}
	
	
	if(x)
	{
		Integer newCredit=oldCredit+50;
		String sqlCredit = "update card set credit='"+ newCredit + "' where barCode='"+ barCode + "'  ";
		statement.executeUpdate(sqlCredit);
		
		String sqlCode = "select firstNameCustomer,lastNameCustomer,credit from card c,customer u where c.idCustomer=u.idCustomer and c.barCode='" + barCode + "'";
		ResultSet resultSetCode = statement.executeQuery(sqlCode);
		resultSetCode.first();
		lblPoint.setText("" + resultSetCode.getString(1) +" "+ resultSetCode.getString(2)+" has accumulated "+ resultSetCode.getString(3)+" points");
		lblPoint.setVisible(true);
			int credit=Integer.parseInt(resultSetCode.getString(3));
			
			String sqlOffers = "select * from offers";
			ResultSet resultSetOffers = statement.executeQuery(sqlOffers);
			resultSetOffers.first();
			
			
			int pointNumber=Integer.parseInt(resultSetOffers.getString(2));
			int discount=Integer.parseInt(resultSetOffers.getString(3));
			float solde=(credit/pointNumber)*discount;
			lblSolde.setText("Your credit: "+ solde+" DT");
			lblSolde.setVisible(true);
	
	}
    
    }catch (Exception e) {
		e.printStackTrace();
	}
    }
}
