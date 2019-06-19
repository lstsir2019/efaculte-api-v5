/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.efaculte.efaculteapiv1.serviceImpl;

import com.efaculte.efaculteapiv1.bean.Filiere;
import com.efaculte.efaculteapiv1.bean.Module;
import com.efaculte.efaculteapiv1.bean.Semestre;
import com.efaculte.efaculteapiv1.dao.ModuleDao;
import com.efaculte.efaculteapiv1.rest.proxy.PersonnelProxy;
import com.efaculte.efaculteapiv1.service.FiliereService;
import com.efaculte.efaculteapiv1.service.ModuleService;
import com.efaculte.efaculteapiv1.service.SemestreService;
import com.efaculte.efaculteapiv1.vo.exhange.PersonnelVo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */

@Service
public class ModuleServiceImpl implements ModuleService{
    @Autowired
    ModuleDao moduleDao;
    @Autowired
    FiliereService filiereService;
    
    @Autowired
    SemestreService semestreService;
    
    @Autowired 
    PersonnelProxy personnelProxy;
    
    @Override
            public List<Module> findByFiliereLibelle(String libelle){
            return moduleDao.findByFiliereLibelle(libelle);
        }
    
    @Override
    public int saveModuleWithFiliere(Filiere filiere,List<Module> modules){
        if(modules ==null && modules.isEmpty()){
            return -4;
        }else{
            for(Module module :modules){
                PersonnelVo p=personnelProxy.findByCinAndTypePersonnelLibelle(module.getCinPersonnel(), module.getTypePersonnel());
             if(p==null ){
                    return -5;
                    }else{
                 module.setFiliere(filiere);
                moduleDao.save(module);
             }
                
            }
            return 1;
        }
    }
    
    @Override
    public int saveModuleWithSemestre(Semestre semestre,List<Module> modules){
        if(modules ==null && modules.isEmpty()){
            return -4;
        }else{
            for(Module module :modules){
                PersonnelVo p=personnelProxy.findByCinAndTypePersonnelLibelle(module.getCinPersonnel(), module.getTypePersonnel());
             if(p==null ){
                    return -5;
                    }else{
                 module.setSemestre(semestre);
                module.setFiliere(semestre.getFiliere());
                moduleDao.save(module);
             }
            }
            return 1;
        }
    }

    @Override
    public int saveModule(Module module,String libelleFiliere,String libelleSemestre){
         Semestre s = semestreService.findByLibelleAndFiliereLibelle(libelleSemestre, libelleFiliere);
        Module m=findByLibelle(module.getLibelle());
        if(s==null){
            return -1;
        }
        else if(m!=null){
            return -2;
        }
        else{
            PersonnelVo p=personnelProxy.findByCinAndTypePersonnelLibelle(module.getCinPersonnel(), module.getTypePersonnel());
                String prof = null;
             if(p==null && p.getTypePersonnel().getLibelle().equals(prof)){
                    return -5;
                    }else{
            module.setSemestre(s);
            //saveSemestreWithModule(semestre);
            semestreService.saveSemestreWithModule(s);
            moduleDao.save(module);

        return 1;
             }
    }
    }
    
    @Override
        public Module findByLibelle(String libelle){
            return moduleDao.findByLibelle(libelle);
        }
    
    @Override
           public List<Module> findBySemestreLibelle(String libelle){
            return moduleDao.findBySemestreLibelle(libelle);
        }
    
    @Override
        public List<Module> findBySemestre(Semestre semestre){
            return moduleDao.findBySemestre(semestre);
        }
         
    public List<Module> findByFiliereAbreviation(String libelle){
        return moduleDao.findByFiliereAbreviation(libelle);
    }
  @Override
    public List<Module> findAll() {
        return moduleDao.findAll();
    }
    
    
    
    public ModuleDao getModuleDao() {
        return moduleDao;
    }

    public void setModuleDao(ModuleDao moduleDao) {
        this.moduleDao = moduleDao;
    }

    public FiliereService getFiliereService() {
        return filiereService;
    }

    public void setFiliereService(FiliereService filiereService) {
        this.filiereService = filiereService;
    }

    public SemestreService getSemestreService() {
        return semestreService;
    }

    public void setSemestreService(SemestreService semestreService) {
        this.semestreService = semestreService;
    }

  
}
