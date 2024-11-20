package tn.pi.ms_organismetype.DTO;

import lombok.Data;

@Data
public class OrganismeDTO {
    private Long id;
    private Integer code;
    private String nom;
    private String logo;
    private String description;
}
