package co.md.service;

import co.md.exception.ServiceException;
import co.md.model.base_entity.Campaign;

public interface CampaignService {

	
	Campaign findByCampaignId(Long campaignId) throws ServiceException;

	Campaign saveCampaign(Campaign campaign) throws ServiceException;

}
