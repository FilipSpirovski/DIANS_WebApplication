package com.okta.developer.docker_microservices.forumservice.repository;

import com.okta.developer.docker_microservices.forumservice.entity.Comment;
import com.okta.developer.docker_microservices.forumservice.entity.Disease;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByDisease(Disease disease);
}
