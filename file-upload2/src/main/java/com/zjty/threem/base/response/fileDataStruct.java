package com.zjty.threem.base.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Description : 文件服务器上传的返回数据类
 * Date : 2018/1/9 16:16
 *
 * @author : M@tr!x [xhyrzldf@foxmail.com]
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class fileDataStruct {

    /**
     * 原始文件名
     */
    private String originalFileName;

    /**
     * 在服务器中的文件名
     */
    private String serverFileName;

    /**
     * 服务器中的文件路径
     */
    private String serverFilePath;
}
