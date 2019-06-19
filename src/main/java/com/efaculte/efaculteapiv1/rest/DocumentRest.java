/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.efaculte.efaculteapiv1.rest;

import com.efaculte.efaculteapiv1.rest.vo.DocumentVo;
import com.efaculte.efaculteapiv1.service.DocumentService;
import java.io.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author admin
 */
@RestController()
@CrossOrigin(origins=("http://localhost:4200"))
@RequestMapping({"/efaculte-v1-api/documents"})
public class DocumentRest {
    @Autowired
    DocumentService documentService;

//    @PostMapping("/xls/")
//    public String GenerateFileFromMultipath(@RequestBody MultipartFile file) throws IOException {
//        return documentService.GenerateFileFromMultipath(file);
//    }
    @PostMapping("/xls")
    public DocumentVo generateFileFromMultipath(MultipartFile file) {
        File f = documentService.generateFileFromMultipath(file);
        DocumentVo a = new DocumentVo();
        a.setPathe(f.getAbsolutePath());
        return a;
    }
    
//    
//    @PostMapping("/uploadImage")
//    public String uploadImage(@RequestParam("imageFile") MultipartFile imageFile) throws Exception{
//        String returnValue="";
//        try{
//        documentService.saveImage(imageFile);
//        }catch(Exception e){
//            e.printStackTrace();
//           // log.error("error saving image",e);
//        }
//        return returnValue;
//    }
       

    public DocumentService getDocumentService() {
        return documentService;
    }

    public void setDocumentService(DocumentService documentService) {
        this.documentService = documentService;
    }
    
    
    
    
}
