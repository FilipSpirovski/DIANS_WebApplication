package mk.ukim.finki.dians_app.service;

import mk.ukim.finki.dians_app.model.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> findAll();

    List<Comment> findAllByDisease(Long diseaseId);

    void addComment(Long diseaseId, String description);
}
