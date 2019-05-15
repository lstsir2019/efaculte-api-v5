/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.efaculte.efaculteapiv1.dao;

import com.efaculte.efaculteapiv1.bean.Etudiant;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author admin
 */
@Repository
public interface EtudiantDao extends JpaRepository<Etudiant, Long> {

    public Etudiant findByCne(String cne);  
    public Etudiant findByNapogee(Long napogee);
    public Etudiant findByCin(String cin);
    public List<Etudiant> findByFiliereLibelle(String libelle);
    public List<Etudiant> findByEtatDeust(int etat);
}
