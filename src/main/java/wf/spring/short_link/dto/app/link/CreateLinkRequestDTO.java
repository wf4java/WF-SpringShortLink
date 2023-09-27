package wf.spring.short_link.dto.app.link;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import wf.spring.short_link.utils.validators.annotation.Link;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CreateLinkRequestDTO {

    @NotNull
    @Link
    private String link;

}
