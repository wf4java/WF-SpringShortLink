package wf.spring.short_link.security;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationConverter;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class JwtAuthenticationConverter implements AuthenticationConverter {


    @Override
    public Authentication convert(HttpServletRequest request) {

        String authHeader = request.getHeader("Authorization");

        if(authHeader == null || authHeader.isBlank()) return null;
        if(!authHeader.startsWith("Bearer ")) return null;

        String jwt = authHeader.substring(7);
        if(jwt.isBlank()) return null;

        try { return new JwtAuthenticationToken(jwt); }
        catch (AuthenticationException e) { return null; }

    }

}
