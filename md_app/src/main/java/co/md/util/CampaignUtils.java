package co.md.util;

import co.md.bean.CampaignRequest;
import co.md.bean.CampaignResponse;
import co.md.model.base_entity.Campaign;

public class CampaignUtils {

	public static Campaign fromWebToDomain(CampaignRequest campaignRequest) {
		Campaign campaign = new Campaign();
		campaign.setName(campaignRequest.getName());
		return campaign;
	}

	public static CampaignResponse fromDomainToWeb(Campaign campaign) {
		CampaignResponse campaignResponse = new CampaignResponse();
		campaignResponse.setId(campaign.getId());
		campaignResponse.setName(campaign.getName());
		return campaignResponse;
	}

}
