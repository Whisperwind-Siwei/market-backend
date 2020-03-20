package com.tongji.market.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.tongji.market.common.constant.ResultCode;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiResult {
    @Builder.Default
    private Integer code = ResultCode.SUCCESS.getCode();
    private String message;
    private Object data;

    private ApiResult setResult(ResultCode code, String message, Object data) {
        this.code = code.getCode();
        this.message = message;
        this.data = data;
        return this;
    }

    public ApiResult success() {
        return setResult(ResultCode.SUCCESS, "Success", null);
    }

    public ApiResult success(Object data) {
        return setResult(ResultCode.SUCCESS, "Success", data);
    }

    public ApiResult fail() {
        return setResult(ResultCode.FAILURE, "Fail", null);
    }

    public ApiResult fail(String message) {
        return setResult(ResultCode.FAILURE, message, null);
    }

    public static ApiResult wrap(boolean b) {
        if (b) {
            return new ApiResult().success();
        } else {
            return new ApiResult().fail();
        }
    }
}
