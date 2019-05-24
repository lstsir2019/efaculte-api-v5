/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.efaculte.efaculteapiv1.rest;

import com.efaculte.efaculteapiv1.bean.Annonce;
import com.efaculte.efaculteapiv1.service.AnnonceService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author admin
 */
@RestController()
@CrossOrigin(origins=("http://localhost:4200"))
@RequestMapping({"/efaculte-v1-api/annonces"})
public class AnnonceRest {
    
    @Autowired
    AnnonceService annonceService;

    
    @PostMapping("/")
    public Annonce saveAnnonce(@RequestBody Annonce annonce) {
        return annonceService.saveAnnonce(annonce);
    }

    
    @GetMapping("/")
    public List<Annonce> findAll() {
        return annonceService.findAll();
    }

    
    @GetMapping("/findByOrderDesc")
    public List<Annonce> findByDesactiverFalseOrderByDateCreationDesc() {
        return annonceService.findByDesactiverFalseOrderByDateCreationDesc();
    }
    
    
    @GetMapping("/findByOrderAsc")
    public List<Annonce> findByDesactiverFalseOrderByDateCreationAsc() {
        return annonceService.findByDesactiverFalseOrderByDateCreationAsc();
    }

    
    @GetMapping("/desactiverTitle/{title}")
    public Annonce desactiverAnnonce(@PathVariable String title) {
        return annonceService.desactiverAnnonce(title);
    }

    
    
    
    public AnnonceService getAnnonceService() {
        return annonceService;
    }

    public void setAnnonceService(AnnonceService annonceService) {
        this.annonceService = annonceService;
    }
    
    
    
    
    
    
    
}
