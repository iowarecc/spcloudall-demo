package cc.ioware.platform.demo.client.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MyHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        Status status = Status.UP;
        Map<String, String> x = new HashMap<>();
        x.put("a", "1");
        x.put("b", "2");
        return new Health.Builder(status, x).build();
    }
}
