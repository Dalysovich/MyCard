package tn.edu.espritCs.myCard.domain;

public class Offers {

	private int idOffers;
	private int minCredit;
	private float discount;
	
	public Offers(int idOffers, int minCredit, float discount) {
		super();
		this.idOffers = idOffers;
		this.minCredit = minCredit;
		this.discount = discount;
	}

	public int getIdOffers() {
		return idOffers;
	}

	public void setIdOffers(int idOffers) {
		this.idOffers = idOffers;
	}

	public int getMinCredit() {
		return minCredit;
	}

	public void setMinCredit(int minCredit) {
		this.minCredit = minCredit;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}
	
	
}
