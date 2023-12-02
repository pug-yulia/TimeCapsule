package com.project.TimeCapsule.service;
/*
 * import com.project.TimeCapsule.domain.*;
 * 
 * import org.springframework.beans.factory.annotation.Value; import
 * org.springframework.stereotype.Service; import
 * org.springframework.web.multipart.MultipartFile; import
 * org.springframework.stereotype.Service; import
 * org.springframework.util.Base64Utils;
 * 
 * import java.io.IOException; import java.nio.file.Files; import
 * java.nio.file.Paths; import java.nio.file.StandardCopyOption; import
 * java.util.List; import java.util.UUID;
 * 
 * @Service public class ImageService {
 * 
 * @Value("${app.upload-dir}") private String uploadDir;
 * 
 * public String uploadImage(MultipartFile file) throws IOException { String
 * fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
 * String filePath = Paths.get(uploadDir, fileName).toString();
 * 
 * Files.copy(file.getInputStream(), Paths.get(filePath),
 * StandardCopyOption.REPLACE_EXISTING); return fileName; }
 * 
 * public byte[] downloadImage(String fileName) throws IOException { String
 * filePath = Paths.get(uploadDir, fileName).toString(); return
 * Files.readAllBytes(Paths.get(filePath)); }
 * 
 * }
 * 
 */