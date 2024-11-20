package tn.pi.ms_organismetype.DTO;

import lombok.Data;

@Data
public class TypeDTO {
    private Long id;
    private Integer codeOrg;
    private String typeRecherche;
    private Integer cleMax;
    private Integer cleMin;
    private String cleType;
}
