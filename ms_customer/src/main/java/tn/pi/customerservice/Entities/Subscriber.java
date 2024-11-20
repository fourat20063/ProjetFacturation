package tn.pi.customerservice.Entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Subscriber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String reference;
    private Long idCustomer; // Foreign key to Customer
    private Integer codeOrg;
    private Integer status;

    @ManyToOne
    @JoinColumn(name = "idCustomer", insertable = false, updatable = false)
    private Customer customer;
}
