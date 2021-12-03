package cn.jaylong.core.validate;

import cn.jaylong.core.exception.BizException;
import lombok.experimental.UtilityClass;

import javax.validation.ConstraintViolation;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * Author: I'm
 * Date: 2021/11/16
 */
@UtilityClass
public class ValidationUtil extends cn.hutool.extra.validation.ValidationUtil {

    public <T> Set<ConstraintViolation<T>> validate(T bean, Class<?>... groups) {
        Set<ConstraintViolation<T>>  violations = getValidator().validate(bean, groups);
        if (violations.size() > 0){
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("参数验证失败=>");
            for (ConstraintViolation<T> violation :
                    violations) {
                stringBuilder.append(violation.getPropertyPath());
                stringBuilder.append(":");
                stringBuilder.append(violation.getMessage());
                stringBuilder.append(";");
            }
            throw new BizException("109993001",stringBuilder.toString());
        }
        return violations;
    }

}
