package communityWardrobe.dataAccess;

import communityWardrobe.dataAccess.model.NGOEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public interface NGORepository extends CrudRepository<NGOEntity, Integer> {

	
	NGOEntity findByNGOUserId(String ngoUserId);
}