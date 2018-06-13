package cc.ioware.platform.demo.server.resources;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class ServerController {

    @RequestMapping("shutdown")
    @ResponseBody
    public ResponseEntity<String> shutdown() {
        log.info("安全清理服务中的组件");
        return new ResponseEntity<>("ok", HttpStatus.OK);
    }

}
