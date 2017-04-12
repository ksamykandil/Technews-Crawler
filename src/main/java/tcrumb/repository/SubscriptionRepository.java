package tcrumb.repository;

import tcrumb.model.Subscriber;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface SubscriptionRepository extends CrudRepository<Subscriber, String> {
}
