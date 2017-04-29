package co.md.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.md.exception.ServiceException;
import co.md.model.base_entity.Campaign;
import co.md.repository.base.CampaignRepository;

@Service
@Transactional("baseTransactionManager")
public class CampaignServiceImpl implements CampaignService {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CampaignRepository campaignRepository;

	@Override
	public Campaign findByCampaignId(Long campaignId) throws ServiceException {
		Campaign campaign = campaignRepository.findOne(campaignId);
		if (campaign == null) {
			LOG.error(" Data not found. ");
			throw new ServiceException(" Data not found. ");
		}
		return campaign;
	}

	@Override
	public Campaign saveCampaign(Campaign campaign) throws ServiceException {
		try {
			campaign = campaignRepository.save(campaign);
		}
		catch (RuntimeException e) {
			LOG.error("Unable to save data: " + e.getMessage());
			throw new ServiceException(e.getCause());
		}
		return campaign;
	}

}
