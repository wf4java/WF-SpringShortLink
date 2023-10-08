package wf.spring.short_link.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import wf.spring.short_link.dto.app.link.LinkResponseDTO;
import wf.spring.short_link.models.entities.Link;
import wf.spring.short_link.properties.AppProperties;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EncodeUtilsTest {

    @InjectMocks
    private AppProperties appProperties;

    @InjectMocks
    private EncodeUtils encodeUtils;



    @Test
    public void testEncodeWhenValidIdThenReturnEncodedString() {
        // Arrange
        long validId = 12345L;

        // Act
        String encodedString = appProperties.getLinkEncodeRadix().encode(validId);

        // Assert
        assertEquals(appProperties.getLinkEncodeRadix().encode(validId), encodedString);
    }

    @Test
    public void testEncodeWhenInvalidIdThenThrowException() {
        // Arrange
        long invalidId = -12345L;

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> encodeUtils.encode(invalidId));
    }
}