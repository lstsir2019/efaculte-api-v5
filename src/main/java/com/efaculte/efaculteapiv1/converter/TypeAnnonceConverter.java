/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.efaculte.efaculteapiv1.converter;

import com.efaculte.efaculteapiv1.bean.TypeAnnonce;
import com.efaculte.efaculteapiv1.common.util.NumberUtil;
import com.efaculte.efaculteapiv1.rest.vo.TypeAnnonceVo;

/**
 *
 * @author admin
 */


public class TypeAnnonceConverter extends AbstractConverter<TypeAnnonce, TypeAnnonceVo>{

    @Override
    public TypeAnnonce toItem(TypeAnnonceVo vo) {
         if (vo == null) {
            return null;
        } else {
            TypeAnnonceConverter typeAnnonceConverter = new TypeAnnonceConverter();
            TypeAnnonce item = new TypeAnnonce();
            item.setId(vo.getId());
            item.setLibelle(vo.getLibelle());
            item.setCode(NumberUtil.toInt(vo.getCode()));
            return item;
        }
            
        
    }

    @Override
    public TypeAnnonceVo toVo(TypeAnnonce item) {
        if (item == null) {
            return null;
        }else{
            TypeAnnonceVo vo = new TypeAnnonceVo();
            vo.setId(item.getId());
            vo.setLibelle(item.getLibelle());
            vo.setCode(NumberUtil.intToString(item.getCode()));
            return vo;
        }
        
    }
    
}
