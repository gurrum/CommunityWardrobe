package communityWardrobe.Service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import communityWardrobe.Controller.model.InventoryDTO;
import communityWardrobe.Controller.model.InventoryDetailsDTO;
import communityWardrobe.Controller.model.InventoryResponseDTO;
import communityWardrobe.Service.InventoryService;
import communityWardrobe.dataAccess.InventoryRepository;
import communityWardrobe.dataAccess.model.InventoryEntity;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class InventoryServiceImpl implements InventoryService{

	@Autowired
	private InventoryRepository inventoryRepository;
	
	@Override
	public InventoryResponseDTO getInventoryResponse() {
		InventoryResponseDTO response = new InventoryResponseDTO();
		List<InventoryDTO> listOfInventory = new ArrayList<>();
		List<String> categories = inventoryRepository.findDistinctCategory();
		for (String category : categories) {
			InventoryDTO inventory = new InventoryDTO();
			inventory.setCategory(category);
			inventory.setDetails(getInventoryDTOForCategory(category));
			listOfInventory.add(inventory);
		}
		if (!listOfInventory.isEmpty()) {
			response.setInventory(listOfInventory);
		}
		return (!listOfInventory.isEmpty()) ? response : null;

	}

	private List<InventoryDetailsDTO> getInventoryDTOForCategory(String category) {
		List<InventoryDetailsDTO> inventories = new ArrayList<>();
		List<InventoryEntity> inventoryEntities = inventoryRepository.findByCategory(category);
		for (InventoryEntity inventoryEntity : inventoryEntities) {
			inventories.add(new InventoryDetailsDTO(inventoryEntity));
		}
		return (!inventories.isEmpty()) ? inventories : null;
	}
}
