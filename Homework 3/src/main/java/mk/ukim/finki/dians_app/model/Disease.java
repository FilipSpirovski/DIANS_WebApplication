package mk.ukim.finki.dians_app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mk.ukim.finki.dians_app.model.enums.DiseaseType;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Disease {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @NotBlank
    @NotEmpty
    private String name;

    @NotNull
    @NotBlank
    @NotEmpty
    @Enumerated(value = EnumType.STRING)
    private DiseaseType type;

    @NotNull
    @NotBlank
    @NotEmpty
    @Column(length = 8000)
    private String description;

    @ManyToMany
    private List<Symptom> symptoms;

    @OneToMany(mappedBy = "disease", fetch = FetchType.EAGER)
    private List<Comment> comments;
}
