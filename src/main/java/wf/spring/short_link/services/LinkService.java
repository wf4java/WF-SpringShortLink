package wf.spring.short_link.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wf.spring.short_link.models.entities.Link;
import wf.spring.short_link.repositories.LinkRepository;
import wf.spring.short_link.repositories.PersonRepository;

import java.util.Date;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class LinkService {


    private final PersonRepository personRepository;
    private final LinkRepository linkRepository;






    @Transactional
    public Link create(long personId, String reference) {
        Link link = new Link();

        link.setOwner(personRepository.getReferenceById(personId));
        link.setLink(reference);
        link.setVisits(0);
        link.setCreatedAt(new Date());

        return linkRepository.save(link);
    }


}
