package group.learn.monitoring.custom;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

@Component
public class MyHealthIndicator extends AbstractHealthIndicator {
    @Override
    protected void doHealthCheck(Health.Builder builder) {
        builder.status(Status.UP);
        builder.withDetail("app", "ok");
        builder.withDetail("error", "no error");
    }
}
