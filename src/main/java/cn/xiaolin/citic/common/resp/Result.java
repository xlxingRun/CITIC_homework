package cn.xiaolin.citic.common.resp;

import cn.xiaolin.citic.enums.ResponseCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @author xingxiaolin xlxing@bupt.edu.cn
 * @Description
 * @create 2023/11/15
 */

@Data
@Builder
@AllArgsConstructor
public class Result<T> {
    /**
     * 返回状态码
     */
    private Integer code;
    private String msg;
    private T data;

    public Result(T data) {
        this.code = ResponseCode.SUCCESS.getCode();
        this.msg = ResponseCode.SUCCESS.getMsg();
        this.data = data;
    }

    public Result() {
        this.code = ResponseCode.SUCCESS.getCode();
        this.msg = ResponseCode.SUCCESS.getMsg();
    }

    public static <T> Result<T> ok(T data) {
        return new Result<>(data);
    }

    public static <T> Result<T> ok() {
        return new Result<>();
    }

    public static <T> Result<T> error() {
        return new Result<>(ResponseCode.ERROR.getCode(), ResponseCode.ERROR.getMsg(), null);
    }


    public static <T> Result<T> error(Integer code, String msg) {
        return new Result<>(code, msg, null);
    }

    public static <T> Result<T> notFound() {
        return new Result<>(ResponseCode.NOT_FOUND.getCode(), ResponseCode.NOT_FOUND.getMsg(), null);
    }

    public static <T> Result<T> duplicateResource() {
        return new Result<>(ResponseCode.DUPLICATE_RESOURCE.getCode(), ResponseCode.DUPLICATE_RESOURCE.getMsg(), null);
    }

    public static <T> Result<T> badRequest() {
        return new Result<>(ResponseCode.BAD_REQUEST.getCode(), ResponseCode.BAD_REQUEST.getMsg(), null);
    }

    public static <T> Result<T> serverError() {
        return new Result<>(ResponseCode.ERROR.getCode(), ResponseCode.ERROR.getMsg(), null);
    }
    public static <T> Result<T> error(String msg) {
        return new Result<>(ResponseCode.ERROR.getCode(), msg, null);
    }
}
