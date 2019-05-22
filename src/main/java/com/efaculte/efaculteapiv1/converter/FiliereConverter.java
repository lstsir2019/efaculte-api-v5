/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.efaculte.efaculteapiv1.converter;

import com.efaculte.efaculteapiv1.bean.Filiere;
import com.efaculte.efaculteapiv1.rest.vo.FiliereVo;
import com.efaculte.efaculteapiv1.common.util.NumberUtil;

/**
 *
 * @author admin
 */
public class FiliereConverter extends AbstractConverter<Filiere, FiliereVo> {

    @Override
    public Filiere toItem(FiliereVo vo) {
        if (vo == null) {
            return null;
        } else {
            Filiere item = new Filiere();
            item.setId(vo.getId());
            item.setLibelle(vo.getLibelle());
            item.setAbreviation(vo.getAbreviation());
            item.setObjectif(vo.getObjectif());
            item.setTypeFiliere(NumberUtil.toInt(vo.getTypeFiliere()));
            item.setReferenceEntiteAdministratif(vo.getReferenceEntiteAdministratif());
            item.setEtudiants(new EtudiantConverter().toItem(vo.getEtudiantsVo()));
            item.setSemestres(new SemestreConverter().toItem(vo.getSemestresVo()));
            item.setModules(new ModuleConverter().toItem(vo.getModulesVo()));
            return item;
        }
    }

    @Override
    public FiliereVo toVo(Filiere item) {
        if (item == null) {
            return null;
        }else{
            FiliereVo vo = new FiliereVo();
            vo.setId(item.getId());
            vo.setLibelle(item.getLibelle());
            vo.setAbreviation(item.getAbreviation());
            vo.setObjectif(item.getObjectif());
            vo.setTypeFiliere(NumberUtil.intToString(item.getTypeFiliere()));
            vo.setReferenceEntiteAdministratif(item.getReferenceEntiteAdministratif());
            vo.setSemestresVo(new SemestreConverter().toVo(item.getSemestres()));
            vo.setEtudiantsVo(new EtudiantConverter().toVo(item.getEtudiants()));
            vo.setModulesVo(new ModuleConverter().toVo(item.getModules()));
            
            return vo;
        }

    }

}
