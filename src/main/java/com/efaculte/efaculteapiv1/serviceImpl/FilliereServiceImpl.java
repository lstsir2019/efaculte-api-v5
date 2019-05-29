/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.efaculte.efaculteapiv1.serviceImpl;

import com.efaculte.efaculteapiv1.bean.Filiere;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.efaculte.efaculteapiv1.service.FiliereService;
import com.efaculte.efaculteapiv1.dao.FiliereDao;
import com.efaculte.efaculteapiv1.rest.proxy.EntiteAdministratifProxy;
import com.efaculte.efaculteapiv1.service.AnnonceService;
import com.efaculte.efaculteapiv1.service.EtudiantService;
import com.efaculte.efaculteapiv1.service.ModuleService;
import com.efaculte.efaculteapiv1.service.SemestreService;
import com.efaculte.efaculteapiv1.vo.exhange.EntiteAdministratifVo;

/**
 *
 * @author admin
 */
@Service
public class FilliereServiceImpl implements FiliereService {

    @Autowired
    private FiliereDao filliereDao;
    @Autowired
    private SemestreService semestreService;
    
    @Autowired
    private EtudiantService etudiantService;
    
    @Autowired
    private ModuleService moduleService;
    
    @Autowired
    private AnnonceService annonceService;
    
    
    @Autowired
    private EntiteAdministratifProxy administratifProxy;

    public FiliereDao getFilliereDao() {
        return filliereDao;
    }

    public void setFilliereDao(FiliereDao filliereDao) {
        this.filliereDao = filliereDao;
    }
    
   
    
    
    @Override
    public List<Filiere> findByReferenceEntiteAdministratif(String refDep){
        return filliereDao.findByReferenceEntiteAdministratif(refDep);
    }

    
    @Override
    public Filiere saveFiliereWithAnnonce(Filiere filiere) {
        Filiere f=findByLibelle(filiere.getLibelle());
        if(f!=null){
            return null;
        }else{
            filliereDao.save(filiere);
            annonceService.saveAnnonceWithFiliere(filiere, filiere.getAnnonces());
     return filiere;
        }
    }
    
    
    @Override
    public Filiere saveFiliereWithModule(Filiere filiere) {
        Filiere f=findByLibelle(filiere.getLibelle());
        if(f!=null){
            return null;
        }else{
            filliereDao.save(filiere);
            moduleService.saveModuleWithFiliere(filiere, filiere.getModules());
     return filiere;
        }
    }
    
    
    @Override
    public Filiere saveFiliereWithSemestre(Filiere filiere){
        Filiere f=findByLibelle(filiere.getLibelle());
        if(f!=null){
            return null;
        }else{
            //filiere.setEtudiants(null);
            filliereDao.save(filiere);
            semestreService.saveSemestreWithFiliere(filiere,filiere.getSemestres());
            return filiere;            
        }
    }
    
   
    
    
    @Override
    public Filiere saveFiliereWithEtudiant(Filiere filiere) {
        Filiere f=findByLibelle(filiere.getLibelle());
        if(f!=null){
            return null;
        }else{
     filliereDao.save(filiere);
     etudiantService.saveEtudiant(filiere,filiere.getEtudiants());
     return filiere;
        }
    }
    
    @Override
    public int saveFiliere(Filiere filiere){
        Filiere f=findByLibelle(filiere.getLibelle());
         if(f!=null){
            return -2;
        }
        else{
             EntiteAdministratifVo e=administratifProxy.findByreferenceEntiteAdministratifAndTypeEntiteAdministratifReference(filiere.getReferenceEntiteAdministratif(), 1);
             if(e==null){
            return -1;
        }else{
                 filliereDao.save(filiere);
                return 1;
             }
            
        }
    }
    
    @Override
    public Filiere findByLibelle(String libelle) {
        return filliereDao.findByLibelle(libelle);
    }

    

    @Override
    public List<Filiere> findAll() {
        return filliereDao.findAll();
    }

    public SemestreService getSemestreService() {
        return semestreService;
    }

    public void setSemestreService(SemestreService semestreService) {
        this.semestreService = semestreService;
    }

    public EtudiantService getEtudiantService() {
        return etudiantService;
    }

    public void setEtudiantService(EtudiantService etudiantService) {
        this.etudiantService = etudiantService;
    }

    @Override
    public List<Filiere> findByTypeFiliere(int type) {
        return filliereDao.findByTypeFiliere(type);
    }

    @Override
    public Filiere findByAbreviation(String abreviation) {
        return filliereDao.findByAbreviation(abreviation);
    }

   

    

    
    
}
