package spring.template.demo.common.security.authenticationprovider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import spring.template.demo.nonmasterdata.auth.entities.User;
import spring.template.demo.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String pwd = authentication.getCredentials().toString();
        List<User> users = userRepository.findByEmailOrUsername(username,username);
        if(!users.isEmpty()){
            if(passwordEncoder.matches(pwd, users.get(0).getPassword())){
                List<GrantedAuthority> authorities = new ArrayList<>();
                authorities.add(new SimpleGrantedAuthority("role"));
                return new UsernamePasswordAuthenticationToken(username,pwd,authorities);
            }
        } {
            throw new BadCredentialsException("");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return false;
    }
}
