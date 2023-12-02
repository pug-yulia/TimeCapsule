package com.project.TimeCapsule.controller;
/*
 * import java.io.IOException;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.http.HttpStatus; import
 * org.springframework.http.MediaType; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.PathVariable; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RequestParam; import
 * org.springframework.web.bind.annotation.RestController; import
 * org.springframework.web.multipart.MultipartFile; import
 * org.springframework.http.HttpHeaders;
 * 
 * 
 * import com.project.TimeCapsule.service.ImageService;
 * 
 * @RestController
 * 
 * @RequestMapping("/images") public class ImageController {
 * 
 * @Autowired private ImageService imageService;
 * 
 * @PostMapping("/upload") public ResponseEntity<String>
 * uploadImage(@RequestParam("file") MultipartFile file) throws IOException {
 * String fileName = imageService.uploadImage(file);F return
 * ResponseEntity.ok(fileName); }
 * 
 * @GetMapping("/download/{fileName}") public ResponseEntity<byte[]>
 * downloadImage(
 * 
 * @PathVariable String fileName,
 * 
 * @RequestParam(required = false) String format ) throws IOException { byte[]
 * imageData = imageService.downloadImage(fileName); HttpHeaders headers = new
 * HttpHeaders();
 * 
 * if ("png".equalsIgnoreCase(format)) {
 * headers.setContentType(MediaType.IMAGE_PNG); } else if
 * ("gif".equalsIgnoreCase(format)) {
 * headers.setContentType(MediaType.IMAGE_GIF); } else { // Default to JPEG if
 * no or unrecognized format is specified
 * headers.setContentType(MediaType.IMAGE_JPEG); }
 * 
 * return new ResponseEntity<>(imageData, headers, HttpStatus.OK); } }
 */