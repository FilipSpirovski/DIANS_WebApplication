package mk.ukim.finki.diansprototype.model.exceptions;

public class HealthInstitutionNotFoundException extends Exception {
    public HealthInstitutionNotFoundException(Long id) {
        super(String.format("Health Institution (with id: %d) does not exist!", id));
    }
}
