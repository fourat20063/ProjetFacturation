package tn.pi.customerservice.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.pi.customerservice.DTO.SubscriberDTO;
import tn.pi.customerservice.Entities.Customer;
import tn.pi.customerservice.Entities.Subscriber;
import tn.pi.customerservice.Exceptions.ResourceNotFoundException;
import tn.pi.customerservice.Exceptions.SubscriberNotFoundException;
import tn.pi.customerservice.Mappers.SubscriberMapper;
import tn.pi.customerservice.Repositories.CustomerRepository;
import tn.pi.customerservice.Repositories.SubscriberRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SubscriberService {

    @Autowired
    private SubscriberRepository subscriberRepository;
    @Autowired
    private CustomerRepository customerRepository;


    @Autowired
    private SubscriberMapper subscriberMapper;

    public List<SubscriberDTO> getAllSubscribers() {
        return subscriberRepository.findAll().stream()
                .map(subscriberMapper::toDTO)
                .collect(Collectors.toList());
    }

    public SubscriberDTO getSubscriberById(Long id) {
        Subscriber subscriber = subscriberRepository.findById(id)
                .orElseThrow(() -> new SubscriberNotFoundException(id));
        return subscriberMapper.toDTO(subscriber);
    }

    public SubscriberDTO createSubscriber(SubscriberDTO subscriberDTO) {
        Subscriber subscriber = subscriberMapper.toEntity(subscriberDTO);
        subscriber = subscriberRepository.save(subscriber);
        return subscriberMapper.toDTO(subscriber);
    }

    public void deleteSubscriber(Long id) {
        if (!subscriberRepository.existsById(id)) {
            throw new SubscriberNotFoundException(id);
        }
        subscriberRepository.deleteById(id);
    }

    public SubscriberDTO updateSubscriber(Long subscriberId, SubscriberDTO dto) {
        // Check if the customer exists
        Customer customer = customerRepository.findById(dto.getIdCustomer())
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with ID: " + dto.getIdCustomer()));

        // Retrieve and update the subscriber
        Subscriber subscriber = subscriberRepository.findById(subscriberId)
                .orElseThrow(() -> new ResourceNotFoundException("Subscriber not found with ID: " + subscriberId));

        subscriber.setCustomer(customer);
        subscriber.setReference(dto.getReference());
        subscriber.setCodeOrg(dto.getCodeOrg());
        subscriber.setStatus(dto.getStatus());

        // Save and return the updated subscriber
        subscriber = subscriberRepository.save(subscriber);
        return subscriberMapper.toDTO(subscriber);
    }



}
