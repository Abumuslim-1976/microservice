package uz.uzcard.services.student;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EnableFeignClients
@EnableEurekaClient
@EntityScan(basePackages = "uz.uzcard.service.dbservice.entity")
@EnableJpaRepositories(basePackages = "uz.uzcard.service.dbservice.repository")
@OpenAPIDefinition(info =
@Info(title = "Department API", version = "1.0", description = "Documentation Department API v1.0")
)
public class StudentApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentApplication.class, args);
    }

}
