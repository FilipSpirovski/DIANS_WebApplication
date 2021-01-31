package com.okta.developer.docker_microservices.forumservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.okta.developer.docker_microservices.forumservice.utility.DiseaseType;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Disease {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(value = EnumType.STRING)
    private DiseaseType type;

    @Column(length = 8000)
    private String description;

    @ManyToMany
    private List<Symptom> symptoms;
}
