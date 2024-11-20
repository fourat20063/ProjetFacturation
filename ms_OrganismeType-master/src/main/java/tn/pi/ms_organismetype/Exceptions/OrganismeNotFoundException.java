package tn.pi.ms_organismetype.Exceptions;

public class OrganismeNotFoundException extends RuntimeException {
    public OrganismeNotFoundException(Long id) {
        super("Organisme not found with ID: " + id);
    }
}

