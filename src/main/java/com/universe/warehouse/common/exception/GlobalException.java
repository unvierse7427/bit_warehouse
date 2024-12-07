package com.universe.warehouse.common.exception;

import com.universe.warehouse.common.result.ResultCodeEnum;
import lombok.Data;

@Data
public class GlobalException extends RuntimeException {

    private Integer code;//状态码
    private String msg;//描述信息

    public GlobalException(Integer code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    /**
     * 接收枚举类型对象
     * @param resultCodeEnum
     */
    public GlobalException(ResultCodeEnum resultCodeEnum) {
        super(resultCodeEnum.getMessage());
        this.code = resultCodeEnum.getCode();
        this.msg = resultCodeEnum.getMessage();
    }

    @Override
    public String toString() {
        return "Exception{" +
                "code=" + code +
                ", message=" + this.getMessage() +
                '}';
    }
}
