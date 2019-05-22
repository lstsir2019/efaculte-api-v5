/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.efaculte.efaculteapiv1.dao;

import com.efaculte.efaculteapiv1.bean.Annonce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author admin
 */

@Repository
public interface AnnonceDao extends JpaRepository<Annonce, Long>{
    public Annonce findByTitle(String title);
    
}
