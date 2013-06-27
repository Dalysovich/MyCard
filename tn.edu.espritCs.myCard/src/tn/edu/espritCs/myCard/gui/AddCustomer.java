package tn.edu.espritCs.myCard.gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;

import junit.framework.Assert;
import tn.edu.espritCs.myCard.dao.CustomerDao;
import tn.edu.espritCs.myCard.domain.Customer;

public class AddCustomer extends JFrame 
{
	private JPanel contentPane;
	private JTextField textFieldFirstName;
	private JTextField textFieldLastName;
	private JTextField textFieldPhoneNumber;
	private JTextField textFieldEmail;
	//private JTextField textFieldLogin;
	//private JTextField textFieldPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					AddCustomer frame = new AddCustomer();
					frame.setSize(800, 600);
					frame.setVisible(true);
				} 
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddCustomer()
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		textFieldFirstName = new JTextField();
		textFieldFirstName.setColumns(10);

		textFieldLastName = new JTextField();
		textFieldLastName.setColumns(10);

		textFieldPhoneNumber = new JTextField();
		textFieldPhoneNumber.setColumns(10);

		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);

		//textFieldLogin = new JTextField();
		//textFieldLogin.setColumns(10);

		//textFieldPassword = new JTextField();
		//textFieldPassword.setColumns(10);

		JLabel lblFirstName = new JLabel("First Name");

		JLabel lblLastName = new JLabel("Last Name");

		JLabel lblPhoneNumber = new JLabel("Phone Number");

		JLabel lblEmail = new JLabel("Email");

		//JLabel lblLogin= new JLabel("Login");

		//JLabel lblPassword = new JLabel("Password");

		JButton submitFrom = new JButton("Submit Form");

		submitFrom.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				CustomerDao customerDao = new CustomerDao();
				Customer customer = new Customer(textFieldFirstName.getText(), textFieldLastName
						.getText(), textFieldPhoneNumber.getText(), textFieldEmail
						.getText());//, textFieldLogin.getText(), textFieldPassword
						//.getText());
				Assert.assertTrue(customerDao.addCustomer(customer));
			}
		});

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane
				.setHorizontalGroup(gl_contentPane
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_contentPane
										.createSequentialGroup()
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.LEADING,
																false)
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addGap(53)
																		.addComponent(
																				lblFirstName)
																		.addGap(63))
														.addGroup(
																Alignment.TRAILING,
																gl_contentPane
																		.createSequentialGroup()
																		.addContainerGap(
																				GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)
																		.addComponent(
																				lblLastName)
																		.addGap(54))

														.addGroup(
																Alignment.TRAILING,
																gl_contentPane
																		.createSequentialGroup()
																		.addContainerGap(
																				GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)
																		.addComponent(
																				lblPhoneNumber)
																		.addGap(35))

														.addGroup(
																Alignment.TRAILING,
																gl_contentPane
																		.createSequentialGroup()
																		.addContainerGap(
																				GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)
																		.addComponent(
																				lblEmail)
																		.addGap(35))

														/*.addGroup(
																Alignment.TRAILING,
																gl_contentPane
																		.createSequentialGroup()
																		.addContainerGap(
																				GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)
																		.addComponent(
																				lblLogin)
																		.addGap(35))

														.addGroup(
																Alignment.TRAILING,
																gl_contentPane
																		.createSequentialGroup()
																		.addContainerGap(
																				GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)
																		.addComponent(
																				lblPassword)
																		.addGap(35))*/

										)

										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.LEADING)
														/*.addComponent(
																textFieldPassword,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																textFieldLogin,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)*/
														.addComponent(
																textFieldEmail,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																textFieldPhoneNumber,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																textFieldLastName,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																textFieldFirstName,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addContainerGap(176, Short.MAX_VALUE))
						.addGroup(
								Alignment.TRAILING,
								gl_contentPane.createSequentialGroup()
										.addContainerGap(197, Short.MAX_VALUE)
										.addComponent(submitFrom).addGap(138)));
		gl_contentPane
				.setVerticalGroup(gl_contentPane
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_contentPane
										.createSequentialGroup()
										.addGap(82)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																textFieldFirstName,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lblFirstName))
										.addGap(18)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																textFieldLastName,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lblLastName))
										.addGap(41)

										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																textFieldPhoneNumber,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lblPhoneNumber))
										.addGap(20)

										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																textFieldEmail,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lblEmail))
										.addGap(20)

										/*.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																textFieldLogin,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lblLogin))
										.addGap(20)

										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																textFieldPassword,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lblPassword))
										.addGap(20)*/

										.addComponent(submitFrom)
										.addContainerGap(48, Short.MAX_VALUE)));

		contentPane.setLayout(gl_contentPane);
	}
}
