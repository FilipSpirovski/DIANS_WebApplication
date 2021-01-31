package com.okta.developer.docker_microservices.forumservice.service.impl;

import com.okta.developer.docker_microservices.forumservice.entity.Comment;
import com.okta.developer.docker_microservices.forumservice.entity.Disease;
import com.okta.developer.docker_microservices.forumservice.repository.CommentRepository;
import com.okta.developer.docker_microservices.forumservice.repository.DiseaseRepository;
import com.okta.developer.docker_microservices.forumservice.service.CommentService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final DiseaseRepository diseaseRepository;

    public CommentServiceImpl(CommentRepository commentRepository, DiseaseRepository diseaseRepository) {
        this.commentRepository = commentRepository;
        this.diseaseRepository = diseaseRepository;
    }

    @Override
    public List<Comment> findAll() {
        return this.commentRepository.findAll();
    }

    @Override
    public List<Comment> findAllByDisease(Long diseaseId) {
        Disease disease = this.diseaseRepository.findById(diseaseId).get();
        return this.commentRepository.findAllByDisease(disease);
    }

    @Override
    public Comment addComment(Long diseaseId, String description) {
        Disease disease = this.diseaseRepository.findById(diseaseId).get();
        return this.commentRepository.save(new Comment(null, description, new Date(), disease));
    }
}
