/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.efaculte.efaculteapiv1.service;

import com.efaculte.efaculteapiv1.bean.Etudiant;
import com.efaculte.efaculteapiv1.bean.Filiere;
import java.util.List;

/**
 *
 * @author Naoufal's pc
 */
public interface EtudiantService {

    public Etudiant findByCne(String cne);
    public Etudiant findByNappogee(Long napogee);
    public Etudiant findByCin(String cin);

    public List<Etudiant> findByFiliereLibelle(String libelle);
    public List<Etudiant> findByEtatDeust(int etat);
   
    
    public int creer(Etudiant etudiant,String libelle);
    public int saveEtudiant(Filiere filiere, List<Etudiant> etudiants);

    public int seConnecter(String cne,String password);
    

}
