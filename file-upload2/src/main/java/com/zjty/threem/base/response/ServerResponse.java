package com.zjty.threem.base.response;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

import static com.zjty.threem.base.response.ResponseCode.*;


/**
 * Description : 结果类,用于统一返回格式 对外提供关于响应结果的很多便利的静态方法
 *
 * @author : M@tr!x [xhyrzldf@foxmail.com]
 * @Date : 2017/12/13 0:05
 */
@SuppressWarnings({"WeakerAccess", "unused"})
@Getter
public class ServerResponse<T> {
    /**
     * 错误码
     */
    @JSONField(ordinal = 1)
    private Integer code;

    /**
     * 提示信息
     */
    @JSONField(ordinal = 2)
    private String msg;

    /**
     * 具体的内容
     */
    @JSONField(ordinal = 3)
    private T data;

  /* 以下为返回成功响应结果的各类重载静态方法 */

    public static <T> ServerResponse<T> success() {
        return new ServerResponse<>(OK.getCode(), OK.getMsg());
    }

    public static <T> ServerResponse<T> success(T data) {
        return new ServerResponse<>(OK.getCode(), OK.getMsg(), data);
    }

    public static <T> ServerResponse<T> success(String msg, T data) {
        return new ServerResponse<>(OK.getCode(), msg, data);
    }

    public static <T> ServerResponse<T> saveSuccess(T data) {
        return new ServerResponse<>(CREATED.getCode(), CREATED.getMsg(), data);
    }

    public static <T> ServerResponse<T> deleteSuccess() {
        return new ServerResponse<>(NO_CONTENT.getCode(), NO_CONTENT.getMsg());
    }

    public static <T> ServerResponse<T> deleteSuccessWithCount(Number effectCount) {
        return new ServerResponse<>(NO_CONTENT.getCode(), "删除成功,操作删除的数据条数为: " + effectCount);
    }
    public static <T> ServerResponse<T> deleteSuccessWithId(Number id) {
        return new ServerResponse<>(NO_CONTENT.getCode(), "删除成功,操作删除的数据id为: " + id);
    }

    public static <T> ServerResponse<T> uploadSuccess(T data) {
        return new ServerResponse<>(UPLOADED.getCode(), UPLOADED.getMsg(), data);
    }

    public static <T> ServerResponse<T> messageSuccess(String msg) {
        return new ServerResponse<>(OK.getCode(), msg);
    }

  /* 以下为返回失败响应结果的各类重载静态方法 */

    public static <T> ServerResponse<T> error() {
        return new ServerResponse<>(INTERNAL_SERVER_ERROR.getCode(), INTERNAL_SERVER_ERROR.getMsg());
    }

    public static <T> ServerResponse<T> error(String errorMessage) {
        return new ServerResponse<>(INTERNAL_SERVER_ERROR.getCode(), errorMessage);
    }

    public static <T> ServerResponse<T> error(ResponseCode responseCode) {
        return new ServerResponse<>(responseCode.getCode(), responseCode.getMsg());
    }

    public static <T> ServerResponse<T> error(ResponseCode responseCode, String errorMessage) {
        return new ServerResponse<>(responseCode.getCode(), errorMessage);
    }

    public static <T> ServerResponse<T> error(ResponseCode responseCode, String errorMessage,T data) {
        return new ServerResponse<>(responseCode.getCode(), errorMessage,data);
    }

    /* 将构造器私有,防止外部进行实例化 仅提供给内部静态方法调用 * */
    private ServerResponse() {
    }

    private ServerResponse(Integer code) {
        this.code = code;
    }

    private ServerResponse(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private ServerResponse(String msg, T data) {
        this.msg = msg;
        this.data = data;
    }

    private ServerResponse(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
