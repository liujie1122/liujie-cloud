package com.zjty.threem.server.controller;

import com.alibaba.fastjson.JSON;
import com.zjty.threem.base.response.ResponseCode;
import com.zjty.threem.base.response.ServerResponse;
import com.zjty.threem.config.classicConverter.LogIpConfig;
import com.zjty.threem.result.Result;
import com.zjty.threem.utils.UUIDUtils;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.ClassUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.*;
import java.net.InetAddress;
//import java.net.URL;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.Properties;

@RestController
@RequestMapping("/file")
public class FileUpLoadController {
    /**
     * 日志
     */
    private Logger logger = LoggerFactory.getLogger(FileUpLoadController.class);

    @Autowired
    private LogIpConfig logIpConfig;

    @Value("${upload.location}")
    private String uploadPath;
    @Value("${server.port}")
    private String port;
    @Value("${local.host}")
    private String localHost;


    @GetMapping("/he")
    public String he(){
        return uploadPath;
    }

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


    /**
     * 无效
     * @param file
     * @return
     */
    public String singleFileUpload1(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {
        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            logger.info("Please select a file to upload");
            return "redirect:uploadStatus";
        }
        String host = null;
        try {
            host = InetAddress.getLocalHost().getHostAddress();
        } catch (Exception e) {
            logger.error("get server host Exception e:", e);
        }
        logger.info("host=============:"+host);

        try {
            String path1 = ResourceUtils.getURL("classpath:").getPath();
            logger.info("path1============"+path1);

            //获取跟目录
            File path2=new File(ResourceUtils.getURL("classpath:").getPath());
            if(!path2.exists()){
                path2=new File("");
            }
//如果上传目录为/static/images/upload/,则可以如下获取
            File upload=new File(path2.getAbsolutePath(),"static/images/uplaod/");
            if(!upload.exists()) {
                upload.mkdirs();
                System.out.println(upload.getAbsolutePath());
                //在开发测试模式时，得到地址为：{项目跟目录}/target/static/images/upload/
                //在打成jar正式发布时，得到的地址为:{发布jar包目录}/static/images/upload/
            }


            String name = file.getOriginalFilename();
            logger.info("name========="+name);
            String[] split = StringUtils.split(name, ".");
            logger.info("split===="+ JSON.toJSONString(split));
            int length1 = split.length;
            logger.info("length1===="+ length1);
            String fileType = split[length1 - 1];
            //获取输入流
            BufferedInputStream bis = new BufferedInputStream(file.getInputStream());
//            byte[] bytes = file.getBytes();
            // 获得文件的唯一文件名:
            String uuidFileName = UUIDUtils.getUUIDFileName(file.getOriginalFilename());
            uuidFileName = uuidFileName+"."+fileType;
            logger.info("uuidFileName==="+uuidFileName);
            //拼接文件上传地址
            String userImageURL = uploadPath + "/" + uuidFileName;
            File file1 = new File(userImageURL);
            String path = file1.getPath();
            logger.info("path==="+path);
            OutputStream outputStream = new FileOutputStream(file1);// 创建文件输出流
            int length = 0;
            byte[] buf = new byte[1024 * 8];//缓冲区
            while ((length = bis.read(buf)) != -1){
                outputStream.write(buf,0,length);
                outputStream.flush();
            }
            outputStream.flush();
            outputStream.close();
            bis.close();
//            printWriter.println(ResultFactory.userImageURLResult(userImageURL));
            String url = "http://" + host + ":" + port + "/uploads/" + uuidFileName;
            logger.info("You successfully uploaded url =========" + url);

        } catch (Exception e) {
            e.printStackTrace();
            logger.error("e"+e.toString());
        }


        return "redirect:/uploadStatus";
    }

    /**
     * 无效
     * @param file
     * @return
     */
    public String singleFileUpload2(@RequestParam("file") MultipartFile file) {
        String host = null;
        try {
            //获取跟目录
            String path2 = ClassUtils.getDefaultClassLoader().getResource("").getPath();
            logger.info("path2=========="+path2);
            File parentFile = new File(path2).getParentFile().getParentFile().getParentFile();
            String path = parentFile.getPath();
            logger.info("path=========="+path);
            String[] split1 = StringUtils.split(path, ":/");
            logger.info("split1========="+JSON.toJSONString(split1));
            path = split1[1];
            logger.info("path=========="+path);

            //如果上传目录为/static/uploads/,则可以如下获取
            String absolutePath = path + "/static/uplaods/";
            logger.info("absolutePath==="+absolutePath);
            File upload=new File(absolutePath);
            File realPathFile = new File(absolutePath);
            if(!realPathFile.exists()){
                //不存在就创建
                realPathFile.mkdirs();
            }
            if(!upload.exists()) {
                upload.mkdirs();
                logger.info("文件夹不存在upload.getPath()============="+upload.getPath());
                //在开发测试模式时，得到地址为：{项目跟目录}/target/static/uploads/
                //在打成jar正式发布时，得到的地址为:{发布jar包目录}/static/uploads/
            }else {
                logger.info("文件夹已存在upload.getPath()============="+upload.getPath());
            }


            host = InetAddress.getLocalHost().getHostAddress();
            logger.info("host=============:"+host);
            //原文件名
            String name = file.getOriginalFilename();
            String[] split = StringUtils.split(name, ".");
            int length1 = split.length;
//            获取文件类型
            String fileType = split[length1 - 1];
            //获取跟目录
            // 获得文件的唯一文件名:
            String uuidFileName = UUIDUtils.getUUIDFileName(file.getOriginalFilename());
            uuidFileName = uuidFileName+"."+fileType;
            logger.info("uuidFileName======="+uuidFileName);
            absolutePath = absolutePath + "/" + uuidFileName;
            logger.info("absolutePath======="+absolutePath);
            File file1 = new File(absolutePath);
            logger.info("file1.getPath()======="+file1.getPath());

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


//            file.transferTo(file1);
            String url = "http://" + host + ":" + port + "/static/uplaods/" + uuidFileName;
//            String url = "http://" + "192.168.1.249" + ":" + port + "/static/uplaods/" + uuidFileName;
            logger.info("======url======" + url);
            return url;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("e"+e.getMessage()+"e.toString()"+e.toString());
            return "false!!!!!!!!!!!";
        }
    }
}
