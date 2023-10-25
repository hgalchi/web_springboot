package com.example.WebSpringboot.part04.Controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Controller
@RequestMapping("/file")
@Log4j2
public class controller {

    @Value("${ort.zerock.upload.path}")
    private String uploadPath;

    @PostMapping("/uploadAjax")
    public void uploadFile(@RequestPart MultipartFile[] uploadFiles) {

        for (MultipartFile m : uploadFiles) {
            String originalName = m.getOriginalFilename();
            String fileName = originalName.substring(originalName.lastIndexOf("\\") + 1);
            log.info("fileName" + fileName);

            String folderPath = makeFolder();

            String uuid = UUID.randomUUID().toString();

            String savename = uploadPath + File.separator + folderPath + File.separator + uuid + "_" + fileName;

            Path savePath = Paths.get(savename);

            try {
                m.transferTo(savePath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private String makeFolder(){
        String str = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));

        String folerPath = str.replace("//", File.separator);

        File uploadPathFoler=new File(uploadPath, File.separator);

        if (uploadPathFoler.exists() == false) {
            uploadPathFoler.mkdirs();
        }
        return folerPath;
    }
}
