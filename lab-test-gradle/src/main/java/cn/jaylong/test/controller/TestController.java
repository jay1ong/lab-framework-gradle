package cn.jaylong.test.controller;

import cn.jaylong.core.validate.ValidationUtil;
import cn.jaylong.snowflake.Snowflake;
import cn.jaylong.test.model.UserValidatorModel;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.common.IdentifierFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * Author: I'm
 * Date: 2021/11/16
 */
@RestController
@Slf4j
@AllArgsConstructor
public class TestController {

    private final Snowflake snowflake;

    @GetMapping("test")
    public String test() {
        return "test";
    }

    @GetMapping("test1")
    public String test1() {
        return "test1";
    }

    @GetMapping("validate")
    public boolean validate(@RequestParam String username, @RequestParam String password) {
        UserValidatorModel model = UserValidatorModel
                .builder()
                .username(username)
                .password(password)
                .build();
        ValidationUtil.validate(model);
        return true;
    }

    @GetMapping("/snowflake/id")
    public String leafId() {
        return snowflake.nextIdStr();
    }

    @GetMapping("/axon/id")
    public String axonId() {
        return IdentifierFactory.getInstance().generateIdentifier();
//        return snowflakeIdentifierFactory.generateIdentifier();
    }

}
