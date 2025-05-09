package zr.spring_boot.my_portfolio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import zr.spring_boot.my_portfolio.model.ContactInformation;
import zr.spring_boot.my_portfolio.service.ContactInfoService;

import java.io.IOException;
import java.util.List;

@RestController
public class ContactInformationController {

    @Autowired
    ContactInfoService service;

    @PostMapping("/contacts")
    public ResponseEntity<?> addContactInfo(@RequestParam("image") MultipartFile file, @RequestParam String description,
                                            @RequestParam String content) throws IOException {
        String uploadedContactInfo = service.addContactInfo(file, description, content);
        return ResponseEntity.ok().body(uploadedContactInfo);
    }

    @GetMapping("/contacts/{id}")
    public ResponseEntity<byte[]> getContactInfoById(@PathVariable int id){
        ContactInformation contactInfo = service.getContactInfoById(id);
        return new ResponseEntity<>(contactInfo.getImageData(), HttpStatus.OK);
    }

    @GetMapping("/contacts")
    public List<ContactInformation> getAllContactsInfo(){
        return service.getAllContactsInfo();
    }

}
