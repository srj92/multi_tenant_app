package co.md.bean;

import javax.validation.constraints.NotNull;

public class CampaignRequest {
	
	@NotNull
	private String name;
	
	public CampaignRequest() {
		super();
	}

	public CampaignRequest(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
