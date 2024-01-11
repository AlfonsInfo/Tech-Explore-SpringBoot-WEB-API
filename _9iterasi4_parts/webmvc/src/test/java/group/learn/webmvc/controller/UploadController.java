package group.learn.webmvc.controller;

import group.learn.webmvc.data.EndPointConstant;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@RestController
public class UploadController {

    @PostMapping(value = EndPointConstant.UPLOAD, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String upload(@RequestPart(name = "profile")MultipartFile profile) throws IOException {
        Path path = Path.of("/upload" + profile.getOriginalFilename());
        Files.write(path, profile.getBytes());
        return "success";
    }
}
