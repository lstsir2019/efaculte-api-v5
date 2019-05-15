/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.efaculte.efaculteapiv1.converter;

import com.efaculte.efaculteapiv1.bean.Etudiant;
import com.efaculte.efaculteapiv1.common.util.DateUtil;
import com.efaculte.efaculteapiv1.common.util.NumberUtil;
import com.efaculte.efaculteapiv1.rest.vo.EtudiantVo;

/**
 *
 * @author admin
 */
public class EtudiantConverter extends AbstractConverter<Etudiant, EtudiantVo> {

    @Override
    public Etudiant toItem(EtudiantVo vo) {
        if (vo == null) {
            return null;
        } else {
            FiliereConverter filiereConverter = new FiliereConverter();
            Etudiant item = new Etudiant();
            item.setId(vo.getId());
            item.setNom(vo.getNom());
            item.setPrenom(vo.getPrenom());
            item.setCin(vo.getCin());
            item.setCne(vo.getCne());
            item.setNapogee(NumberUtil.toLong(vo.getNapogee()));
            item.setEtatDeust(NumberUtil.toInt(vo.getEtatDeust()));
            item.setEmail(vo.getEmail());
            item.setGender(vo.getGender());
            item.setPassword(vo.getPassword());
            item.setBloquer(NumberUtil.toInt(vo.getBloquer()));
            item.setNbConnexionReston(NumberUtil.toInt(vo.getNbConnexionReston()));
            item.setDateNaissance(DateUtil.parse(vo.getDateNaissanceVo(), DateUtil.paternYYYY_MM_DD));
            
            return item;
        }

    }

    @Override
    public EtudiantVo toVo(Etudiant item) {
        if (item == null) {
            return null;
        } else {
            FiliereConverter filiereConverter = new FiliereConverter();
            EtudiantVo vo = new EtudiantVo();
            vo.setId(item.getId());
            vo.setNom(item.getNom());
            vo.setPrenom(item.getPrenom());
            vo.setCin(item.getCin());
            vo.setCne(item.getCne());
            vo.setNapogee(NumberUtil.longToString(item.getNapogee()));
            vo.setEtatDeust(NumberUtil.intToString(item.getEtatDeust()));
            vo.setEmail(item.getEmail());
            vo.setGender(item.getGender());
            vo.setPassword(item.getPassword());
            vo.setBloquer(NumberUtil.toString(item.getBloquer()));
            vo.setNbConnexionReston(NumberUtil.toString(item.getNbConnexionReston()));
            vo.setDateNaissanceVo(DateUtil.formatYYYYMMDDmmhhSS(item.getDateNaissance()));
            return vo;
        }
    }

}
