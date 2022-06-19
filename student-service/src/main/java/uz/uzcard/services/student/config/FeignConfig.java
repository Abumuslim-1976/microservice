package uz.uzcard.services.student.config;

import feign.RequestInterceptor;
import org.apache.http.entity.ContentType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {
    @Value("${service.productServiceUsername}")
    private String productServiceUsername;
    @Value("${service.productServicePassword}")
    private String productServicePassword;

    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            requestTemplate.header("serviceName", productServiceUsername);
            requestTemplate.header("servicePassword", productServicePassword);
            requestTemplate.header("Accept", ContentType.APPLICATION_JSON.getMimeType());
        };
    }
}
