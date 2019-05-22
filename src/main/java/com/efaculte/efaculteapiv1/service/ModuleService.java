/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.efaculte.efaculteapiv1.service;

import com.efaculte.efaculteapiv1.bean.Filiere;
import com.efaculte.efaculteapiv1.bean.Module;
import com.efaculte.efaculteapiv1.bean.Semestre;
import java.util.List;

/**
 *
 * @author admin
 */
public interface ModuleService {
    public int saveModuleWithSemestre(Semestre semestre,List<Module> modules);
    public int saveModuleWithFiliere(Filiere filiere,List<Module> modules);
    public List<Module> findBySemestreLibelle(String libelle);
    public List<Module> findBySemestre(Semestre semestre);
    public List<Module> findByFiliereLibelle(String libelleFiliere);

    public Module findByLibelle(String libelle);

    public int saveModule(Module module,String libelleFiliere,String libelleSemestre);

}
