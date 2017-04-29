package co.md.util;

import co.md.bean.UserRequest;
import co.md.bean.UserResponse;
import co.md.model.entity.User;

public class UserUtils {

	public static User fromWebToDomain(UserRequest userRequest) {
		User user = new User(userRequest.getName());
		return user;
	}
	
	public static UserResponse fromDomainToWeb(User user) {
		UserResponse userResponse = new UserResponse();
		userResponse.setId(user.getId());
		userResponse.setName(user.getName());
		userResponse.setCampaignId(user.getCampaignId());
		return userResponse;
	} 
}
