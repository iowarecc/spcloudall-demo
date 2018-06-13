package cc.ioware.platform.demo.lib.bo;

import lombok.Data;

@Data
public class BetaPayload implements IPayload {

    private Integer id = 42;
    private String desc = "test";

}
