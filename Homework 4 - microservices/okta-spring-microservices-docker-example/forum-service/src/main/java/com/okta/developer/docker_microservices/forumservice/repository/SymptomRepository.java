package com.okta.developer.docker_microservices.forumservice.repository;

import com.okta.developer.docker_microservices.forumservice.entity.Symptom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SymptomRepository extends JpaRepository<Symptom, Long> {
}
