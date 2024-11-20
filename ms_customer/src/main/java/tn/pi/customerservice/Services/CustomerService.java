package tn.pi.customerservice.Services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.pi.customerservice.DTO.CustomerDTO;
import tn.pi.customerservice.Entities.Customer;
import tn.pi.customerservice.Exceptions.CustomerNotFoundException;
import tn.pi.customerservice.Mappers.CustomerMapper;
import tn.pi.customerservice.Repositories.CustomerRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerMapper customerMapper;

    public List<CustomerDTO> getAllCustomers() {
        return customerRepository.findAll().stream()
                .map(customerMapper::toDTO)
                .collect(Collectors.toList());
    }

    public CustomerDTO getCustomerById(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));
        return customerMapper.toDTO(customer);
    }



    public CustomerDTO createCustomer(CustomerDTO customerDTO) {
        Customer customer = customerMapper.toEntity(customerDTO);
        customer = customerRepository.save(customer);
        return customerMapper.toDTO(customer);
    }

    public void deleteCustomer(Long id) {
        if (!customerRepository.existsById(id)) {
            throw new CustomerNotFoundException(id);
        }
        customerRepository.deleteById(id);
    }
    public void updateCustomer(Long id, Customer updatedCustomer) {
        if (!customerRepository.existsById(id)) {
            throw new CustomerNotFoundException(id);
        }
        updatedCustomer.setId(id);
        customerRepository.save(updatedCustomer);
    }
}
