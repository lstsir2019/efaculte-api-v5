/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.efaculte.efaculteapiv1.rest;

import com.efaculte.efaculteapiv1.bean.Module;
import com.efaculte.efaculteapiv1.converter.ModuleConverter;
import com.efaculte.efaculteapiv1.rest.vo.ModuleVo;
import com.efaculte.efaculteapiv1.service.ModuleService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author admin
 */

@RestController()
@CrossOrigin(origins = ("http://localhost:4200"))
@RequestMapping({"/efaculte-v1-api/modules"})
public class ModuleRest {
    @Autowired
    ModuleService moduleService;

    
    @GetMapping("/libelleFiliere/{libelleFiliere}")
    public List<Module> findByFiliereLibelle(@PathVariable String libelleFiliere) {
        return moduleService.findByFiliereLibelle(libelleFiliere);
    }

    @GetMapping("/libelle/{libelle}")
    public ModuleVo findByLibelle(@PathVariable String libelle) {
        return new ModuleConverter().toVo(moduleService.findByLibelle(libelle));
    }

    


    
//    // recuperer la liste des modules dans une filiere
//    @GetMapping("/libelleFiliere/{libelle}")
//    public List<Module> findBySemestreByFiliereLibelle(@PathVariable String libelle) {
//        return moduleService.findBySemestreByFiliereLibelle(libelle);
//    }

    //recuperer la liste des modules dans une semestre
    @GetMapping("/libelleSemestre/{libelle}")
    public List<Module> findBySemestreLibelle(@PathVariable String libelle) {
        return moduleService.findBySemestreLibelle(libelle);
    }

    //ajouter un module dans une semestre qui est déja exist
    @PostMapping("/libelleFiliere/{libelleFiliere}/semestreLibelle/{libelleSemestre}")
    public int saveModule(@RequestBody Module module,@PathVariable String libelleFiliere,@PathVariable String libelleSemestre) {
        return moduleService.saveModule(module,libelleFiliere, libelleSemestre);
    }
    
    
    
    

    public ModuleService getModuleService() {
        return moduleService;
    }

    public void setModuleService(ModuleService moduleService) {
        this.moduleService = moduleService;
    }
    
    
    
}
