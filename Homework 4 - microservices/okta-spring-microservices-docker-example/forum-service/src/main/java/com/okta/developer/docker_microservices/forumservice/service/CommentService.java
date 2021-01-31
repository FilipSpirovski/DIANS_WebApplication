package com.okta.developer.docker_microservices.forumservice.service;

import com.okta.developer.docker_microservices.forumservice.entity.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> findAll();

    List<Comment> findAllByDisease(Long diseaseId);

    Comment addComment(Long diseaseId, String description);
}
