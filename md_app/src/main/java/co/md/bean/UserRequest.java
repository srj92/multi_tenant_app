package co.md.bean;

import javax.validation.constraints.NotNull;

public class UserRequest {

	@NotNull
	private String name;
	@NotNull
	private long campaignId;
	
	public UserRequest() {
		super();
	}

	public UserRequest(String name) {
		this.name = name;
	}
	
	public long getCampaignId() {
		return campaignId;
	}

	public void setCampaignId(long campaignId) {
		this.campaignId = campaignId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
