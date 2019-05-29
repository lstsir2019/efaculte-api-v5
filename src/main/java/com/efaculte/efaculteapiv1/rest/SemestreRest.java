/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.efaculte.efaculteapiv1.rest;

import com.efaculte.efaculteapiv1.bean.Semestre;
import com.efaculte.efaculteapiv1.converter.SemestreConverter;
import com.efaculte.efaculteapiv1.rest.vo.SemestreVo;
import com.efaculte.efaculteapiv1.service.SemestreService;
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
 * @author User
 */
@RestController()
@CrossOrigin(origins = ("http://localhost:4200"))
@RequestMapping({"/efaculte-v1-api/semestres"})
public class SemestreRest {

    @Autowired
    SemestreService semestreService;

    
    @GetMapping("/abreviation/{abreviation}")
    public List<Semestre> findByFiliereAbreviation(@PathVariable String abreviation) {
        return semestreService.findByFiliereAbreviation(abreviation);
    }

    
    
    
//find semestre by libelle semestre
    @GetMapping("/libelle/{libelle}")
    public SemestreVo findByLibelle(@PathVariable String libelle) {
        SemestreConverter semestreConverter = new SemestreConverter();
        return semestreConverter.toVo(semestreService.findByLibelle(libelle));
    }

    //find semestre by libelle filiere
    @GetMapping("/libelleFilliere/{libelle}")
    public List<Semestre> findByFiliereLibelle(@PathVariable String libelle) {
        return semestreService.findByFiliereLibelle(libelle);
    }

    //ajouter un semestre dans une filiere qui est déja exist
    @PostMapping("/saveSemestreInFiliere/filiereLibelle/{libelle}")
    public int saveSemestre(@RequestBody Semestre semestre,@PathVariable String libelle) {
        return semestreService.saveSemestre(semestre, libelle);
    }

    @GetMapping("/libelleSemestre/{libelleSemestre}/libelleFiliere/{libelleFiliere}")
    public SemestreVo findByLibelleAndFiliereLibelle(@PathVariable String libelleSemestre,@PathVariable String libelleFiliere) {
                SemestreConverter semestreConverter = new SemestreConverter();
        return semestreConverter.toVo(semestreService.findByLibelleAndFiliereLibelle(libelleSemestre, libelleFiliere));
    }

    
    
    public SemestreService getSemestreService() {
        return semestreService;
    }

    public void setSemestreService(SemestreService semestreService) {
        this.semestreService = semestreService;
    }
}
