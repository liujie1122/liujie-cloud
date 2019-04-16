package com.liujie.upload.controller;

import com.liujie.upload.base.response.ResponseCode;
import com.liujie.upload.base.response.ServerResponse;
import com.liujie.upload.result.Result;
import com.liujie.upload.utils.UUIDUtils;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

@Api(description = "文件上传接口")
@RestController
@RequestMapping("/file")
public class FileUpLoadController {
    /**
     * 日志
     */
    private Logger logger = LoggerFactory.getLogger(FileUpLoadController.class);

//    @Autowired
//    private LogIpConfig logIpConfig;

    @Value("${upload.location}")
    private String uploadPath;
    @Value("${server.port}")
    private String port;
    @Value("${local.host}")
    private String localHost;

    @PostMapping("/upload")
    public ServerResponse fileUpload(@RequestParam("file") MultipartFile file) {
        try {
            //如果上传目录为/static/uploads/,则可以如下获取
//            File realPathFile = new File("static/uplaods/");
            File realPathFile = new File(uploadPath);
            if(!realPathFile.exists()){
                //不存在就创建
                realPathFile.mkdirs();
            }
            //原文件名
            String name = file.getOriginalFilename();
            String[] split = StringUtils.split(name, ".");
            int length1 = split.length;
//            获取文件类型
            String fileType = split[length1 - 1];
            //获取跟目录
            // 获得文件的唯一文件名:
            String uuidFileName = UUIDUtils.getUUIDFileName(file.getOriginalFilename()) +"."+fileType;
            logger.info("文件名：uuidFileName======="+uuidFileName);
            String absolutePath = uploadPath + uuidFileName;
            File file1 = new File(absolutePath);
            logger.info("file1"+file1.getAbsolutePath());
            logger.info("file1"+file1.getCanonicalPath());
            logger.info("file1"+file1.getParent());
            logger.info("file1"+file1.getPath());
            logger.info("文件路径：file1.getPath()======="+file1.getPath());
            OutputStream outputStream = new FileOutputStream(file1);// 创建文件输出流
            int length = 0;
            byte[] buf = new byte[1024 * 8];//缓冲区
            //获取输入流
            BufferedInputStream bis = new BufferedInputStream(file.getInputStream());
            while ((length = bis.read(buf)) != -1){
                outputStream.write(buf,0,length);
                outputStream.flush();
            }
            outputStream.flush();
            outputStream.close();
            bis.close();
            String url = "http://" + localHost + ":" + port + "/" + uploadPath + uuidFileName;
            Result<String> result = new Result<String>();
            result.setData(url);
            result.setResult(true);
            return ServerResponse.success(result);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("e"+e.getMessage()+"e.toString()"+e.toString());
            Result<String> result = new Result<>();
            result.setData("文件上传失败，请稍后重试！！！");
            result.setResult(false);
            return ServerResponse.error(ResponseCode.UNAUTHORIZED,"文件上传失败，请稍后重试！！！",result);
        }
    }

}
