package communityWardrobe.Service.impl;

import communityWardrobe.Controller.model.DonationDTO;
import communityWardrobe.Service.DonationService;
import communityWardrobe.dataAccess.DonationRepository;
import communityWardrobe.dataAccess.model.DonationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class DonationServiceImpl implements DonationService{

	@Autowired
	private DonationRepository donationRepository;
	
	@Override
	public DonationDTO getDonation(String donationId){

		DonationDTO donation = new DonationDTO();
		DonationEntity donationEntity =  donationRepository.findByDonationId(donationId);

		donation.setDonationId(donationEntity.getDonationId());
		donation.setDonatorName(donationEntity.getDonator().getDonatorName());
		donation.setPickupDate(donationEntity.getDate());
		donation.setPickupTimeSlot(donationEntity.getTimeSlot());

		return donation;

	}
}