package wf.spring.short_link.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import wf.spring.short_link.utils.EncodeUtils;

@ConfigurationProperties("spring.application")
@Getter
@Setter
public class AppProperties {


    private EncodeUtils.Encoder linkEncodeRadix = EncodeUtils.Encoder.RADIX_62;

    private int shortLinkMaxLength = 16;


}
