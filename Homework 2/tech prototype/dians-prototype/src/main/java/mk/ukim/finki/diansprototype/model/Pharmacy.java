package mk.ukim.finki.diansprototype.model;

import lombok.Data;

@Data
public class Pharmacy {
    private Long id;
    private String name;
    private String address;
    private String workingHours;
    private String phoneNumber;
    private Double rating;
    private String website;

    public Pharmacy(Long id, String name, String address, String workingHours, String phoneNumber, Double rating, String website) {
        /*this.id = (long) (Math.random() * 1000);*/
        this.id = id;
        this.name = name;
        this.address = address;
        this.workingHours = workingHours;
        this.phoneNumber = phoneNumber;
        this.rating = rating;
        this.website = website;
    }
}
