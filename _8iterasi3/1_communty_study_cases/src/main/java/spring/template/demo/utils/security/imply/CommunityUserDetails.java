package spring.template.demo.utils.security.imply;

import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String userName,password = null;
        List<GrantedAuthority> authorities = null;
        List<User> user = userRepository.findByEmailOrUsername(username,username);
        if(user.size() == 0){
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
