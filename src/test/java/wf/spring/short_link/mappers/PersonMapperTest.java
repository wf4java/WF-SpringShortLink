package wf.spring.short_link.mappers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import wf.spring.short_link.dto.auth.RegisterRequestDTO;
import wf.spring.short_link.models.entities.Person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PersonMapperTest {

    private PersonMapper personMapper;

    @BeforeEach
    public void setUp() {
        personMapper = new PersonMapper();
    }

    @Test
    public void testToPersonWhenValidRegisterRequestDTOThenReturnPerson() {
        // Arrange
        RegisterRequestDTO registerRequestDTO = new RegisterRequestDTO();
        registerRequestDTO.setUsername("testUsername");
        registerRequestDTO.setEmail("testEmail@test.com");
        registerRequestDTO.setPassword("testPassword");

        // Act
        Person person = personMapper.toPerson(registerRequestDTO);

        // Assert
        assertEquals(registerRequestDTO.getUsername(), person.getUsername());
        assertEquals(registerRequestDTO.getEmail(), person.getEmail());
        assertEquals(registerRequestDTO.getPassword(), person.getPassword());
    }

    @Test
    public void testToPersonWhenNullRegisterRequestDTOThenThrowNullPointerException() {
        // Arrange
        RegisterRequestDTO registerRequestDTO = null;

        // Act & Assert
        assertThrows(NullPointerException.class, () -> personMapper.toPerson(registerRequestDTO));
    }
}