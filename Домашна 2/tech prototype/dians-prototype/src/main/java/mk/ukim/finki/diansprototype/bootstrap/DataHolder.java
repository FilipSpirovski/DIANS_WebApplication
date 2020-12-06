package mk.ukim.finki.diansprototype.bootstrap;

import mk.ukim.finki.diansprototype.model.HealthInstitution;
import mk.ukim.finki.diansprototype.model.Pharmacy;
import mk.ukim.finki.diansprototype.model.enums.HealthInstitutionType;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Pharmacy> pharmacies = new ArrayList<>();
    public static List<HealthInstitution> institutions = new ArrayList<>();

    @PostConstruct
    public void init() {
        //TODO
        pharmacies.add(new Pharmacy(
                (long) 1, "Zegin Tobako 2", "Локал 6, Булевар Јане Сандански, Скопје 1000",
                "Пон - Саб од 07:00 до 24:00", "02 2521 431",
                4.3, "http://www.zegin.com.mk/"));

        institutions.add(new HealthInstitution(
                (long) 1, "University Clinic Of Dermatovenerology", "Skopje 1000  North Macedonia",
                "Open 24 hours", "02 2521 431", 4.0,
                "Ne postoi", HealthInstitutionType.PUBLIC
        ));
        institutions.add(new HealthInstitution(
                (long) 2, "Zan Mitrev Clinic", "Bledski Dogovor 8  Skopje 1000  North Macedonia",
                "Open 24 hours", "+389 2 309 1484", 3.9,
                "zmc.mk", HealthInstitutionType.PRIVATE
        ));
    }
}
