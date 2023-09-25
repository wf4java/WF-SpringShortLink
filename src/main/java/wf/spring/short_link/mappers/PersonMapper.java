package wf.spring.short_link.mappers;

import org.springframework.stereotype.Component;
import wf.spring.short_link.dto.auth.RegisterRequestDTO;
import wf.spring.short_link.models.entities.Person;

@Component
public class PersonMapper {


    public Person toPerson(RegisterRequestDTO registerRequestDTO) {
        Person person = new Person();

        person.setUsername(registerRequestDTO.getUsername());
        person.setPassword(registerRequestDTO.getPassword());
        person.setEmail(registerRequestDTO.getEmail());

        return person;
    }


}
