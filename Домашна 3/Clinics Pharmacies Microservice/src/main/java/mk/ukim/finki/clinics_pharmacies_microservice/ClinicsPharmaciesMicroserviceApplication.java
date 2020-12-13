package mk.ukim.finki.clinics_pharmacies_microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class ClinicsPharmaciesMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClinicsPharmaciesMicroserviceApplication.class, args);
    }

}
