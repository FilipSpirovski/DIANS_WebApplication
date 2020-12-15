package mk.ukim.finki.dians_app.controller;

import mk.ukim.finki.dians_app.service.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/comments")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/add-comment")
    public String addComment(@RequestParam Long diseaseId, @RequestParam String description, Model model) {
        this.commentService.addComment(diseaseId, description);

        return String.format("redirect:/diseases/%d", diseaseId);
    }
}
