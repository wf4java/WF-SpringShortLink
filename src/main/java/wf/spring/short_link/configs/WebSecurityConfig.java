package wf.spring.short_link.configs;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFilter;
import wf.spring.short_link.security.JwtAuthenticationConverter;
import wf.spring.short_link.security.JwtAuthenticationManager;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {

    private final JwtAuthenticationConverter jwtAuthenticationConverter;
    private final JwtAuthenticationManager jwtAuthenticationManager;


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .httpBasic(AbstractHttpConfigurer::disable)
                .sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                //.addFilterBefore(authenticationFilter(), AuthenticationFilter.class)
                .authorizeHttpRequests(registry -> registry
                        .requestMatchers("/api/auth/**").permitAll()
                        .requestMatchers("/api/**").authenticated()
                        .anyRequest().denyAll());

        return http.build();
    }

    @Bean
    public FilterRegistrationBean<AuthenticationFilter> requestJwtAuthenticationFilter() {
        FilterRegistrationBean<AuthenticationFilter> filterRegistrationBean = new FilterRegistrationBean<>(jwtAuthenticationFilter());

        filterRegistrationBean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return filterRegistrationBean;
    }
    @Bean
    public AuthenticationFilter jwtAuthenticationFilter() {
        return new AuthenticationFilter(jwtAuthenticationManager, jwtAuthenticationConverter);
    }



//    @Bean
//    public RequestAttributeSecurityContextRepository requestAttributeSecurityContextRepository() {
//        return new RequestAttributeSecurityContextRepository();
//    }


    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


}
