package wf.spring.short_link.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wf.spring.short_link.models.entities.Link;

@Repository
public interface LinkRepository extends JpaRepository<Link, Long> {

}