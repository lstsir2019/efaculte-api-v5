/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.efaculte.efaculteapiv1.service;

import com.efaculte.efaculteapiv1.bean.Filiere;
import com.efaculte.efaculteapiv1.vo.exhange.EntiteAdministratifVo;
import java.util.List;

/**
 *
 * @author Naoufal's pc
 */
public interface FiliereService {

    public Filiere findByLibelle(String libelle);
    public Filiere saveFiliereWithSemestre(Filiere filiere);
    public Filiere saveFiliereWithEtudiant(Filiere filiere);
    public int saveFiliere(Filiere filiere);
    public List<Filiere> findAll();
    public List<Filiere> findByReferenceEntiteAdministratif(String refDep);

}
