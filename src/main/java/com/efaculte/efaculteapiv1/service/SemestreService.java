/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.efaculte.efaculteapiv1.service;

import com.efaculte.efaculteapiv1.bean.Filiere;
import com.efaculte.efaculteapiv1.bean.Semestre;
import java.util.List;

/**
 *
 * @author Naoufal's pc
 */
public interface SemestreService {

    public Semestre findByLibelle(String libelle);
    public Semestre saveSemestreWithModule(Semestre semestre);
    public int saveSemestreWithFiliere(Filiere filiere, List<Semestre> semestres);
    public List<Semestre> findByFiliereLibelle(String libelle);
    public List<Semestre> findByFiliereAbreviation(String abreviation);
    public int saveSemestre(Semestre semestre,String libelle);
    public Semestre findByLibelleAndFiliereLibelle(String libelleSemestre,String libelleFiliere);


}
