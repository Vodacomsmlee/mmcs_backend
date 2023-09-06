package com.vdc.mmcs.configuration;

import com.vdc.mmcs.common.interceptor.LoggerInterceptor;
import com.vdc.mmcs.common.interceptor.SessionInterceptor;
import com.vdc.mmcs.common.resolver.ArgumentResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public LoggerInterceptor loggerInterceptor() { return new LoggerInterceptor(); }

    @Bean
    public SessionInterceptor sessionInterceptor() {
        return new SessionInterceptor();
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(sessionInterceptor())
                .addPathPatterns("/**");

        registry.addInterceptor(loggerInterceptor())
                .addPathPatterns("/**");
//                .excludePathPatterns("/assets/**","/api/**", "/excel/**");
    }

    //parameter Resolver
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new ArgumentResolver());
    }

    //index Page
    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addRedirectViewController("/", "login");
    }

}
