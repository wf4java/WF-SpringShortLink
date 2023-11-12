package wf.spring.short_link.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import wf.spring.short_link.models.entities.Person;
import wf.spring.short_link.models.exceptions.NotFoundException;
import wf.spring.short_link.repositories.PersonRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonService personService;

    private Person person;

    @BeforeEach
    public void setUp() {
        person = new Person();
        person.setId(1L);
        person.setUsername("test");
        person.setPassword("password");
    }

    @Test
    public void testExistsByEmailWhenPersonExistsThenReturnTrue() {
        String email = "test@test.com";
        when(personRepository.existsByEmail(email)).thenReturn(true);

        boolean exists = personService.existsByEmail(email);

        verify(personRepository, times(1)).existsByEmail(email);
        assertTrue(exists);
    }

    @Test
    public void testExistsByEmailWhenPersonNotExistsThenReturnFalse() {
        String email = "nonexistent@test.com";
        when(personRepository.existsByEmail(email)).thenReturn(false);

        boolean exists = personService.existsByEmail(email);

        verify(personRepository, times(1)).existsByEmail(email);
        assertFalse(exists);
    }

    @Test
    public void testChangePasswordWhenPersonExistsThenChangePassword() {
        String newPassword = "newPassword";
        when(personRepository.findById(person.getId())).thenReturn(Optional.of(person));

        personService.changePassword(person.getId(), newPassword);

        verify(personRepository, times(1)).findById(person.getId());
        assertEquals(newPassword, person.getPassword());
    }

    @Test
    public void testChangePasswordWhenPersonNotExistsThenThrowNotFoundException() {
        long nonExistentId = 2L;
        when(personRepository.findById(nonExistentId)).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> personService.changePassword(nonExistentId, "newPassword"));

        verify(personRepository, times(1)).findById(nonExistentId);
    }
}