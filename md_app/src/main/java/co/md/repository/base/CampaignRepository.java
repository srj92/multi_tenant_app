package co.md.repository.base;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.md.model.base_entity.Campaign;

@Repository
@Transactional("baseTransactionManager")
public interface CampaignRepository extends CrudRepository<Campaign, Long> {}
