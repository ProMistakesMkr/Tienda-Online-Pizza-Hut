package model;

public class Extra {
	private String extraName;
	private int extraPrice;
	
	public Extra(String extraName, int extraPrice) {
		this.extraName = extraName;
		this.extraPrice = extraPrice;
	}

	public String getExtraName() {
		return extraName;
	}

	public int getExtraPrice() {
		return extraPrice;
	}
}
