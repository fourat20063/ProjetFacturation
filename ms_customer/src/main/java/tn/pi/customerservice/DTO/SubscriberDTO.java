package tn.pi.customerservice.DTO;

import lombok.Data;

@Data
public class SubscriberDTO {
    private Long id;
    private String reference;
    private Long idCustomer;
    private Integer codeOrg;
    private Integer status;
    private String firstName;
    private String lastName;
    private String email;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String phone;
    public Long getCustomerId() {
        return idCustomer;
    }

    public void setCustomerId(Long customerId) {
        this.idCustomer = customerId;
    }
}
