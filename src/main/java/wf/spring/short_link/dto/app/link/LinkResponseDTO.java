package wf.spring.short_link.dto.app.link;


import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LinkResponseDTO {

    private long id;

    private String link;

    private String shortLink;

    private long visits;

    private Date createdAt;

}
