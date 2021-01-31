package com.okta.developer.docker_microservices.clinicpharmacyservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.okta.developer.docker_microservices.clinicpharmacyservice.utility.ClinicType;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Clinic {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

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

    private String latitude;

    private String longitude;
}
