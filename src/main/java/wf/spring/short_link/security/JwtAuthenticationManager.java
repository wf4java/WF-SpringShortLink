package wf.spring.short_link.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import wf.spring.short_link.services.JwtAuthService;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationManager implements AuthenticationManager {

    private final JwtAuthService jwtAuthService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        if(!(authentication instanceof JwtAuthentication)) throw new AuthenticationServiceException("Authentication is not JwtAuthentication");

        return jwtAuthService.getAuthenticatedOrFail(((String) authentication.getCredentials()));
    }

}
