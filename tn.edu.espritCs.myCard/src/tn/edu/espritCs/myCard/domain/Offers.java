package tn.edu.espritCs.myCard.domain;

public class Offers {

	private int idOffers;
	private int pointNumber;
	private float discount;
	
	public Offers(int pointNumber, float discount) {
		super();

		this.pointNumber = pointNumber;
		this.discount = discount;
	}

	public int getIdOffers() {
		return idOffers;
	}

	public void setIdOffers(int idOffers) {
		this.idOffers = idOffers;
	}

	

	public int getPointNumber() {
		return pointNumber;
	}

	public void setPointNumber(int pointNumber) {
		this.pointNumber = pointNumber;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}
	
	
}
