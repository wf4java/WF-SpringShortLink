package wf.spring.short_link.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import wf.spring.short_link.models.entities.Link;

import java.util.List;

@Repository
public interface LinkRepository extends JpaRepository<Link, Long> {

    @Query(value = "SELECT * FROM link l where l.owner_id = :owner_id and l.id > :offset_id order by l.id limit :limit", nativeQuery = true)
    public List<Link> findAllNextByOwnerIdAndLinkOffset(@Param(value = "owner_id") long ownerId ,@Param(value = "offset_id") long offsetLinkId, @Param(value = "limit") int limit);


}
