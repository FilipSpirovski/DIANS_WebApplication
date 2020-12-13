package mk.ukim.finki.diansprototype.model;

import lombok.Data;
import mk.ukim.finki.diansprototype.model.enums.HealthInstitutionType;

@Data
public class HealthInstitution {
    private Long id;
    private String name;
    private String address;
    private String workingHours;
    private String phoneNumber;
    private Double rating;
    private String website;
    private HealthInstitutionType type;

    public HealthInstitution(Long id, String name, String address, String workingHours, String phoneNumber,
                             Double rating, String website, HealthInstitutionType type) {
        //this.id = (long) (Math.random() * 1000);
        this.id = id;
        this.name = name;
        this.address = address;
        this.workingHours = workingHours;
        this.phoneNumber = phoneNumber;
        this.rating = rating;
        this.website = website;
        this.type = type;
    }
}
