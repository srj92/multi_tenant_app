package co.md.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.md.exception.ServiceException;
import co.md.model.base_entity.Campaign;
import co.md.model.entity.User;
import co.md.repository.other.UserRepository;

@Service
@Transactional("transactionManager")
public class UserServiceImpl implements UserService {
	
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CampaignService campaignService;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User saveUser(User user, long campaignId) throws ServiceException {

		try {
			Campaign campaign = campaignService.findByCampaignId(campaignId);
			
			user.setCampaignId(campaign.getId());
			user.setCampaignName(campaign.getName());
			
			user = userRepository.save(user);
			return user;
		} catch (Exception e) {
			LOG.error(e.toString());
			throw new ServiceException(e);
		}
	}

	@Override
	public User findById(long id, String requestId) {
		return userRepository.findOne(id);
	}

	@Override
	public List<User> findAll(String requestId) {
		return (List<User>) userRepository.findAll();
	}

}
