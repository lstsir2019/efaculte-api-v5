/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.efaculte.efaculteapiv1.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author admin
 */
@Entity
public class Filiere implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String libelle;
    private String abreviation;
    private String objectif;
    private int typeFiliere ;//1:TC ,2:licence ,3:cycle ,4:master
    private String referenceEntiteAdministratif;
     @OneToMany(mappedBy = "filiere")
    private List<Etudiant> etudiants;
    @OneToMany(mappedBy = "filiere")
    private List<Semestre> semestres;

    @OneToMany(mappedBy = "filiere")
    private List<Module> modules;
    @OneToMany(mappedBy = "filiere")
    private List<Annonce> annonces;


    

    
   
    
    
    
    public Filiere() {
    }
   
    
     public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonIgnore
    public List<Annonce> getAnnonces() {
        return annonces;
    }

    @JsonSetter
    public void setAnnonces(List<Annonce> annonces) {
        this.annonces = annonces;
    }

   

    

    public String getReferenceEntiteAdministratif() {
        return referenceEntiteAdministratif;
    }

    public void setReferenceEntiteAdministratif(String referenceEntiteAdministratif) {
        this.referenceEntiteAdministratif = referenceEntiteAdministratif;
    }

   
    @JsonIgnore
    public List<Module> getModules() {
        return modules;
    }

    @JsonSetter
    public void setModules(List<Module> modules) {
        this.modules = modules;
    }
    
    @JsonIgnore
    public List<Semestre> getSemestres() {
        return semestres;
    }

    @JsonSetter
    public void setSemestres(List<Semestre> semestres) {
        this.semestres = semestres;
    }
    
    
    
    @JsonIgnore
    public List<Etudiant> getEtudiants() {
        return etudiants;
    }

    @JsonSetter
    public void setEtudiants(List<Etudiant> etudiants) {
        this.etudiants = etudiants;
    }

    

//    public List<Module> getModules() {
//        return modules;
//    }
//    
//     public void setModules(List<Module> modules) {
//        this.modules = modules;
//    }

    public String getAbreviation() {
        return abreviation;
    }

    public String getObjectif() {
        return objectif;
    }

    public void setObjectif(String objectif) {
        this.objectif = objectif;
    }

    public void setAbreviation(String abreviation) {
        this.abreviation = abreviation;
    }

    public int getTypeFiliere() {
        return typeFiliere;
    }

    public void setTypeFiliere(int typeFiliere) {
        this.typeFiliere = typeFiliere;
    }

   

   

   
   
    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
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
        if (!(object instanceof Filiere)) {
            return false;
        }
        Filiere other = (Filiere) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return libelle;
    }

}
