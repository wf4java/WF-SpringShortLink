package wf.spring.short_link.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("spring.security.jwt")
@Getter
@Setter
public class JwtProperties {

    private String secretKey;

    private int expirationDays;

    private String issuer;

}
