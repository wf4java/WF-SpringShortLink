package wf.spring.short_link.models.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "link", indexes = {
        @Index(columnList = "owner_id,id")
})

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Link {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //=============================================================================
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id", referencedColumnName = "id", nullable = false)
    private Person owner;

    @Column(name = "owner_id", insertable = false, updatable = false)
    private long ownerId;
    //=============================================================================

    @Column(name = "link", nullable = false, length = 4096)
    private String link;

    @Column(name = "visits")
    private long visits;

    @Column(name = "created_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

}
