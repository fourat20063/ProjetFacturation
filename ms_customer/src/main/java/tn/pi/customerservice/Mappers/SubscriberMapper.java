package tn.pi.customerservice.Mappers;

import org.springframework.stereotype.Component;
import tn.pi.customerservice.DTO.SubscriberDTO;
import tn.pi.customerservice.Entities.Subscriber;

@Component
public class SubscriberMapper {

    public SubscriberDTO toDTO(Subscriber subscriber) {
        SubscriberDTO dto = new SubscriberDTO();
        dto.setId(subscriber.getId());
        dto.setReference(subscriber.getReference());
        dto.setIdCustomer(subscriber.getIdCustomer());
        dto.setCodeOrg(subscriber.getCodeOrg());
        dto.setStatus(subscriber.getStatus());
        if (subscriber.getCustomer() != null) {
            dto.setFirstName(subscriber.getCustomer().getFirstName());
            dto.setLastName(subscriber.getCustomer().getLastName());
            dto.setEmail(subscriber.getCustomer().getEmail());
            dto.setPhone(subscriber.getCustomer().getPhone());
        }
        return dto;
    }

    public Subscriber toEntity(SubscriberDTO dto) {
        Subscriber subscriber = new Subscriber();
        subscriber.setId(dto.getId());
        subscriber.setReference(dto.getReference());
        subscriber.setIdCustomer(dto.getIdCustomer());
        subscriber.setCodeOrg(dto.getCodeOrg());
        subscriber.setStatus(dto.getStatus());
        return subscriber;
    }
}
