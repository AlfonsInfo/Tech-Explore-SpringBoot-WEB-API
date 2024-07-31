package group.bootcamp.technicaltest.common;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;

@Component
public class AuthenticationEntryPoint extends BasicAuthenticationEntryPoint {
    //prilaku saat gagal autentikasi
    @Autowired
    ObjectMapper objectMapper;

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
        response.addHeader("WWW-Authenticate", "Basic realm=" +getRealmName());
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType("application/json");
        PrintWriter writer = response.getWriter();
        LinkedHashMap<String, Object> obj = new LinkedHashMap<String, Object>();
        obj.put("status", "failed");
        obj.put("description", "Unauthorized");

        writer.println(new Gson().toJson(obj));
    }

    @Override
    public void afterPropertiesSet() {
        setRealmName("Learning");
        super.afterPropertiesSet();
    }
}
