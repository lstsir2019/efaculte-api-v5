/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.efaculte.efaculteapiv1.rest;

import com.efaculte.efaculteapiv1.bean.Etudiant;
import com.efaculte.efaculteapiv1.bean.Filiere;
import com.efaculte.efaculteapiv1.dao.FiliereDao;
import com.efaculte.efaculteapiv1.converter.EtudiantConverter;
import com.efaculte.efaculteapiv1.rest.vo.EtudiantVo;
import com.efaculte.efaculteapiv1.service.EtudiantService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Naoufal's pc
 */
@RestController()
@CrossOrigin(origins=("http://localhost:4200"))
@RequestMapping({"/efaculte-v1-api/etudiants"})
public class EtudiantRest {

    @Autowired
    private EtudiantService etudiantService;
    @Autowired
    private FiliereDao filiereDao;

    public EtudiantService getEtudiantService() {
        return etudiantService;
    }

    public void setEtudiantService(EtudiantService etudiantService) {
        this.etudiantService = etudiantService;
    }

    public FiliereDao getFiliereDao() {
        return filiereDao;
    }

    public void setFiliereDao(FiliereDao filiereDao) {
        this.filiereDao = filiereDao;
    }
    
    
    
    

    @GetMapping("/cne/{cne}")
    public EtudiantVo findByCne(@PathVariable String cne) {
        EtudiantConverter etudiantConverter = new EtudiantConverter();
        return etudiantConverter.toVo(etudiantService.findByCne(cne));
    }

    @PutMapping("/cne/{cne}/password/{password}")
    public int seConnecter(@PathVariable String cne,@PathVariable String password) {
        return etudiantService.seConnecter(cne, password);
    }
    
    @GetMapping("/napogee/{napogee}")
    public Etudiant findByNappogee(@PathVariable Long napogee) {
        return etudiantService.findByNappogee(napogee);
    }

    @GetMapping("/cin/{cin}")
    public Etudiant findByCin(@PathVariable String cin) {
        return etudiantService.findByCin(cin);
    }

    @GetMapping("/etatDeust/{etat}")
    public List<Etudiant> findByEtatDeust(@PathVariable int etat) {
        return etudiantService.findByEtatDeust(etat);
    }

    
    //ajouter un etudiant dans une filiere qui est deja exist
    @PostMapping("/filiere/{libelle}")
    public int creer(@RequestBody EtudiantVo etudiantVo,@PathVariable String libelle) {
        EtudiantConverter etudiantConverter = new EtudiantConverter();
        Etudiant myEtudiant = etudiantConverter.toItem(etudiantVo);
        return etudiantService.creer(myEtudiant, libelle);
    }
    

//recuperer la list des etudiants dans une filiere
    @GetMapping("/findByFiliereLibelle/{libelle}")
    public List<Etudiant> findByFiliereLibelle(@PathVariable String libelle) {
        return etudiantService.findByFiliereLibelle(libelle);
    }

    

    
    
}
