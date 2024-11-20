package tn.pi.ms_organismetype.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.pi.ms_organismetype.Entities.Type;

import java.util.List;

public interface TypeRepository extends JpaRepository<Type, Long> {
    List<Type> findByCodeOrg(Integer codeOrg); // Example method for finding by "codeOrg"
}
