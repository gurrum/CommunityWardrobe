package communityWardrobe.dataAccess;

import communityWardrobe.dataAccess.model.DonatorEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public interface DonatorRepository extends CrudRepository<DonatorEntity, Integer> {

	DonatorEntity findDonatorEntityByEmail(String emailId);
}