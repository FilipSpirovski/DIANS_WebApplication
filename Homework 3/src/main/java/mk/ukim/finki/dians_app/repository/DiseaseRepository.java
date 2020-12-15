package mk.ukim.finki.dians_app.repository;


import mk.ukim.finki.dians_app.model.Disease;
import mk.ukim.finki.dians_app.model.enums.DiseaseType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiseaseRepository extends JpaRepository<Disease, Long> {
    List<Disease> findAllByType(DiseaseType type);
}
