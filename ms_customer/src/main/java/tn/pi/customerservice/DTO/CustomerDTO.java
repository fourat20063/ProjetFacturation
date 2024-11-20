package tn.pi.customerservice.DTO;

import lombok.Data;

@Data
public class CustomerDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String postCode;
    private String cin;
    private String address;
}