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
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    
}
