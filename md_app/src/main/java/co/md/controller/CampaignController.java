package co.md.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.md.bean.CampaignRequest;
import co.md.bean.CampaignResponse;
import co.md.model.base_entity.Campaign;
import co.md.service.CampaignService;
import co.md.util.CampaignUtils;

@RestController
@RequestMapping("campaign")
public class CampaignController {

	@Autowired
	private CampaignService campaignService;
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<?> createUser(@RequestBody CampaignRequest campaignRequest, BindingResult bindingResults) {
		if (bindingResults.hasErrors()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		try {
			Campaign campaign = CampaignUtils.fromWebToDomain(campaignRequest);
			campaign = campaignService.saveCampaign(campaign);
			CampaignResponse response = CampaignUtils.fromDomainToWeb(campaign);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
