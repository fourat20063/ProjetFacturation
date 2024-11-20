package tn.pi.ms_organismetype.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer codeOrg;
    private String typeRecherche;
    private Integer cleMax;
    private Integer cleMin;
    private String cleType;

    @OneToOne
    @JoinColumn(name = "codeOrg", referencedColumnName = "code", insertable = false, updatable = false)
    private Organisme organisme;
}