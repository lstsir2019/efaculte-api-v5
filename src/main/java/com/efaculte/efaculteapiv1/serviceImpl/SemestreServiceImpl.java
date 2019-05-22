/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.efaculte.efaculteapiv1.serviceImpl;

import com.efaculte.efaculteapiv1.bean.Filiere;
import com.efaculte.efaculteapiv1.bean.Module;
import com.efaculte.efaculteapiv1.bean.Semestre;
import com.efaculte.efaculteapiv1.dao.SemestreDao;
import com.efaculte.efaculteapiv1.rest.proxy.PersonnelProxy;
import com.efaculte.efaculteapiv1.service.FiliereService;
import com.efaculte.efaculteapiv1.service.ModuleService;
import com.efaculte.efaculteapiv1.service.SemestreService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Naoufal's pc
 */
@Service
public class SemestreServiceImpl implements SemestreService {
    
    @Autowired
    SemestreDao semestreDao;
    
    @Autowired
    ModuleService moduleService;
    
    @Autowired
    FiliereService filiereService;
    
    @Autowired
    PersonnelProxy personnelProxy;
    
    @Override
    public Semestre findByLibelle(String libelle) {
        return semestreDao.findByLibelle(libelle);
    }
    

    
    @Override
        public List<Semestre> findByFiliereLibelle(String libelle){
          return semestreDao.findByFiliereLibelle(libelle);
        }
   
    
    @Override
    public Semestre saveSemestreWithModule(Semestre semestre){
//        Semestre s=findByLibelle(semestre.getLibelle());
//        if(s!=null){
//            return null;
//        }else{
            semestreDao.save(semestre);
            moduleService.saveModuleWithSemestre(semestre, semestre.getModules());
            //moduleService.saveModuleWithFiliere(semestre.getFiliere(), semestre.getModules());
            return semestre;
            
       // }
    }
        

    @Override
    public int saveSemestreWithFiliere(Filiere filiere, List<Semestre> semestres) {
        if (semestres == null && semestres.isEmpty()) {
            return -1;
        } else {
            for (Semestre semestre : semestres) {
                semestre.setFiliere(filiere);
                saveSemestreWithModule(semestre);
               
                semestreDao.save(semestre);
            }
            return 1;
        }
    }
        
       
    @Override
    public int saveSemestre(Semestre semestre, String libelle) {
        Filiere f = filiereService.findByLibelle(libelle);
        if(f==null){
            return -1;
        }
         
        else{
                    Semestre s=findByLibelleAndFiliereLibelle(semestre.getLibelle(),f.getLibelle());
                if(s!=null){
            return -2;
        }
                else{
                    semestre.setFiliere(f);
                 // moduleService.saveModuleWithSemestre(semestre, semestre.getModules());      
            saveSemestreWithModule(semestre);
           // moduleService.saveModuleWithSemestre(semestre, semestre.getModules());
            filiereService.saveFiliereWithSemestre(f);
             //filiereService.saveFiliereWithModule(f);
            semestreDao.save(semestre);

        return 1;
                }
            
        }

    }
         
    @Override
        public Semestre findByLibelleAndFiliereLibelle(String libelleSemestre,String libelleFiliere){
            return semestreDao.findByLibelleAndFiliereLibelle(libelleSemestre, libelleFiliere);
        }
            
    public SemestreDao getSemestreDao() {
        return semestreDao;
    }
    
    public void setSemestreDao(SemestreDao semestreDao) {
        this.semestreDao = semestreDao;
    }

    public ModuleService getModuleService() {
        return moduleService;
    }

    public void setModuleService(ModuleService moduleService) {
        this.moduleService = moduleService;
    }

    
    
    
}
