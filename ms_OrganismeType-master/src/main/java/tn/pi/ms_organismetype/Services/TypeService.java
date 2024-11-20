package tn.pi.ms_organismetype.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.pi.ms_organismetype.DTO.TypeDTO;
import tn.pi.ms_organismetype.Entities.Organisme;
import tn.pi.ms_organismetype.Entities.Type;
import tn.pi.ms_organismetype.Exceptions.ResourceNotFoundException;
import tn.pi.ms_organismetype.Mappers.TypeMapper;
import tn.pi.ms_organismetype.Repositories.OrganismeRepository;
import tn.pi.ms_organismetype.Repositories.TypeRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TypeService {

    @Autowired
    private TypeRepository typeRepository;

    @Autowired
    private OrganismeRepository organismeRepository;

    @Autowired
    private TypeMapper typeMapper;

    public List<TypeDTO> getAllTypes() {
        return typeRepository.findAll().stream()
                .map(typeMapper::toDTO)
                .collect(Collectors.toList());
    }

    public TypeDTO getTypeById(Long id) {
        Type type = typeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Type not found with ID: " + id));
        return typeMapper.toDTO(type);
    }

    public TypeDTO createType(TypeDTO typeDTO) {
        Organisme organisme = organismeRepository.findById((long) typeDTO.getCodeOrg())
                .orElseThrow(() -> new ResourceNotFoundException("Organisme not found with ID: " + typeDTO.getCodeOrg()));

        Type type = typeMapper.toEntity(typeDTO);
        type.setCodeOrg(typeDTO.getCodeOrg());
        type = typeRepository.save(type);
        return typeMapper.toDTO(type);
    }

    public void deleteType(Long id) {
        if (!typeRepository.existsById(id)) {
            throw new ResourceNotFoundException("Type not found with ID: " + id);
        }
        typeRepository.deleteById(id);
    }

    public TypeDTO updateType(Long id, TypeDTO typeDTO) {
        Type type = typeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Type not found with ID: " + id));

        type.setCodeOrg(typeDTO.getCodeOrg());
        type.setTypeRecherche(typeDTO.getTypeRecherche());
        type.setCleMax(typeDTO.getCleMax());
        type.setCleMin(typeDTO.getCleMin());
        type.setCleType(typeDTO.getCleType());

        type = typeRepository.save(type);
        return typeMapper.toDTO(type);
    }
}
