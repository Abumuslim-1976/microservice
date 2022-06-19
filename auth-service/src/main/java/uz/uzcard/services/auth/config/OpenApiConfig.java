package uz.uzcard.services.auth.config;


import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().components(new Components()
                .addSecuritySchemes("BEARER KEY", new SecurityScheme().type(SecurityScheme.Type.HTTP)
                        .scheme("bearer").in(SecurityScheme.In.HEADER)));
    }

}
