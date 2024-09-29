package tech.learn.master.demo.configuration;

import jakarta.servlet.http.HttpServletRequest;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;

@Component
public class AuditUserProvider implements AuditorAware<String> {

    private final HttpServletRequest request;

    @Autowired
    public AuditUserProvider(HttpServletRequest request) {
        this.request = request;
    }

    @Override
    @NonNull
    public Optional<String> getCurrentAuditor() {
        var authentication = request.getHeader("ID_USER");
        if (Objects.isNull(authentication)){
            return Optional.of("System");
        }
        return Optional.of(authentication);
    }
}
