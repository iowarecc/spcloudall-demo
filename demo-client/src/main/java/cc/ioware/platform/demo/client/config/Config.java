package cc.ioware.platform.demo.client.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration(Config.SERVICE_NAME)
@EnableFeignClients(basePackages = {"cc.ioware.platform.demo.client.client"})
public class Config {

    public final static String SERVICE_NAME = "demo-server";

}
