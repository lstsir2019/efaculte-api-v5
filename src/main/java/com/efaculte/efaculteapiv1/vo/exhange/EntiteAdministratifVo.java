/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.efaculte.efaculteapiv1.vo.exhange;

import com.efaculte.efaculteapiv1.rest.vo.FiliereVo;
import java.util.List;



/**
 *
 * @author admin
 */
public class EntiteAdministratifVo {

    private Long id;
    private String referenceEntiteAdministratif;
    private SousProjetVo sousProjetVo;
    private TypeEntiteAdministratifVo  typeEntiteAdministratifVo;

    public TypeEntiteAdministratifVo getTypeEntiteAdministratifVo() {
        return typeEntiteAdministratifVo;
    }

    public void setTypeEntiteAdministratifVo(TypeEntiteAdministratifVo typeEntiteAdministratifVo) {
        this.typeEntiteAdministratifVo = typeEntiteAdministratifVo;
    }


   
    public EntiteAdministratifVo() {
    }

   
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReferenceEntiteAdministratif() {
        return referenceEntiteAdministratif;
    }

    public void setReferenceEntiteAdministratif(String referenceEntiteAdministratif) {
        this.referenceEntiteAdministratif = referenceEntiteAdministratif;
    }

    public SousProjetVo getSousProjetVo() {
        return sousProjetVo;
    }

    public void setSousProjetVo(SousProjetVo sousProjetVo) {
        this.sousProjetVo = sousProjetVo;
    }

    
    
    
}
