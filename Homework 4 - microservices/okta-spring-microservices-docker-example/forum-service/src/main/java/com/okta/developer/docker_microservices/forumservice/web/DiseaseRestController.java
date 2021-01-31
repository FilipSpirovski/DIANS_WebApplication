package com.okta.developer.docker_microservices.forumservice.web;

import com.okta.developer.docker_microservices.forumservice.entity.Comment;
import com.okta.developer.docker_microservices.forumservice.entity.Disease;
import com.okta.developer.docker_microservices.forumservice.service.CommentService;
import com.okta.developer.docker_microservices.forumservice.service.DiseaseService;
import com.okta.developer.docker_microservices.forumservice.utility.DiseaseDto;
import com.okta.developer.docker_microservices.forumservice.utility.DiseaseType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/diseases")
@CrossOrigin(origins = "http://localhost:4200")
public class DiseaseRestController {
    private final DiseaseService diseaseService;
    private final CommentService commentService;

    public DiseaseRestController(DiseaseService diseaseService, CommentService commentService) {
        this.diseaseService = diseaseService;
        this.commentService = commentService;
    }

    //List of all existing diseases from the database;
    @GetMapping("/all")
    public List<Disease> getDiseasesPage() {
        return this.diseaseService.findAll();
    }

    //List of all existing diseases from the database,
    //according to the 'type' attribute (HEART, NEUROLOGICAL, RESPIRATORY or DIGESTIVE);
    @GetMapping("/type/{diseaseType}")
    public List<Disease> getDiseasesByType(@PathVariable String diseaseType) {
        DiseaseType type = DiseaseType.valueOf(diseaseType);

        return this.diseaseService.findAllByType(type);
    }

    //Detailed information for only 1 disease, specified by the 'id' attribute;
    /*
    DiseaseDto is a 'Data Transfer Object' for encapsulating all the necessary attributes:
    1) disease: Disease - the disease object itself;
    2) comments: List<Comment> - list of the 3 latest comments, submitted for the specified disease;
     */
    @GetMapping("/{diseaseId}")
    public DiseaseDto getDiseaseById(@PathVariable Long diseaseId) {
        Disease disease = this.diseaseService.findById(diseaseId);
        List<Comment> top3Comments = this.commentService.findAllByDisease(diseaseId).stream()
                .sorted()
                .limit(3)
                .collect(Collectors.toList());

        return new DiseaseDto(disease, top3Comments);
    }
}
