package tn.edu.espritCs.myCard.domain;

public class Cashier extends User{

	private String login;
	 private String pwd;
	 
	 
	public Cashier(String firstNameUser, String lastNameUser,
			String phoneNumberUser, String emailUser, String login, String pwd) {
		super(firstNameUser, lastNameUser, phoneNumberUser, emailUser);
		this.login = login;
		this.pwd = pwd;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Cashier() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
