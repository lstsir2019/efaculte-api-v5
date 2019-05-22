/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.efaculte.efaculteapiv1.serviceImpl;

import com.efaculte.efaculteapiv1.bean.TypeAnnonce;
import com.efaculte.efaculteapiv1.dao.TypeAnnonceDao;
import com.efaculte.efaculteapiv1.service.TypeAnnonceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class TypeAnnonceServiceImpl implements TypeAnnonceService{
    
    @Autowired
    TypeAnnonceDao typeAnnonceDao;

    @Override
    public TypeAnnonce saveType(TypeAnnonce typeAnnonce) {
        return typeAnnonceDao.save(typeAnnonce);
    }
    
    
}
