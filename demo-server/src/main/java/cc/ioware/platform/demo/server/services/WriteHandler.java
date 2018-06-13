package cc.ioware.platform.demo.server.services;

import cc.ioware.platform.demo.server.mq.AlertsProcessor;
import cc.ioware.platform.demo.server.pojo.Critical;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class WriteHandler {

    @Autowired
    AlertsProcessor processor;

    Logger logger = LoggerFactory.getLogger(WriteHandler.class);

    public void sendAll() {
        String data = "critical and rate_limit";
        Message<String> message = MessageBuilder.withPayload(data).build();
        logger.info("SEND: all: " + data);
        processor.pAlertsAll().send(message);
    }

    public void sendCritical() {
        String data = "critical only";
        Message<String> message = MessageBuilder.withPayload(data).build();
        logger.info("SEND: critical: " + data);
        processor.pAlertsCriticalWarn().send(message);
    }

    public void sendRateLimit() {
        String data = "rate limit only";
        Message<String> message = MessageBuilder.withPayload(data).build();
        logger.info("SEND: rate limit: " + data);
        processor.pAlertsRateLimit().send(message);
    }

}
