package cc.ioware.platform.demo.client.client;

import cc.ioware.platform.demo.lib.bo.AlphaPayload;
import cc.ioware.platform.demo.lib.bo.BetaPayload;
import cc.ioware.platform.demo.lib.bo.IPayload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "demo-server", fallback = DemoClient.DemoClientFallback.class)
public interface DemoClient {

    Logger logger = LoggerFactory.getLogger(DemoClient.class);

    @RequestMapping(value = "/v1/greeting/welcome/{name}", method = RequestMethod.GET)
    String welcome(@PathVariable("name") String name);

    @RequestMapping(value = "/v1/greeting/payload/alpha", method = RequestMethod.POST)
    @ResponseBody
    String payload(@RequestBody AlphaPayload payload);

    @RequestMapping(value = "/v1/greeting/payload/beta", method = RequestMethod.POST)
    @ResponseBody
    String payload(@RequestBody BetaPayload payload);

    @Component
    class DemoClientFallback implements DemoClient {

        @Override
        public String welcome(String name) {
            logger.error("无法正常访问 demo-server");
            return "error here";
        }

        @Override
        public String payload(AlphaPayload payload) {
            logger.error("无法正常访问 demo-server");
            return "error alpha";
        }

        @Override
        public String payload(BetaPayload payload) {
            logger.error("无法正常访问 demo-server");
            return "error beta";
        }
    }
}
