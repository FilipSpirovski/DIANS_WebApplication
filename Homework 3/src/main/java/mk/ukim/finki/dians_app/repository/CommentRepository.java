package mk.ukim.finki.dians_app.repository;

import mk.ukim.finki.dians_app.model.Comment;
import mk.ukim.finki.dians_app.model.Disease;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByDisease(Disease disease);
}
