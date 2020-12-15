package mk.ukim.finki.dians_app.service.impl;

import mk.ukim.finki.dians_app.model.Comment;
import mk.ukim.finki.dians_app.model.Disease;
import mk.ukim.finki.dians_app.repository.CommentRepository;
import mk.ukim.finki.dians_app.repository.DiseaseRepository;
import mk.ukim.finki.dians_app.service.CommentService;
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
    public void addComment(Long diseaseId, String description) {
        Disease disease = this.diseaseRepository.findById(diseaseId).get();
        this.commentRepository.save(new Comment(null, description, new Date(), disease));
    }
}
