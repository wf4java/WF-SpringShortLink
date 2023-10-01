package wf.spring.short_link.dto.app.link;


import lombok.*;
import wf.spring.short_link.utils.validators.annotation.LongId;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LinkDeleteRequestDTO {

    @LongId
    private long id;

}
