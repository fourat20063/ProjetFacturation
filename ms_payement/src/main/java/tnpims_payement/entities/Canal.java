package tnpims_payement.entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
public class Canal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String libelle;
    private String code;
    private String port;
    private String ip;
}
