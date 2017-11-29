package communityWardrobe.Service;

import communityWardrobe.Controller.model.DonationDTO;

public interface DonationService {

	DonationDTO getDonation(String donationId);

	void createDonation(DonationDTO donationDTO);

}
