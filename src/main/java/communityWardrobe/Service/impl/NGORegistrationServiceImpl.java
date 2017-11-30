package communityWardrobe.Service.impl;

import communityWardrobe.Controller.model.DonationDTO;
import communityWardrobe.Controller.model.NGORegistrationDTO;
import communityWardrobe.Service.DonationService;
import communityWardrobe.Service.NGORegistrationService;
import communityWardrobe.dataAccess.DonationRepository;
import communityWardrobe.dataAccess.DonatorRepository;
import communityWardrobe.dataAccess.NGORepository;
import communityWardrobe.dataAccess.model.DonationEntity;
import communityWardrobe.dataAccess.model.DonatorEntity;
import communityWardrobe.dataAccess.model.NGOEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class NGORegistrationServiceImpl implements NGORegistrationService{

	@Autowired
	private NGORepository ngoRepository;



  @Override
  public NGORegistrationDTO getNGORegistration(String ngoUserId) {
    NGORegistrationDTO ngoRegistrationDTO = new NGORegistrationDTO();
    NGOEntity ngoEntity = ngoRepository.findByNGOUserId(ngoUserId);
    if(ngoEntity != null){
      ngoRegistrationDTO.setCert80GNo(ngoEntity.getCert80GNo());
      ngoRegistrationDTO.setCert80G(ngoEntity.isCert80G());
      ngoRegistrationDTO.setName(ngoEntity.getName());
      ngoRegistrationDTO.setEmail(ngoEntity.getEmail());
      ngoRegistrationDTO.setAddress(ngoEntity.getAddress());
      ngoRegistrationDTO.setPhone(ngoEntity.getPhone());
      ngoRegistrationDTO.setDocUploaded(ngoEntity.isDocUploaded());
      ngoRegistrationDTO.setPptUploaded(ngoEntity.isPptUploaded());
      ngoRegistrationDTO.setNoYearsOfReg(ngoEntity.getNoOfYearOFReg());

      return ngoRegistrationDTO;

    }
    return null;
  }

  @Override
	public void registerNGO(NGORegistrationDTO ngoRegistrationDTO) {


		NGOEntity ngoEntity = new NGOEntity();
		ngoEntity.setCert80GNo(ngoRegistrationDTO.getCert80GNo());
		ngoEntity.setCert80G(ngoRegistrationDTO.getCert80G());
		ngoEntity.setName(ngoRegistrationDTO.getName());
		ngoEntity.setEmail(ngoRegistrationDTO.getEmail());
		ngoEntity.setAddress(ngoRegistrationDTO.getAddress());
		ngoEntity.setPhone(ngoRegistrationDTO.getPhone());
		ngoEntity.setDocUploaded(ngoRegistrationDTO.getDocUploaded());
		ngoEntity.setPptUploaded(ngoRegistrationDTO.getPptUploaded());
		ngoEntity.setNoOfYearOFReg(ngoRegistrationDTO.getNoYearsOfReg());

		ngoRepository.save(ngoEntity);
	}
}