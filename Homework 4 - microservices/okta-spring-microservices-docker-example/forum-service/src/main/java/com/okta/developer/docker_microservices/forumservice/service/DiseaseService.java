package com.okta.developer.docker_microservices.forumservice.service;

import com.okta.developer.docker_microservices.forumservice.entity.Disease;
import com.okta.developer.docker_microservices.forumservice.utility.DiseaseType;

import java.util.List;

public interface DiseaseService {
    List<Disease> findAll();

    Disease findById(Long diseaseId);

    List<Disease> findAllByType(DiseaseType type);
}
