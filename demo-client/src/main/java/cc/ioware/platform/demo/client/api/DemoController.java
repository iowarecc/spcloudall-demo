package cc.ioware.platform.demo.client.api;

import cc.ioware.platform.demo.client.service.DemoService;
import cc.ioware.platform.demo.lib.bo.AlphaPayload;
import cc.ioware.platform.demo.lib.bo.BetaPayload;
import cc.ioware.platform.demo.lib.bo.IPayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Configuration
public class DemoController {

    @Autowired
    DemoService demoService;

    @RequestMapping(value = "/invokeHello", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseEntity<String> hello() {
        String r = demoService.welcome("cccc");
        if (r != null) {
            return new ResponseEntity<>(r, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/invokeA", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> a() {
        IPayload p = new AlphaPayload();
        String r = demoService.payload("alpha", p);
        if (r != null) {
            return new ResponseEntity<>(r, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/invokeB", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> b() {
        IPayload p = new BetaPayload();
        String r = demoService.payload("beta", p);
        if (r != null) {
            return new ResponseEntity<>(r, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
