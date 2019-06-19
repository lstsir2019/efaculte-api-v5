/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.efaculte.efaculteapiv1.rest;

import com.efaculte.efaculteapiv1.bean.TypeAnnonce;
import com.efaculte.efaculteapiv1.service.TypeAnnonceService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping({"/efaculte-v1-api/typeAnnonce"})
public class TypeAnnonceRest {
    @Autowired
    TypeAnnonceService typeAnnonceService;

    public TypeAnnonceService getTypeAnnonceService() {
        return typeAnnonceService;
    }

    public void setTypeAnnonceService(TypeAnnonceService typeAnnonceService) {
        this.typeAnnonceService = typeAnnonceService;
    }

    
    @PostMapping("/typeFiliere")
    public TypeAnnonce saveType(@RequestBody TypeAnnonce typeAnnonce) {
        return typeAnnonceService.saveType(typeAnnonce);
    }

    @GetMapping("/allTypeAnnonce")
    public List<TypeAnnonce> findAll() {
        return typeAnnonceService.findAll();
    }
    
    
    
    
}
