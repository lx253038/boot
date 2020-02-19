package com.mybatis.boot.exception;

import com.mybatis.boot.util.ResultUtil;
import com.mybatis.boot.vo.LayuiResult;
import org.hibernate.validator.internal.engine.path.PathImpl;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.*;

/**
 * @Author LX
 * @Date 2020/2/19 10:20
 * @Description
 */
@ControllerAdvice
@ResponseBody
public class GlobalException {


    /**
     * 参数校验异常捕获
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(value = ConstraintViolationException.class)
    public LayuiResult ConstraintViolationExceptionHandler(ConstraintViolationException ex) {
        Set<ConstraintViolation<?>> errors = ex.getConstraintViolations();
        Iterator<ConstraintViolation<?>> iterator = errors.iterator();
        List<String> msgList = new ArrayList<>();
        while (iterator.hasNext()) {
            ConstraintViolation<?> violation = iterator.next();
            PathImpl propertyPath = (PathImpl) violation.getPropertyPath();
            msgList.add(propertyPath.getLeafNode() + violation.getMessage());
        }
        return ResultUtil.error(500, msgList.toString());

    }
}
