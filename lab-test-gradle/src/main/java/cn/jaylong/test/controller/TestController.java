package cn.jaylong.test.controller;

import cn.hutool.core.convert.Convert;
import cn.jaylong.core.validate.ValidationUtil;
import cn.jaylong.test.model.UserValidatorModel;
import cn.jaylong.web.OriginResponse;
import com.sankuai.inf.leaf.service.SnowflakeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * Author: I'm
 * Date: 2021/11/16
 */
@RestController
@OriginResponse
@Slf4j
@AllArgsConstructor
public class TestController {

    private final SnowflakeService snowflakeService;

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

    @GetMapping("/leaf/id")
    public String leafId() {
        return Convert.toStr(snowflakeService.getId("id").getId());
    }

}
