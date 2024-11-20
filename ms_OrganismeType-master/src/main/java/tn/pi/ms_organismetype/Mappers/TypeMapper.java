package tn.pi.ms_organismetype.Mappers;

import org.springframework.stereotype.Component;
import tn.pi.ms_organismetype.DTO.TypeDTO;
import tn.pi.ms_organismetype.Entities.Type;

@Component
public class TypeMapper {

    public TypeDTO toDTO(Type type) {
        TypeDTO dto = new TypeDTO();
        dto.setId(type.getId());
        dto.setCodeOrg(type.getCodeOrg());
        dto.setTypeRecherche(type.getTypeRecherche());
        dto.setCleMax(type.getCleMax());
        dto.setCleMin(type.getCleMin());
        dto.setCleType(type.getCleType());
        return dto;
    }

    public Type toEntity(TypeDTO dto) {
        Type type = new Type();
        type.setId(dto.getId());
        type.setCodeOrg(dto.getCodeOrg());
        type.setTypeRecherche(dto.getTypeRecherche());
        type.setCleMax(dto.getCleMax());
        type.setCleMin(dto.getCleMin());
        type.setCleType(dto.getCleType());
        return type;
    }
}

