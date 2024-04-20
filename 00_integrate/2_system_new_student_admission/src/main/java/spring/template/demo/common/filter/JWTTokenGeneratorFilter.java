package spring.template.demo.common.filter;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import spring.template.demo.common.constant.Constant;

import javax.crypto.SecretKey;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class JWTTokenGeneratorFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Date timeIssued = new Date();
        Date timeExpiration = new Date(timeIssued.getTime() + 300000);
        if(null != authentication) {
            SecretKey key = Keys.hmacShaKeyFor(Constant.SecurityConstant.SECRET_KEY.getBytes(StandardCharsets.UTF_8));
            String jwt = Jwts.builder().setIssuer("PSSB Apps").setSubject("JWT Tokens")
                    .claim("username", authentication.getName())
                    .claim("authorities", populateAuthorities(authentication.getAuthorities()))
                    .setIssuedAt(timeIssued)
                    .setExpiration(timeExpiration)
                    .signWith(key).compact();
            response.setHeader(Constant.SecurityConstant.HTTP_HEADER_KEY,jwt);
        }

        filterChain.doFilter(request,response);
    }


    @Override
    protected boolean shouldNotFilter(HttpServletRequest request){
        Set<String> allowedPath = Set.of(
                Constant.EndPoint.FAQ,
                Constant.EndPoint.FULL_LOGIN,
                Constant.EndPoint.FULL_REGISTER
        );
        return !allowedPath.contains(request.getServletPath());
    }

    private String populateAuthorities(Collection<? extends GrantedAuthority> collections){
        Set<String> authoritiesSet = new HashSet<>();
        for(GrantedAuthority authority : collections){
            authoritiesSet.add(authority.getAuthority());
        }
        return String.join(",", authoritiesSet);
    }
}
