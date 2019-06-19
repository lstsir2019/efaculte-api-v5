/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.efaculte.efaculteapiv1.serviceImpl;

import com.efaculte.efaculteapiv1.bean.Annonce;
import com.efaculte.efaculteapiv1.bean.Document;
import com.efaculte.efaculteapiv1.dao.DocumentDao;
import com.efaculte.efaculteapiv1.service.DocumentService;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import org.apache.commons.io.FileUtils;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


/**
 *
 * @author admin
 */
@Service
public class DocumentserviceImpl implements DocumentService{
    
    @Autowired
    DocumentDao documentDao;
    
   
    
    
    @Override
    public int saveDocument(Annonce annonce, List<Document> documents) {
        if (documents == null && documents.isEmpty()) {
            return -1;
        } else {
            for (Document document : documents) {
                document.setAnnonce(annonce);
                documentDao.save(document);
            }
            return 1;
        }
    }
   
    @Override
  public File generateFileFromMultipath(MultipartFile file) {
        File file1 = new File("C:\\Users\\admin\\Desktop\\100APPLE", file.getOriginalFilename());
        try {
            FileUtils.writeByteArrayToFile(file1, file.getBytes());
            return file1;
        } catch (IOException ex) {
            System.out.println(ex);
            //Logger.getLogger(DocumentserviceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

//    @Override
//    public void saveImage(MultipartFile imageFile) throws Exception {
//        String folder="/images/";
//        byte[] bytes = imageFile.getBytes();
//        Path path=Paths.get(folder+imageFile.getOriginalFilename());
//        //Files.write(bytes,path);
//
//
//    }
    
    
   
    
    
}
