package wf.spring.short_link.services;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wf.spring.short_link.models.entities.Person;
import wf.spring.short_link.repositories.PersonRepository;
import wf.spring.short_link.security.PersonDetails;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class PersonDetailsService implements UserDetailsService {


    private final PersonRepository personRepository;



    @Override
    @Transactional(readOnly = true)
    public PersonDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Person> person = personRepository.findByUsername(username);
        if(person.isEmpty()) throw new UsernameNotFoundException("User not found!");

        return new PersonDetails(person.get());
    }

    @Transactional(readOnly = true)
    public PersonDetails loadUserById(long id) throws UsernameNotFoundException {
        Optional<Person> person = personRepository.findById(id);
        if(person.isEmpty()) throw new UsernameNotFoundException("User not found!");

        return new PersonDetails(person.get());
    }


}
