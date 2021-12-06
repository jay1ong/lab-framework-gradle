package cn.jaylong.test.model;

import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

/**
 * Created by IntelliJ IDEA.
 * Author: I'm
 * Date: 2021/11/16
 */
@Builder
@Data
public class UserValidatorModel {

    @NotBlank
    @Length(min = 6,max = 12)
    String username;

    @Length(min = 6,max = 12)
    String password;

}
