package voting.sys.election.rest.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import voting.sys.election.domain.entity.Users;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UsersDetailsService implements UserDetailsService {

    private final JwtService jwtService;

    @Override
    public UserDetails loadUserByUsername(String token) throws UsernameNotFoundException {
        String idnp = jwtService.extractUsername(token);
        Set<String> rolesSet = new HashSet<>(Arrays.asList(jwtService.extractRoles(token).split(",")));
        return new UsersDetails(new Users(idnp, rolesSet));
    }
}
