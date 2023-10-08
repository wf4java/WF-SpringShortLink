package wf.spring.short_link;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertNotNull;



@SpringBootTest(classes = WfSpringShortLinkApplication.class)
public class WfSpringShortLinkApplicationTests {

    @Autowired
    private ApplicationContext applicationContext;


    @Test
    public void testMainWhenCalledThenApplicationStartsSuccessfully() {
        // Arrange
        String[] args = {};

        // Act
        WfSpringShortLinkApplication.main(args);

        // Assert
        assertNotNull(applicationContext, "The application context should not be null");
    }
}