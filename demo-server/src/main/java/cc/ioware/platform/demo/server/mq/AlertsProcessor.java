package cc.ioware.platform.demo.server.mq;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface AlertsProcessor {

    String P_ALERTS_ALL = "p-alerts-all";

    @Output(P_ALERTS_ALL)
    MessageChannel pAlertsAll();

    String P_ALERTS_CRITICAL_WARN = "p-alerts-critical-warn";

    @Output(P_ALERTS_CRITICAL_WARN)
    MessageChannel pAlertsCriticalWarn();

    String P_ALERTS_RATE_LIMIT = "p-alerts-rate_limit";

    @Output(P_ALERTS_RATE_LIMIT)
    MessageChannel pAlertsRateLimit();

    String C_ALERTS_CRTITICAL = "c-alerts-critical";

    @Input(C_ALERTS_CRTITICAL)
    SubscribableChannel cAlertsCritical();

    String C_ALERTS_RATE_LIMIT = "c-alerts-rate_limit";

    @Input(C_ALERTS_RATE_LIMIT)
    SubscribableChannel cAlertsRateLimit();

}
