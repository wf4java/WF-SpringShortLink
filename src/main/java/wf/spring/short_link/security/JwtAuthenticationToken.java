package wf.spring.short_link.security;

import jakarta.annotation.Nullable;
import lombok.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.Collections;

@Getter
@Setter
@RequiredArgsConstructor
public class JwtAuthenticationToken implements Authentication {


    private final String jwtKey;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }

    @Override
    public String getCredentials() {
        return jwtKey;
    }

    @Override
    @Nullable
    public Object getDetails() {
        return null;
    }

    @Override
    @Nullable
    public Object getPrincipal() {
        return null;
    }

    @Override
    public boolean isAuthenticated() {
        return false;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {

    }

    @Override
    @Nullable
    public String getName() {
        return null;
    }
}
