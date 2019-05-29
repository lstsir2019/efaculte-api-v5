/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.efaculte.efaculteapiv1.rest;

import com.efaculte.efaculteapiv1.bean.Filiere;
import com.efaculte.efaculteapiv1.converter.FiliereConverter;
import com.efaculte.efaculteapiv1.rest.vo.FiliereVo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.efaculte.efaculteapiv1.service.FiliereService;
import com.efaculte.efaculteapiv1.vo.exhange.EntiteAdministratifVo;

/**
 *
 * @author admin
 */
@RestController()
@CrossOrigin(origins = ("http://localhost:4200"))
@RequestMapping({"/efaculte-v1-api/fillieres"})
public class FiliereRest {

    @Autowired
    private FiliereService filliereService;

    

    @GetMapping("/")
    public List<FiliereVo> findAll() {
        FiliereConverter filiereConverter = new FiliereConverter();
        return filiereConverter.toVo(filliereService.findAll());
    }

    @GetMapping("/refDep/{refDep}")
    public List<Filiere> findByReferenceEntiteAdministratif(@PathVariable String refDep) {
        return filliereService.findByReferenceEntiteAdministratif(refDep);
    }

    
    @GetMapping("/type/{type}")
    public List<FiliereVo> findByTypeFiliere(@PathVariable int type) {
        
        return new FiliereConverter().toVo(filliereService.findByTypeFiliere(type));
    }

   

   

   //ajouter une filiere dans un departement qui est déja exist
    @PostMapping("/saveFiliere")
    public int saveFiliere(@RequestBody FiliereVo filiereVo) {
        FiliereConverter filiereConverter = new FiliereConverter();
        Filiere filiere = filiereConverter.toItem(filiereVo);
        return filliereService.saveFiliere(filiere);
    }

    
    
    @GetMapping("/libelle/{libelle}")
    public FiliereVo findByLibelle(@PathVariable String libelle) {
        FiliereConverter filiereConverter = new FiliereConverter();
        return filiereConverter.toVo(filliereService.findByLibelle(libelle));
    }

    public FiliereService getFilliereService() {
        return filliereService;
    }

    public void setFilliereService(FiliereService filliereService) {
        this.filliereService = filliereService;
    }

}
