package uz.uzcard.services.gateway;


import org.springdoc.core.GroupedOpenApi;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerController {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r
                        .path("/api/student/**")
                        .uri("http://localhost:9080/"))

                .route(r -> r
                        .path("/api/group/**")
                        .uri("http://localhost:9081/"))

                .route(r -> r
                        .path("/api/open-auth/auth/**")
                        .uri("http://localhost:9082/"))

                .build();
    }

    @Bean
    GroupedOpenApi studentApis() {
        return GroupedOpenApi.builder().group("student").pathsToMatch("/**/student/**").build();
    }

    @Bean
    GroupedOpenApi groupApis() {
        return GroupedOpenApi.builder().group("group").pathsToMatch("/**/group/**").build();
    }

    @Bean
    GroupedOpenApi authApis() {
        return GroupedOpenApi.builder().group("auth").pathsToMatch("/**/auth/**").build();
    }

}
