package wf.spring.short_link;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import wf.spring.short_link.utils.EncodeUtils;

import java.text.DecimalFormat;


@SpringBootApplication
public class WfSpringShortLinkApplication {

    public static void main(String[] args) {
        SpringApplication.run(WfSpringShortLinkApplication.class, args);
    }

}
