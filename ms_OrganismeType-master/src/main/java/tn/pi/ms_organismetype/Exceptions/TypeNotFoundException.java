package tn.pi.ms_organismetype.Exceptions;

public class TypeNotFoundException extends RuntimeException {
    public TypeNotFoundException(Long id) {
        super("Type not found with ID: " + id);
    }
}
