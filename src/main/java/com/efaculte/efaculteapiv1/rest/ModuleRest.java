/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.efaculte.efaculteapiv1.rest;

import com.efaculte.efaculteapiv1.bean.Filiere;
import com.efaculte.efaculteapiv1.bean.Module;
import com.efaculte.efaculteapiv1.commun.PdfUtil;
import com.efaculte.efaculteapiv1.converter.FiliereConverter;
import com.efaculte.efaculteapiv1.converter.ModuleConverter;
import com.efaculte.efaculteapiv1.rest.vo.FiliereVo;
import com.efaculte.efaculteapiv1.rest.vo.ModuleVo;
import com.efaculte.efaculteapiv1.service.FiliereService;
import com.efaculte.efaculteapiv1.service.ModuleService;
import com.efaculte.efaculteapiv1.service.SemestreService;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    
    @Autowired
    FiliereService filiereService;
    
    @Autowired
    SemestreService semestreService;

    
    @GetMapping("/libelleFiliere/{libelleFiliere}")
    public List<Module> findByFiliereLibelle(@PathVariable String libelleFiliere) {
        return moduleService.findByFiliereLibelle(libelleFiliere);
    }

    @GetMapping("/libelle/{libelle}")
    public ModuleVo findByLibelle(@PathVariable String libelle) {
        return new ModuleConverter().toVo(moduleService.findByLibelle(libelle));
    }

       

    @GetMapping("/pdf/{filiereLibelle}")
    //@Produces("application/pdf")
    public ResponseEntity<Object> report(@PathVariable String filiereLibelle) throws JRException,IOException{
        Map<String,Object> param=new HashMap<>();
        List<Module> md=moduleService.findByFiliereAbreviation(filiereLibelle);
        //List<Semestre> sm=semestreService.findByFiliereAbreviation(filiereLibelle);
        
        Filiere filiere=filiereService.findByAbreviation(filiereLibelle);
        String objectif=filiere.getObjectif();
        String abreviationFiliere=filiere.getAbreviation();
        String libelleFiliere=filiere.getLibelle();
        param.put("filiere",abreviationFiliere);
        param.put("libellefiliere",libelleFiliere);
        param.put("objectif",objectif);
        
        return PdfUtil.generate("module", param, md, "/report/filierePdf.jasper");
    }

    

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

    @GetMapping("/findAll")
    public List<ModuleVo> findAll() {
        return new ModuleConverter().toVo(moduleService.findAll());
    }
    
    
    
    

    public ModuleService getModuleService() {
        return moduleService;
    }

    public void setModuleService(ModuleService moduleService) {
        this.moduleService = moduleService;
    }
    
    
    
}
