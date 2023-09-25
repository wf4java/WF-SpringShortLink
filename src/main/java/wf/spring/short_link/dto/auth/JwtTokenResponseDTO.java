package wf.spring.short_link.dto.auth;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class JwtTokenResponseDTO {

    private String jwtToken;

}