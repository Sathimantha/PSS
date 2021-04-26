package com.printShop.printshopserver.controller;

import com.printShop.printshopserver.model.PayerDTO;
import com.printShop.printshopserver.service.impl.MailSenderImpl;
import com.printShop.printshopserver.service.impl.PayerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.websocket.server.PathParam;
import java.io.File;
import java.io.FileOutputStream;

@CrossOrigin("*")

@RestController
@RequestMapping("/document")

public class DocumentController {

    @Autowired
    MailSenderImpl mailSender;
    @Autowired
    PayerServiceImpl payerService;

    @PostMapping(value = "/uploadFile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Object> saveDocument(@RequestParam("file0") MultipartFile file,
                                               @PathParam("printType") String printType,
                                               @PathParam("singleDoubleSide") String singleDoubleSide,
                                               @PathParam("numberOfCopies") String numberOfCopies,
                                               @PathParam("pageSize") String pageSize) throws Exception {


        String printText = "Print type : " + printType + "\npaper print side : " + singleDoubleSide + " \nnumber of copies : " + numberOfCopies + " \npaper size : " + pageSize;

        File cFile = new File("src/main/fileResource\\" + file.getOriginalFilename());
        cFile.createNewFile();
        FileOutputStream fSave = new FileOutputStream(cFile);
        fSave.write(file.getBytes());
        fSave.close();
        FileSystemResource fileSend
                = new FileSystemResource(new File("src/main/fileResource\\" + file.getOriginalFilename()));


        mailSender.sendMail("danukaem@gmail.com", "PrintShop", printText, fileSend, file.getOriginalFilename());

        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PostMapping(value = "/savePayerDetails")
    public ResponseEntity<Object> savePayerDetails(@RequestBody PayerDTO payerDTO) throws Exception {

        payerService.savePayerDetails(payerDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
