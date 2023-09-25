package wf.spring.short_link.configs;

import jakarta.validation.Validator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
public class WebApplicationConfig {


    @Bean
    public Validator defaultValidator() {
        return new LocalValidatorFactoryBean();
    }


}
