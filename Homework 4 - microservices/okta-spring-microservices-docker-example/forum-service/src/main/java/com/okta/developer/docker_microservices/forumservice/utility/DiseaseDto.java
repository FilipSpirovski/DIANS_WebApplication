package com.okta.developer.docker_microservices.forumservice.utility;

import com.okta.developer.docker_microservices.forumservice.entity.Comment;
import com.okta.developer.docker_microservices.forumservice.entity.Disease;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DiseaseDto {
    private Disease disease;
    private List<Comment> comments;
}
