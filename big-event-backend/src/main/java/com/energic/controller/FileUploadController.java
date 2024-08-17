package com.energic.controller;

import com.energic.pojo.Result;
import com.energic.utils.AliOssUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@RestController
public class FileUploadController {

    @PostMapping("/upload")
    public Result<String> upload(MultipartFile file) throws Exception {
        final String originalFilename = file.getOriginalFilename();
        assert originalFilename != null;
        final String filename = UUID.randomUUID().toString() + originalFilename.substring(originalFilename.lastIndexOf("."));
        final String url = AliOssUtil.uploadFile(filename, file.getInputStream());
        return Result.success(url);
    }
}
