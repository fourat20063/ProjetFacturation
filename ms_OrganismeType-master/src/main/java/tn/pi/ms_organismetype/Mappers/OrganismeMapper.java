package tn.pi.ms_organismetype.Mappers;

import org.springframework.stereotype.Component;
import tn.pi.ms_organismetype.DTO.OrganismeDTO;
import tn.pi.ms_organismetype.Entities.Organisme;

@Component
public class OrganismeMapper {

    public OrganismeDTO toDTO(Organisme organisme) {
        OrganismeDTO dto = new OrganismeDTO();
        dto.setId(organisme.getId());
        dto.setCode(organisme.getCode());
        dto.setNom(organisme.getNom());
        dto.setLogo(organisme.getLogo());
        dto.setDescription(organisme.getDescription());
        return dto;
    }

    public Organisme toEntity(OrganismeDTO dto) {
        Organisme organisme = new Organisme();
        organisme.setId(dto.getId());
        organisme.setCode(dto.getCode());
        organisme.setNom(dto.getNom());
        organisme.setLogo(dto.getLogo());
        organisme.setDescription(dto.getDescription());
        return organisme;
    }
}

