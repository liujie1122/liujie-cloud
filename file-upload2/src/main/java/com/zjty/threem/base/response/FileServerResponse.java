package com.zjty.threem.base.response;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Description : file-server
 * Date : 2018/1/9 16:04
 *
 * @author : M@tr!x [xhyrzldf@foxmail.com]
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileServerResponse<T> {
    /**
     * 错误码
     */
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

}
