package cc.ioware.platform.demo.server;

import cc.ioware.platform.demo.server.mq.AlertsProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableEurekaClient
@EnableAutoConfiguration
@EnableBinding({AlertsProcessor.class})
@EnableAsync
@EnableCaching
public class App {

    public static void main(String... args) {
        SpringApplication.run(App.class, args);
    }

}
