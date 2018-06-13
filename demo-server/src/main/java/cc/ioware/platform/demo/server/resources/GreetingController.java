package cc.ioware.platform.demo.server.resources;

import cc.ioware.platform.demo.lib.bo.AlphaPayload;
import cc.ioware.platform.demo.lib.bo.BetaPayload;
import cc.ioware.platform.demo.server.services.WriteHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@Controller
@RequestMapping("/v1/greeting")
public class GreetingController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    WriteHandler writeHandler;

    @RequestMapping(value = "welcome/{name}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> welcome(@PathVariable("name") String name) {
        logger.info("welcome request");
        return new ResponseEntity<>("hello, ".concat(name), HttpStatus.OK);
    }


    @RequestMapping(value = "payload/alpha", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> payload(@RequestBody AlphaPayload payload) {
        logger.info("ok, " + payload);
        writeHandler.sendAll();
        return new ResponseEntity<>("hello, ".concat(payload.toString()), HttpStatus.OK);
    }

    @RequestMapping(value = "payload/beta", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> payload(@RequestBody BetaPayload payload) {
        logger.info("ok, " + payload);
        Random r = new Random();
        if (r.nextInt() % 2 == 0) {
            writeHandler.sendCritical();
        } else {
            writeHandler.sendRateLimit();
        }
        return new ResponseEntity<>("hello, ".concat(payload.toString()), HttpStatus.OK);
    }

}
