package zr.spring_boot.my_portfolio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import zr.spring_boot.my_portfolio.model.ImageData;
import zr.spring_boot.my_portfolio.service.ImageDataService;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class ImageDataController {

    @Autowired
    private ImageDataService service;

    @PostMapping("/image")
    public ResponseEntity<?> uploadImage(@RequestParam("image") MultipartFile file, @RequestParam String description) throws IOException {
        String uploadImage = service.uploadImage(file, description);
        return ResponseEntity.status(HttpStatus.OK)
                    .body(uploadImage);
    }

    @GetMapping("/image/{id}")
    public ResponseEntity<byte[]> downloadImages(@PathVariable int id){
        Optional<ImageData> imageOptional = service.getImageById(id);
        if(!imageOptional.isPresent()){
            return ResponseEntity.notFound().build();
        }else {
            ImageData imageData = imageOptional.get();
            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType(imageData.getImageType()))
                    .body(imageData.getImageData());
        }
    }
}
