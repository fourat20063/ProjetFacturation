package tn.pi.ms_organismetype.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.pi.ms_organismetype.DTO.OrganismeDTO;
import tn.pi.ms_organismetype.Entities.Organisme;
import tn.pi.ms_organismetype.Exceptions.ResourceNotFoundException;
import tn.pi.ms_organismetype.Mappers.OrganismeMapper;
import tn.pi.ms_organismetype.Repositories.OrganismeRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrganismeService {

    @Autowired
    private OrganismeRepository organismeRepository;

    @Autowired
    private OrganismeMapper organismeMapper;

    public List<OrganismeDTO> getAllOrganismes() {
        return organismeRepository.findAll().stream()
                .map(organismeMapper::toDTO)
                .collect(Collectors.toList());
    }

    public OrganismeDTO getOrganismeById(Long id) {
        Organisme organisme = organismeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Organisme not found with ID: " + id));
        return organismeMapper.toDTO(organisme);
    }

    public OrganismeDTO createOrganisme(OrganismeDTO organismeDTO) {
        Organisme organisme = organismeMapper.toEntity(organismeDTO);
        organisme = organismeRepository.save(organisme);
        return organismeMapper.toDTO(organisme);
    }

    public void deleteOrganisme(Long id) {
        if (!organismeRepository.existsById(id)) {
            throw new ResourceNotFoundException("Organisme not found with ID: " + id);
        }
        organismeRepository.deleteById(id);
    }

    public OrganismeDTO updateOrganisme(Long id, OrganismeDTO organismeDTO) {
        Organisme organisme = organismeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Organisme not found with ID: " + id));

        organisme.setCode(organismeDTO.getCode());
        organisme.setNom(organismeDTO.getNom());
        organisme.setLogo(organismeDTO.getLogo());
        organisme.setDescription(organismeDTO.getDescription());

        organisme = organismeRepository.save(organisme);
        return organismeMapper.toDTO(organisme);
    }
}

