package wf.spring.short_link.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wf.spring.short_link.entityes.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
