package edu.qd.userbackend.controller;

import edu.qd.userbackend.vo.RestResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
public class UploadController {

    @Value("${img.upload-path}")
    private String uploadPath;

    @Value("${img.img-url}")
    private String imgUrl;


    @PostMapping("/upload")
    public RestResponse upload(HttpServletRequest request) {
        List<MultipartFile> files=((MultipartHttpServletRequest) request).getFiles("file");
        List<String> urls = new ArrayList<>();
        if ( files.size() == 0 ) {
            return RestResponse.errorWithMsg(110101,"图片不能为空");
        }
        try {
            for ( MultipartFile file : files ) {
                String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
                String filename = new Date().getTime() + suffix;
                Files.write(Paths.get(uploadPath + filename), file.getBytes());
                urls.add(imgUrl + filename);
            }
        } catch ( Exception e ) {
            return RestResponse.errorWithMsg(301,"上传出错");
        }
        return RestResponse.successWithData("上传成功", urls);
//        if ( Objects.isNull(file) || file.isEmpty() ) {
//            return RestResponse.errorWithMsg(1902, "请重新上传");
//        }
//        System.out.println("file in");
//        try {
//
//            byte[] bytes = file.getBytes();
//            Path path = Paths.get(UPLOAD_FOLDER + file.getOriginalFilename());
//
//            if (!Files.isWritable(path)) {
//                Files.createDirectories(Paths.get(UPLOAD_FOLDER));
//            }
//            Files.write(path, bytes);
//            System.out.println(path.getFileName());
//            return RestResponse.successWithData("上传成功", path.getFileName());
//
//        } catch (IOException e) {
//            return RestResponse.errorWithMsg(1099, "请稍后重试");
//        }
    }

}
