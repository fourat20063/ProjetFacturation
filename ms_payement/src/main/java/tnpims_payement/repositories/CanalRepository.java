package tnpims_payement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tnpims_payement.entities.Canal;

public interface CanalRepository extends JpaRepository<Canal, Long> {
}
