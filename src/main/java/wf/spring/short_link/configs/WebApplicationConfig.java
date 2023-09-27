package wf.spring.short_link.configs;

import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import wf.spring.short_link.properties.AppProperties;
import wf.spring.short_link.properties.JwtProperties;

@Configuration
@EnableConfigurationProperties({JwtProperties.class, AppProperties.class})
@RequiredArgsConstructor
public class WebApplicationConfig {


    @Bean
    public Validator defaultValidator() {
        return new LocalValidatorFactoryBean();
    }


}
