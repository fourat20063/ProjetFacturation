package tn.pi.customerservice.Mappers;


import org.springframework.stereotype.Component;
import tn.pi.customerservice.DTO.CustomerDTO;
import tn.pi.customerservice.Entities.Customer;

@Component
public class CustomerMapper {

    public CustomerDTO toDTO(Customer customer) {
        CustomerDTO dto = new CustomerDTO();
        dto.setId(customer.getId());
        dto.setFirstName(customer.getFirstName());
        dto.setLastName(customer.getLastName());
        dto.setEmail(customer.getEmail());
        dto.setPhone(customer.getPhone());
        dto.setAddress(customer.getAddress());
        dto.setPostCode(customer.getPostCode());
        dto.setCin(customer.getCin());
        return dto;
    }

    public Customer toEntity(CustomerDTO dto) {
        Customer customer = new Customer();
        customer.setFirstName(dto.getFirstName());
        customer.setLastName(dto.getLastName());
        customer.setEmail(dto.getEmail());
        customer.setPhone(dto.getPhone());
        customer.setCin(dto.getCin());
        customer.setAddress(dto.getAddress());
        customer.setPostCode(dto.getPostCode());
        return customer;
    }
}