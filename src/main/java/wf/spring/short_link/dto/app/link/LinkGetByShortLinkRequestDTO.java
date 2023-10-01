package wf.spring.short_link.dto.app.link;


import jakarta.validation.constraints.NotNull;
import lombok.*;
import wf.spring.short_link.utils.validators.annotation.LongId;
import wf.spring.short_link.utils.validators.annotation.ShortLink;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LinkGetByShortLinkRequestDTO {

    @ShortLink
    @NotNull
    private String shortLink;

}
