package communityWardrobe.Controller.model;

import java.util.Date;

public class DonationDTO {

	private int donationId;

	private String donatorEmail;

	private String quantity;

	private String state;

	private Date pickupDate;

	private String pickupTimeSlot;

	public int getDonationId() {
		return donationId;
	}

	public void setDonationId(int donationId) {
		this.donationId = donationId;
	}

	public String getDonatorEmail() {
		return donatorEmail;
	}

	public void setDonatorEmail(String donatorEmail) {
		this.donatorEmail = donatorEmail;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Date getPickupDate() {
		return pickupDate;
	}

	public void setPickupDate(Date pickupDate) {
		this.pickupDate = pickupDate;
	}

	public String getPickupTimeSlot() {
		return pickupTimeSlot;
	}

	public void setPickupTimeSlot(String pickupTimeSlot) {
		this.pickupTimeSlot = pickupTimeSlot;
	}
}
