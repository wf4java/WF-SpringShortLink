package wf.spring.short_link.dto.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import wf.spring.short_link.utils.validators.annotation.Password;
import wf.spring.short_link.utils.validators.annotation.Username;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AuthenticationRequestDTO {

    @NotNull
    @Username
    private String username;

    @NotNull
    @Password
    private String password;


}
