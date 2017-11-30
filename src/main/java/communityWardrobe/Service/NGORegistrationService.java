package communityWardrobe.Service;

import communityWardrobe.Controller.model.DonationDTO;
import communityWardrobe.Controller.model.NGORegistrationDTO;
import communityWardrobe.dataAccess.model.NGOEntity;

public interface NGORegistrationService {

	NGORegistrationDTO getNGORegistration(String ngoUserId);

	void registerNGO(NGORegistrationDTO ngoRegistrationDTO);

}
