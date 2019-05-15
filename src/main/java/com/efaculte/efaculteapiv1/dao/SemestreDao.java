/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.efaculte.efaculteapiv1.dao;

import com.efaculte.efaculteapiv1.bean.Semestre;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Naoufal's pc
 */
@Repository
public interface SemestreDao extends JpaRepository<Semestre, Long>{
    
    public Semestre findByLibelle(String libelle);
    public List<Semestre> findByFiliereLibelle(String libelle);
    public Semestre findByLibelleAndFiliereLibelle(String libelleSemestre,String libelleFiliere);
}
