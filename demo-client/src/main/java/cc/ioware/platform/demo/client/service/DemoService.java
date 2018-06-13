package cc.ioware.platform.demo.client.service;

import cc.ioware.platform.demo.client.client.DemoClient;
import cc.ioware.platform.demo.lib.bo.AlphaPayload;
import cc.ioware.platform.demo.lib.bo.BetaPayload;
import cc.ioware.platform.demo.lib.bo.IPayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoService {
    @Autowired
    DemoClient demoClient;

    public String welcome(String name) {
        String r = demoClient.welcome(name);
        return r;
    }

    public String payload(String cmd, IPayload payload) {
        if(cmd.equals("alpha")) {
            return demoClient.payload((AlphaPayload)payload);
        }else if(cmd.equals("beta")) {
            return demoClient.payload((BetaPayload) payload);
        }
        return "nothing";
    }
}
