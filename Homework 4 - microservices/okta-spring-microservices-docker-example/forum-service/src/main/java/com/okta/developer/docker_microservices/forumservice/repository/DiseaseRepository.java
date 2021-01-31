package com.okta.developer.docker_microservices.forumservice.repository;

import com.okta.developer.docker_microservices.forumservice.entity.Disease;
import com.okta.developer.docker_microservices.forumservice.utility.DiseaseType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiseaseRepository extends JpaRepository<Disease, Long> {
    List<Disease> findAllByType(DiseaseType type);
}
