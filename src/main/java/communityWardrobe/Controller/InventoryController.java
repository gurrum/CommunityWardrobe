package communityWardrobe.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import communityWardrobe.Controller.model.InventoryResponseDTO;
import communityWardrobe.Service.InventoryService;

@RestController
@EnableAutoConfiguration
public class InventoryController {

	@Autowired
	private InventoryService inventoryService;

	@RequestMapping(value = "/inventory", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<InventoryResponseDTO> getClothes() {
		InventoryResponseDTO response = inventoryService.getInventoryResponse();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
