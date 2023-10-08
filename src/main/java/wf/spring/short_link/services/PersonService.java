package wf.spring.short_link.services;


import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wf.spring.short_link.models.entities.Person;
import wf.spring.short_link.models.exceptions.NotFoundException;
import wf.spring.short_link.repositories.PersonRepository;

import java.util.Date;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public Person save(Person person) {
        person.setPassword(passwordEncoder.encode(person.getPassword()));
        person.setCreatedAt(new Date());

        return personRepository.save(person);
    }

    @Transactional
    public void changePassword(long id, String password) {
        Person person = personRepository.findById(id).orElseThrow(() -> new NotFoundException("Person with this id not found"));

        person.setPassword(password);
    }

    public boolean existsByUsername(String username) {
        return personRepository.existsByUsername(username);
    }

    public boolean existsByEmail(String email) {
        return personRepository.existsByEmail(email);
    }


}
