package communityWardrobe.Service.impl;

import communityWardrobe.Controller.model.DonationDTO;
import communityWardrobe.Service.DonationService;
import communityWardrobe.dataAccess.DonationRepository;
import communityWardrobe.dataAccess.DonatorRepository;
import communityWardrobe.dataAccess.model.DonationEntity;
import communityWardrobe.dataAccess.model.DonatorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class DonationServiceImpl implements DonationService{

	@Autowired
	private DonationRepository donationRepository;

	@Autowired
	private DonatorRepository donatorRepository;
	
	@Override
	public DonationDTO getDonation(String donationId){

		DonationDTO donation = new DonationDTO();
		DonationEntity donationEntity =  donationRepository.findByDonationId(donationId);

		donation.setDonationId(donationEntity.getDonationId());
		donation.setDonatorEmail(donationEntity.getDonator().getEmail());
		donation.setPickupDate(donationEntity.getDate());
		donation.setPickupTimeSlot(donationEntity.getTimeSlot());

		return donation;

	}
	@Override
	public void createDonation(DonationDTO donationDTO){

		DonatorEntity donatorEntity = donatorRepository.findDonatorEntityByEmail(donationDTO.getDonatorEmail());

		DonationEntity donationEntity = new DonationEntity();

		donationEntity.setDate(donationDTO.getPickupDate());
		donationEntity.setDonator(donatorEntity);
		donationEntity.setQuantity(donationDTO.getQuantity());
		donationEntity.setState(donationDTO.getState());
		donationEntity.setTimeSlot(donationDTO.getPickupTimeSlot());

		donationRepository.save(donationEntity);

		return;
	}
}