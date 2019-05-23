/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.efaculte.efaculteapiv1.service;

import com.efaculte.efaculteapiv1.bean.Annonce;
import com.efaculte.efaculteapiv1.bean.Filiere;
import java.util.List;

/**
 *
 * @author admin
 */
public interface AnnonceService {
    public Annonce saveAnnonce(Annonce annonce);
    public int saveAnnonceWithFiliere(Filiere filiere, List<Annonce> annonces);
    public Annonce findByTitle(String title);
    public Annonce saveAnnonceWithDocument(Annonce annonce);
    public List<Annonce> findAll();

}
