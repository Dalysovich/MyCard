package tn.edu.espritCs.myCard.domain;

public class User {
	private int idUser;
	 private String firstNameUser;
	 private String lastNameUser;
	 private String phoneNumberUser;
	 private String emailUser;
	 
	 
	 public User() {
			// TODO Auto-generated constructor stub
		}
	 

	public User(String firstNameUser, String lastNameUser,
			String phoneNumberUser, String emailUser) {
		super();
		this.firstNameUser = firstNameUser;
		this.lastNameUser = lastNameUser;
		this.phoneNumberUser = phoneNumberUser;
		this.emailUser = emailUser;
	}

	

	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getFirstNameUser() {
		return firstNameUser;
	}
	public void setFirstNameUser(String firstNameUser) {
		this.firstNameUser = firstNameUser;
	}
	public String getLastNameUser() {
		return lastNameUser;
	}
	public void setLastNameUser(String lastNameUser) {
		this.lastNameUser = lastNameUser;
	}
	public String getPhoneNumberUser() {
		return phoneNumberUser;
	}
	public void setPhoneNumberUser(String phoneNumberUser) {
		this.phoneNumberUser = phoneNumberUser;
	}
	public String getEmailUser() {
		return emailUser;
	}
	public void setEmailUser(String emailUser) {
		this.emailUser = emailUser;
	}

	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", firstNameUser=" + firstNameUser
				+ ", lastNameUser=" + lastNameUser + ", phoneNumberUser="
				+ phoneNumberUser + ", emailUser=" + emailUser + "]";
	}
 

}
