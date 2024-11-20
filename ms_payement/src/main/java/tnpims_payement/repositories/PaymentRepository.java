package tnpims_payement.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import tnpims_payement.entities.Payement;

public interface PaymentRepository extends JpaRepository<Payement, Long> {
}
