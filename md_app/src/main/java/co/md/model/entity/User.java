package co.md.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	
	@Column(name="campaign_id")
	private long campaignId;
	
	@Column(name="campaign_name")
	private String campaignName;
	
	public User() {}
	
	public User(String name) {
		this.name = name;
	}
	
	public long getCampaignId() {
		return campaignId;
	}

	public void setCampaignId(long campaignId) {
		this.campaignId = campaignId;
	}
	
	public String getCampaignName() {
		return campaignName;
	}

	public void setCampaignName(String string) {
		this.campaignName = string;
	}

	public long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
