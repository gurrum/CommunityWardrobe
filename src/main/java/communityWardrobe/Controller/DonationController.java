package communityWardrobe.Controller;

import communityWardrobe.Controller.model.DonationDTO;
import communityWardrobe.Service.DonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableAutoConfiguration
public class DonationController {

	@Autowired
	private DonationService donationService;

	@RequestMapping(value = "/donation", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<DonationDTO> getDonation(@RequestParam String donationId) {
		DonationDTO response = donationService.getDonation(donationId);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/donations", method = RequestMethod.POST)
	public ResponseEntity createDonation(@RequestBody DonationDTO donation){

		donationService.createDonation(donation);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(headers, HttpStatus.ACCEPTED);
	}
}
