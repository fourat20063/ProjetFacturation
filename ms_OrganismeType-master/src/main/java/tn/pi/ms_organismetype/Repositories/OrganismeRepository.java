package tn.pi.ms_organismetype.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.pi.ms_organismetype.Entities.Organisme;

import java.util.Optional;

public interface OrganismeRepository extends JpaRepository<Organisme, Long> {
    Optional<Organisme> findByNom(String nom); // Example method for finding by "nom"
}
