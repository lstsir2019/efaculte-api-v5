/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.efaculte.efaculteapiv1.dao;

import com.efaculte.efaculteapiv1.bean.Module;
import com.efaculte.efaculteapiv1.bean.Semestre;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author admin
 */
@Repository
public interface ModuleDao extends JpaRepository<Module, Long>{
    public List<Module> findBySemestre(Semestre semestre);
    public List<Module> findBySemestreLibelle(String libelle);
    public Module findByLibelle(String libelle);
    public List<Module> findByFiliereLibelle(String libelle);
    public List<Module> findByFiliereAbreviation(String libelle);
    //public List<Module> findBySemestrelibelleAndFiliereLibelle(String libelleSeme,String libelleFiliere);
   //public List<Module> findBySemestreByFiliereLibelle(String libelle);
    public List<Module> findAll();
}
