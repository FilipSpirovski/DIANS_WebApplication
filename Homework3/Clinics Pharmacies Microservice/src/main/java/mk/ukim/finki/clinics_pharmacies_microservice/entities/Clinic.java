package mk.ukim.finki.clinics_pharmacies_microservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mk.ukim.finki.clinics_pharmacies_microservice.utilities.ClinicType;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
@Table(name = "clinics")
public class Clinic {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank @NotNull @NotEmpty
    private String name;

    @NotBlank @NotNull @NotEmpty
    private String address;

    private String workingHours;

    private String phoneNumber;

    private Double rating;

    private String website;

    @NotEmpty @NotNull @NotBlank
    private ClinicType type;
}
