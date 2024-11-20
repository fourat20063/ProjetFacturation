package tn.pi.customerservice.Exceptions;

public class SubscriberNotFoundException extends RuntimeException {
    public SubscriberNotFoundException(Long id) {
        super("Subscriber not found with ID " + id);
    }
}
