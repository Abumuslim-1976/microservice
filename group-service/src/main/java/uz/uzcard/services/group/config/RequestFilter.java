package uz.uzcard.services.group.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
public class RequestFilter implements Filter {
    @Value("${serviceUsername}")
    private String serviceUsernameKey;
    @Value("${servicePassword}")
    private String servicePasswordKey;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest =(HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        String serviceUsername = httpServletRequest.getHeader(serviceUsernameKey);
        String servicePassword = httpServletRequest.getHeader(servicePasswordKey);
        String requestURI = httpServletRequest.getRequestURI(); //v2/api-docs

        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }


}
