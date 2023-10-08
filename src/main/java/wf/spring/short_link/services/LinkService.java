package wf.spring.short_link.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wf.spring.short_link.models.entities.Link;
import wf.spring.short_link.models.exceptions.AccessException;
import wf.spring.short_link.models.exceptions.NotFoundException;
import wf.spring.short_link.repositories.LinkRepository;
import wf.spring.short_link.repositories.PersonRepository;

import java.util.Date;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class LinkService {


    private final PersonRepository personRepository;
    private final LinkRepository linkRepository;




    public Link getById(long id) {
        return linkRepository.findById(id).orElseThrow(() -> new NotFoundException("A link with the same ID was found"));
    }

    public List<Link> findAllNextByOwnerIdAndLinkOffset(long ownerId, long linkOffsetId, int limit) {
        return linkRepository.findAllNextByOwnerIdAndLinkOffset(ownerId, linkOffsetId, limit);
    }

    @Transactional
    public void addVisit(long id) {
        linkRepository.addOneVisitById(id);
    }

    @Transactional
    public void deleteById(long id, long personId) {
        Link link = getById(id);

        if(link.getOwnerId() != personId)
            throw new AccessException("This user cannot delete this link");

        linkRepository.delete(link);
    }

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
