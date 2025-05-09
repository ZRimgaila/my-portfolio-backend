package zr.spring_boot.my_portfolio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import zr.spring_boot.my_portfolio.model.ContactInformation;
import zr.spring_boot.my_portfolio.model.ImageData;
import zr.spring_boot.my_portfolio.repository.ContactInfoRepository;

import java.io.IOException;
import java.util.List;

@Service
public class ContactInfoService {

    @Autowired
    ContactInfoRepository repo;

    public List<ContactInformation> getContactInformation() {
        return repo.findAll();
    }

    public String addContactInfo(MultipartFile file, String description, String content) throws IOException {
        ContactInformation contactInfo = repo.save(ContactInformation.builder()
                .description(description)
                .content(content)
                .imageType(file.getContentType())
                .imageData(file.getBytes())
                .build());
        if(contactInfo != null){
            return "Contact info with image " + file.getOriginalFilename() + " added successfully";
        } else {
            return "Something wrong with upload";
        }
    }

    public ContactInformation getContactInfoById(int id) {
        return repo.findById(String.valueOf(id)).orElse(null);
    }

    public List<ContactInformation> getAllContactsInfo() {
        return repo.findAll();
    }
}
