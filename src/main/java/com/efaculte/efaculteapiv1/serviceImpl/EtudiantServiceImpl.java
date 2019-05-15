/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.efaculte.efaculteapiv1.serviceImpl;

import com.efaculte.efaculteapiv1.bean.Etudiant;
import com.efaculte.efaculteapiv1.bean.Filiere;
import com.efaculte.efaculteapiv1.dao.EtudiantDao;
import com.efaculte.efaculteapiv1.dao.FiliereDao;
import com.efaculte.efaculteapiv1.service.EtudiantService;
import com.efaculte.efaculteapiv1.service.FiliereService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Naoufal's pc
 */
@Service
public class EtudiantServiceImpl implements EtudiantService {

    @Autowired
    private EtudiantDao etudiantDao;
    @Autowired
    private FiliereDao filiereDao;
    
    @Autowired
    private FiliereService filiereService;

    @Override
    public Etudiant findByCne(String cne) {
        return etudiantDao.findByCne(cne);
    }

    @Override
    public Etudiant findByNappogee(Long napogee) {
        return etudiantDao.findByNapogee(napogee);
    }

 
    
    @Override
    public Etudiant findByCin(String cin) {
        return etudiantDao.findByCin(cin);
    }
    
    @Override
    public List<Etudiant> findByEtatDeust(int etat) {
        return etudiantDao.findByEtatDeust(etat);
    }
    
 @Override
    public int seConnecter(String cne, String password) {
            Etudiant etudiant=findByCne(cne);
            if(etudiant==null){
                return -1;
            }
            else if(etudiant.getBloquer()==1){
                return -2;
            }
            else if(!etudiant.getPassword().equals(password)){
                if(etudiant.getNbConnexionReston()>0){
                    etudiant.setNbConnexionReston(etudiant.getNbConnexionReston()-1);
                    
                }
                if(etudiant.getNbConnexionReston()==0){
                    etudiant.setBloquer(1);
                    etudiantDao.save(etudiant);
                    return -3;
                }
                etudiantDao.save(etudiant);
                return -4;
            }
            else{
                return 1;
            }
    }
    
    @Override
    public int creer(Etudiant etudiant,String libelle) {
        Filiere f = filiereService.findByLibelle(libelle);
        Etudiant e=findByCne(etudiant.getCne());
        if(f==null){
            return -1;
        }
        if(e!=null){
            return -2;
        }
        else{
            etudiant.setBloquer(0);
            etudiant.setNbConnexionReston(0);
            etudiant.setFiliere(f);
            filiereService.saveFiliereWithEtudiant(f);
            etudiantDao.save(etudiant);

        return 1;
        }
        
    }
    
    
    @Override
    public int saveEtudiant(Filiere filiere, List<Etudiant> etudiants) {
        if (etudiants == null && etudiants.isEmpty()) {
            return -1;
        } else {
            for (Etudiant etudiant : etudiants) {
                etudiant.setFiliere(filiere);
                etudiantDao.save(etudiant);
            }
            return 1;
        }
    }

    public EtudiantDao getEtudiantDao() {
        return etudiantDao;
    }

    public void setEtudiantDao(EtudiantDao etudiantDao) {
        this.etudiantDao = etudiantDao;
    }

    public FiliereDao getFiliereDao() {
        return filiereDao;
    }

    public void setFiliereDao(FiliereDao filiereDao) {
        this.filiereDao = filiereDao;
    }

    public FiliereService getFiliereService() {
        return filiereService;
    }

    public void setFiliereService(FiliereService filiereService) {
        this.filiereService = filiereService;
    }

    @Override
    public List<Etudiant> findByFiliereLibelle(String libelle) {
       return etudiantDao.findByFiliereLibelle(libelle);
    }

    


   

   
}
