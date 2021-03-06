package uz.uzcard.services.student.config;

import feign.RequestInterceptor;
import org.apache.http.entity.ContentType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {
    @Value("${service.studentServiceUsername}")
    private String studentServiceUsername;
    @Value("${service.studentServicePassword}")
    private String studentServicePassword;

    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            requestTemplate.header("serviceName", studentServiceUsername);
            requestTemplate.header("servicePassword", studentServicePassword);
            requestTemplate.header("Accept", ContentType.APPLICATION_JSON.getMimeType());
        };
    }
}
