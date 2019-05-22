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

    @Override
    public Annonce saveAnnonce(Annonce annonce) {
        Annonce a=findByTitle(annonce.getTitle());
        if(a!=null){
            return null;
        }
        else{
            return annonceDao.save(annonce);
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
    
}
