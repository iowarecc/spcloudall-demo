package cc.ioware.platform.demo.server.services;

import cc.ioware.platform.demo.server.mq.AlertsProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Component
public class ReadHandler {
    Logger logger = LoggerFactory.getLogger(ReadHandler.class);

    @StreamListener(AlertsProcessor.C_ALERTS_CRTITICAL)
    public void read1(String data) {
        Long threadId = Thread.currentThread().getId();
        logger.info("RECV: critical: " + data+", thread: "+ threadId);
    }

    @StreamListener(AlertsProcessor.C_ALERTS_RATE_LIMIT)
    public void read2(String data) {
        Long threadId = Thread.currentThread().getId();
        logger.info("RECV: rate_limit: " + data +", thread: "+ threadId);
    }

}
