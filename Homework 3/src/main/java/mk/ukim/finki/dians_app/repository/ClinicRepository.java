package mk.ukim.finki.dians_app.repository;

import mk.ukim.finki.dians_app.model.Clinic;
import mk.ukim.finki.dians_app.model.enums.ClinicType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClinicRepository extends JpaRepository<Clinic, Integer> {
    List<Clinic> findByCategory(ClinicType type);
}
