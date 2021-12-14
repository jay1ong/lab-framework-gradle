package cn.jaylong.test.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

/**
 * Created by IntelliJ IDEA.
 * Author: I'm
 * Date: 2021/11/16
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserValidatorModel {

    @NotBlank
    @Length(min = 6,max = 12)
    String username;

    @Length(min = 6,max = 12)
    String password;

}
