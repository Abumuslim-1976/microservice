package uz.uzcard.services.group.config;

import feign.RequestInterceptor;
import org.apache.http.entity.ContentType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {
    @Value("${service.groupServiceUsername}")
    private String groupServiceUsername;
    @Value("${service.groupServicePassword}")
    private String groupServicePassword;

    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            requestTemplate.header("serviceName", groupServiceUsername);
            requestTemplate.header("servicePassword", groupServicePassword);
            requestTemplate.header("Accept", ContentType.APPLICATION_JSON.getMimeType());
        };
    }
}
