/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.efaculte.efaculteapiv1.serviceImpl;

import com.efaculte.efaculteapiv1.bean.Annonce;
import com.efaculte.efaculteapiv1.bean.Filiere;
import com.efaculte.efaculteapiv1.dao.AnnonceDao;
import com.efaculte.efaculteapiv1.service.AnnonceService;
import com.efaculte.efaculteapiv1.service.DocumentService;
import com.efaculte.efaculteapiv1.service.FiliereService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */

@Service
public class AnnonceServiceImpl implements AnnonceService{
    
    @Autowired
    private AnnonceDao annonceDao;
    
    @Autowired
    private FiliereService filiereService;
    @Autowired
    private DocumentService documentservice;
    
 
    

    @Override
    public Annonce saveAnnonce(Annonce annonce) {
        Annonce a=findByTitle(annonce.getTitle());
        if(a!=null){
            return null;
        }
        else{
            saveAnnonceWithDocument(annonce);
            return annonceDao.save(annonce);
        }
     
        
    }
    
    @Override
    public Annonce saveAnnonceWithDocument(Annonce annonce) {
        Annonce a=findByTitle(annonce.getTitle());
        if(a!=null){
            return null;
        }else{
            annonceDao.save(annonce);
            documentservice.saveDocument(annonce, annonce.getDocuments());
             return annonce;
        }
    }
    
    
    @Override
   public int saveAnnonceWithFiliere(Filiere filiere, List<Annonce> annonces){
       if (annonces == null && annonces.isEmpty()) {
            return -1;
        } else {
            for (Annonce annonce : annonces) {
                annonce.setFiliere(filiere);
                annonceDao.save(annonce);
            }
            return 1;
        }
   }
   
   
 @Override
 public Annonce findByTitle(String title){
     return annonceDao.findByTitle(title);
 }

    public AnnonceDao getAnnonceDao() {
        return annonceDao;
    }

    public void setAnnonceDao(AnnonceDao annonceDao) {
        this.annonceDao = annonceDao;
    }

    public FiliereService getFiliereService() {
        return filiereService;
    }

    public void setFiliereService(FiliereService filiereService) {
        this.filiereService = filiereService;
    }

    public DocumentService getDocumentservice() {
        return documentservice;
    }

    public void setDocumentservice(DocumentService documentservice) {
        this.documentservice = documentservice;
    }

    @Override
    public List<Annonce> findAll() {
        return annonceDao.findAll();
    }

    @Override
    public List<Annonce> findByDesactiverFalseOrderByDateCreationDesc() {
           return annonceDao.findByDesactiverFalseOrderByDateCreationDesc();

    }

    @Override
    public List<Annonce> findByDesactiverFalseOrderByDateCreationAsc() {
        return annonceDao.findByDesactiverFalseOrderByDateCreationAsc();
    }

    @Override
    public Annonce desactiverAnnonce(String title){
        Annonce annonce=findByTitle(title);
        if(annonce==null){
            return null;
        }else{
            annonce.setDesactiver(true);
            annonceDao.save(annonce);
            return annonce;
        }
    }
   
    
 
 
 
}
