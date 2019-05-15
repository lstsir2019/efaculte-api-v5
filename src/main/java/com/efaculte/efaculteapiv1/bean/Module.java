/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.efaculte.efaculteapiv1.bean;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author admin
 */
@Entity
public class Module implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String libelle;

    @ManyToOne
    private Semestre semestre;
    private String cinPersonnel;
    private String typePersonnel;
    @ManyToOne
    private Filiere filiere;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getCinPersonnel() {
        return cinPersonnel;
    }

    public void setCinPersonnel(String cinPersonnel) {
        this.cinPersonnel = cinPersonnel;
    }

    public String getTypePersonnel() {
        return typePersonnel;
    }

    public void setTypePersonnel(String typePersonnel) {
        this.typePersonnel = typePersonnel;
    }
    

    
    
//    public Filiere getFiliere() {
//        return filiere;
//    }
//
//    public void setFiliere(Filiere filiere) {
//        this.filiere = filiere;
//    }

    public Semestre getSemestre() {
        return semestre;
    }

    public void setSemestre(Semestre semestre) {
        this.semestre = semestre;
    }

   
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    
    public String getLibelle() {
        return libelle;
    }

    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Module)) {
            return false;
        }
        Module other = (Module) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sir.efstapiv1.bean.FilliereModule[ id=" + id + " ]";
    }

}
