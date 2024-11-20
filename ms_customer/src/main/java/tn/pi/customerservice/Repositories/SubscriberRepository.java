
package tn.pi.customerservice.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.pi.customerservice.Entities.Subscriber;

public interface SubscriberRepository extends JpaRepository<Subscriber, Long> {
}
