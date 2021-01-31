package com.okta.developer.docker_microservices.forumservice.service.impl;

import com.okta.developer.docker_microservices.forumservice.entity.Disease;
import com.okta.developer.docker_microservices.forumservice.repository.DiseaseRepository;
import com.okta.developer.docker_microservices.forumservice.service.DiseaseService;
import com.okta.developer.docker_microservices.forumservice.utility.DiseaseType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiseaseServiceImpl implements DiseaseService {
    private final DiseaseRepository diseaseRepository;

    public DiseaseServiceImpl(DiseaseRepository diseaseRepository) {
        this.diseaseRepository = diseaseRepository;
    }

    @Override
    public List<Disease> findAll() {
        return this.diseaseRepository.findAll();
    }

    @Override
    public Disease findById(Long diseaseId) {
        return this.diseaseRepository.findById(diseaseId).get();
    }

    @Override
    public List<Disease> findAllByType(DiseaseType type) {
        return this.diseaseRepository.findAllByType(type);
    }
}
