package cc.ioware.platform.demo.client.health;

import com.netflix.appinfo.HealthCheckHandler;
import com.netflix.appinfo.InstanceInfo.InstanceStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

/**
 * 上报自己的健康状态
 */
@Component
public class MyHealthCheckHandler implements HealthCheckHandler {

    @Autowired
    MyHealthIndicator myHealthIndicator;

    @Override
    public InstanceStatus getStatus(InstanceStatus instanceStatus) {
        Status status = myHealthIndicator.health().getStatus();
        if (status.equals(Status.UP)) {
            return InstanceStatus.UP;
        } else {
            return InstanceStatus.DOWN;
        }
    }
}
