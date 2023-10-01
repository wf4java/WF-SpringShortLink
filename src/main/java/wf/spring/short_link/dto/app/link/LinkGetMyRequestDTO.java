package wf.spring.short_link.dto.app.link;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;
import wf.spring.short_link.utils.validators.annotation.LongId;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LinkGetMyRequestDTO {


    @Min(1)
    @Max(100)
    private int limit;

    @LongId
    private long offSetLinkId;

}
