package co.md.service;

import java.util.List;

import co.md.exception.ServiceException;
import co.md.model.entity.User;

public interface UserService {
	
	User saveUser(User user, long campaignId) throws ServiceException;

	User findById(long id, String requestId);
	
	List<User> findAll(String requestId);

}
