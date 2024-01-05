package spring.template.demo.utils.security.imply;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import spring.template.demo.auth.entities.User;
import spring.template.demo.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;


@Service
public class CommunityUserDetails implements UserDetailsService {


    private final UserRepository userRepository;

    public CommunityUserDetails(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String userName;
        String password;
        List<GrantedAuthority> authorities;
        List<User> user = userRepository.findByEmailOrUsername(username,username);
        if(user.isEmpty()){
            throw new UsernameNotFoundException("Users Details Not Found for the user : " + username);
        }else{
            userName = user.get(0).getUsername();
            password = user.get(0).getPassword();
            authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority("user"));
        }
        return new org.springframework.security.core.userdetails.User(userName,password,authorities);
    }
}
