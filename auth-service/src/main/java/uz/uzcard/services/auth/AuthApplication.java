package uz.uzcard.services.auth;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableEurekaClient
@EntityScan(basePackages = "uz.uzcard.service.dbservice.entity")
@EnableJpaRepositories(basePackages = "uz.uzcard.service.dbservice.repository")
//@EnableFeignClients
@OpenAPIDefinition(info =
@Info(title = "Organization API", version = "3.0", description = "Documentation Organization API v3.0")
)
public class AuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class, args);
    }

}
