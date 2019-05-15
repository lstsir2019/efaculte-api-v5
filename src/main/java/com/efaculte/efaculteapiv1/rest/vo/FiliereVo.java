/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.efaculte.efaculteapiv1.rest.vo;

import com.efaculte.efaculteapiv1.bean.Etudiant;
import com.efaculte.efaculteapiv1.bean.Module;
import com.efaculte.efaculteapiv1.bean.Semestre;
import java.util.List;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author admin
 */
public class FiliereVo {

    private Long id;
    private String libelle;
    private String abreviation;
    private String objectif;
    private String typeFiliere ;//1:TC ,2:licence ,3:cycle ,4:master
    private List<SemestreVo> semestresVo;
    private List<EtudiantVo> etudiantsVo;
    private String referenceEntiteAdministratif;
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getAbreviation() {
        return abreviation;
    }

    public void setAbreviation(String abreviation) {
        this.abreviation = abreviation;
    }

    public String getObjectif() {
        return objectif;
    }

    public void setObjectif(String objectif) {
        this.objectif = objectif;
    }

   

    public String getTypeFiliere() {
        return typeFiliere;
    }

    public void setTypeFiliere(String typeFiliere) {
        this.typeFiliere = typeFiliere;
    }

  

    

    public List<SemestreVo> getSemestresVo() {
        return semestresVo;
    }

    public void setSemestresVo(List<SemestreVo> semestresVo) {
        this.semestresVo = semestresVo;
    }

    public List<EtudiantVo> getEtudiantsVo() {
        return etudiantsVo;
    }

    public void setEtudiantsVo(List<EtudiantVo> etudiantsVo) {
        this.etudiantsVo = etudiantsVo;
    }

    public String getReferenceEntiteAdministratif() {
        return referenceEntiteAdministratif;
    }

    public void setReferenceEntiteAdministratif(String referenceEntiteAdministratif) {
        this.referenceEntiteAdministratif = referenceEntiteAdministratif;
    }

   

   
    
    
}
