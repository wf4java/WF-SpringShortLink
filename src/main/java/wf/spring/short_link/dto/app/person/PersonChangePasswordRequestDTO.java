package wf.spring.short_link.dto.app.person;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import wf.spring.short_link.utils.validators.annotation.Password;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PersonChangePasswordRequestDTO {

    @Password
    @NotNull
    private String password;

}
