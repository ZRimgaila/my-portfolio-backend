package zr.spring_boot.my_portfolio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import zr.spring_boot.my_portfolio.model.ImageData;
import zr.spring_boot.my_portfolio.repository.ImageDataRepository;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ImageDataService {

    @Autowired
    ImageDataRepository repo;

    public String uploadImage(MultipartFile file, String description) throws IOException {
        ImageData imageData = repo.save(ImageData.builder()
                .name(file.getOriginalFilename())
                .description(description)
                .imageData(file.getBytes())
                .imageType(file.getContentType())
                .build()
        );

        if(imageData != null){
            return "Image file uploaded successfully: " + file.getOriginalFilename();
        } else {
            return "Something wrong with upload";
        }
    }

    public List<ImageData> getAllImages() {
        return repo.findAll();
    }

    public Optional<ImageData> getImageById(int id) {
        return repo.findById(id);
    }
}
