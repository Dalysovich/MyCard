package tn.edu.espritCs.myCard.domain;

public class Customer extends User{
	
	private String barCode;

	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(String firstNameUser, String lastNameUser,
			String phoneNumberUser, String emailUser,String barCode) {
		super(firstNameUser, lastNameUser, phoneNumberUser, emailUser);
		this.barCode = barCode;
	}

	public Customer(String firstNameUser, String lastNameUser,
			String phoneNumberUser, String emailUser) {
		super(firstNameUser, lastNameUser, phoneNumberUser, emailUser);
		
		// TODO Auto-generated constructor stub
	}
	
	public String createBarCode (int maxId)
	{
		this.barCode = "0000" + "XXX"+ maxId;
		return(this.barCode);
	}

	public String getBarCode() {
		return barCode;
	}

	
}
