/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.efaculte.efaculteapiv1.service;

import com.efaculte.efaculteapiv1.bean.Annonce;
import com.efaculte.efaculteapiv1.bean.Document;
import java.io.File;
import java.io.IOException;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author admin
 */
public interface DocumentService {
    public int saveDocument(Annonce annonce, List<Document> documents) ;
     //public String generateFileFromMultipath(MultipartFile file) throws IOException;
     public File generateFileFromMultipath(MultipartFile file);


    // public void saveImage(MultipartFile imageFile) throws Exception;
}
