package com.universe.warehouse.common.exception;


import com.universe.warehouse.common.result.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;


@ControllerAdvice
public class GlobalExceptionHandler {

    //全局异常处理，执行的方法
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result error(Exception e) {
        e.printStackTrace();
        return Result.fail().message("执行全局异常处理...");
    }


    //自定义异常处理
    @ExceptionHandler(GlobalException.class)
    @ResponseBody
    public Result error(GlobalException e) {
        e.printStackTrace();
        return Result.fail().code(e.getCode()).message(e.getMsg());
    }


    //自定义异常处理
    @ExceptionHandler(IOException.class)
    @ResponseBody
    public Result error(IOException e) {
        e.printStackTrace();
        return Result.fail().message("导入Excel表格异常,请检查Excel表格字段");
    }

}
