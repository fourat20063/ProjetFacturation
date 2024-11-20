package tnpims_payement.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Payement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long idFacture;
    private Integer refPayment;
    private Integer datePayment;

    @OneToOne
    @JoinColumn(name = "canal_id", referencedColumnName = "id")
    private Canal canal;
}
