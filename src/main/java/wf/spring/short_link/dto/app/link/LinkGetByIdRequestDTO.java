package wf.spring.short_link.dto.app.link;


import jakarta.validation.constraints.NotNull;
import lombok.*;
import wf.spring.short_link.utils.validators.annotation.LongId;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LinkGetByIdRequestDTO {

    @LongId
    private long id;

}
