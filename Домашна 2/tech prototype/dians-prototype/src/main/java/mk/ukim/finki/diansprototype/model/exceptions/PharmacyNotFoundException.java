package mk.ukim.finki.diansprototype.model.exceptions;

public class PharmacyNotFoundException extends Exception {
    public PharmacyNotFoundException(Long id) {
        super(String.format("Pharmacy (with id: %d) does not exist!", id));
    }
}
