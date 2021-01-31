package com.okta.developer.docker_microservices.forumservice.web;

import com.okta.developer.docker_microservices.forumservice.entity.Comment;
import com.okta.developer.docker_microservices.forumservice.service.CommentService;
import com.okta.developer.docker_microservices.forumservice.utility.CommentDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/comments")
@CrossOrigin(origins = "http://localhost:4200")
public class CommentRestController {
    private final CommentService commentService;

    public CommentRestController(CommentService commentService) {
        this.commentService = commentService;
    }

    //Adding a new comment for a specified disease, and saving it to the database;
    /*
    CommentDto is a 'Data Transfer Object' for encapsulating all the necessary attributes:
    1) description: String - the comment itself;
    2) diseaseId: Integer - the 'id' attribute of the selected disease for which the comment is written;
     */
    @PostMapping("/add")
    public Comment addComment(@RequestBody CommentDto commentDTO) {
        return this.commentService.addComment(
                commentDTO.getDiseaseId(), commentDTO.getDescription()
        );
    }
}
