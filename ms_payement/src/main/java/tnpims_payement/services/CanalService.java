package tnpims_payement.services;

import org.springframework.stereotype.Service;
import tnpims_payement.entities.Canal;
import tnpims_payement.repositories.CanalRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CanalService {

    private final CanalRepository canalRepository;

    public CanalService(CanalRepository canalRepository) {
        this.canalRepository = canalRepository;
    }

    public List<Canal> getAllCanals() {
        return canalRepository.findAll();
    }

    public Optional<Canal> getCanalById(Long id) {
        return canalRepository.findById(id);
    }

    public Canal saveCanal(Canal canal) {
        return canalRepository.save(canal);
    }

    public Optional<Canal> updateCanal(Long id, Canal updatedCanal) {
        return canalRepository.findById(id).map(existingCanal -> {
            existingCanal.setLibelle(updatedCanal.getLibelle());
            existingCanal.setCode(updatedCanal.getCode());
            existingCanal.setPort(updatedCanal.getPort());
            existingCanal.setIp(updatedCanal.getIp());
            return canalRepository.save(existingCanal);
        });
    }

    public boolean deleteCanal(Long id) {
        if (canalRepository.existsById(id)) {
            canalRepository.deleteById(id);
            return true;
        }
        return false;
    }
}