package tn.pi.customerservice.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.pi.customerservice.Entities.Customer;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByFirstName(String firstName);
}