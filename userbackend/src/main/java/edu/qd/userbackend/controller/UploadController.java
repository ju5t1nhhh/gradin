package edu.qd.userbackend.controller;

import edu.qd.userbackend.vo.RestResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

@RestController
@RequestMapping("/upload")
@CrossOrigin
public class UploadController {

    @Value("${prop.upload-folder}")
    private String UPLOAD_FOLDER;

    @PostMapping("/up")
    public RestResponse upload(MultipartFile file) {
        if ( Objects.isNull(file) || file.isEmpty() ) {
            return RestResponse.errorWithMsg(1902, "请重新上传");
        }
        System.out.println("file in");
        try {

            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOAD_FOLDER + file.getOriginalFilename());

            if (!Files.isWritable(path)) {
                Files.createDirectories(Paths.get(UPLOAD_FOLDER));
            }
            Files.write(path, bytes);
            System.out.println(path.getFileName());
            return RestResponse.successWithData("上传成功", path.getFileName());

        } catch (IOException e) {
            return RestResponse.errorWithMsg(1099, "请稍后重试");
        }
    }

}
