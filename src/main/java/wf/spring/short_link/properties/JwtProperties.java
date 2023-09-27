package wf.spring.short_link.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("spring.security.jwt")
@Getter
@Setter
public class JwtProperties {

    private String secretKey = "secret_key_jADj34dDdfO235lzXc";

    private int expirationDays = 7;

    private String issuer = "spring-app";

}
