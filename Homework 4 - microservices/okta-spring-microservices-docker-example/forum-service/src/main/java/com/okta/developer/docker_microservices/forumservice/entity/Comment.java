package com.okta.developer.docker_microservices.forumservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Comment implements Comparable<Comment> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 8000)
    private String description;

    private Date published;

    @ManyToOne(fetch = FetchType.EAGER)
    private Disease disease;

    @Override
    public int compareTo(Comment o) {
        return (-1) * this.published.compareTo(o.published);
    }
}
