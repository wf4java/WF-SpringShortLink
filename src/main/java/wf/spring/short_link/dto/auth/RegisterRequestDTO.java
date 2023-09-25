package wf.spring.short_link.dto.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RegisterRequestDTO {

    @NotNull
    //@Username
    private String username;

    @NotNull
    @NotEmpty
    @Email
    private String email;

    @NotNull
    //@Password
    private String password;





}