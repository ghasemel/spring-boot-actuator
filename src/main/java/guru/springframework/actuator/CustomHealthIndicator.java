package guru.springframework.actuator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Component
public class CustomHealthIndicator implements HealthIndicator {
    Map<String, Object> detail = new HashMap<>();

    public CustomHealthIndicator() {
        detail.put("ERR-001", "Random failure");
    }

    @Override
    public Health health() {
        Random random = new Random();
        if (random.nextBoolean()) {
            return Health.down().withDetails(detail).build();
        }
        return Health.up().build();
    }
}
