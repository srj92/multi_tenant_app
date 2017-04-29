package co.md.repository.other;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.md.model.entity.User;

@Repository
@Transactional(value="transactionManager",readOnly=true)
public interface UserRepository extends CrudRepository<User, Long>{
	List<User> findByName(String name);
}
