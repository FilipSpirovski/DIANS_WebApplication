package mk.ukim.finki.dians_app.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import mk.ukim.finki.dians_app.model.enums.ClinicType;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@Entity
public class Clinic {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    @NotBlank
    @NotEmpty
    private String title;

    private String rating;

    @Enumerated(value = EnumType.STRING)
    private ClinicType category;

    private String address;

    private String website;

    private String phoneNumber;

    private String monday;
    private String tuesday;
    private String wednesday;
    private String thursday;
    private String friday;
    private String saturday;
    private String sunday;

    @NotNull
    @NotBlank
    @NotEmpty
    private String latitude;

    @NotNull
    @NotBlank
    @NotEmpty
    private String longitude;
}