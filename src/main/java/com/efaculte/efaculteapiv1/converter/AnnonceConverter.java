/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.efaculte.efaculteapiv1.converter;

import com.efaculte.efaculteapiv1.bean.Annonce;
import com.efaculte.efaculteapiv1.common.util.DateUtil;
import com.efaculte.efaculteapiv1.rest.vo.AnnonceVo;
import java.util.Date;

/**
 *
 * @author admin
 */


public class AnnonceConverter extends AbstractConverter<Annonce, AnnonceVo>{

    @Override
    public Annonce toItem(AnnonceVo vo) {
            if (vo == null) {
            return null;
        } else {
            AnnonceConverter annonceConverter = new AnnonceConverter();
            Annonce item = new Annonce();
            item.setId(vo.getId());
            item.setDescription(vo.getDescription());
            item.setTitle(vo.getTitle());
            item.setDateCreation(DateUtil.parse(vo.getDateCreation(), DateUtil.paternYYYY_MM_DD));
            return item;
        }
            
    }

    @Override
    public AnnonceVo toVo(Annonce item) {
             if (item == null) {
            return null;
        } else {
            AnnonceConverter annonceConverter = new AnnonceConverter();
            AnnonceVo vo = new AnnonceVo();
            vo.setId(item.getId());
            vo.setDescription(item.getDescription());
            vo.setTitle(item.getTitle());
            vo.setDateCreation(DateUtil.formatYYYYMMDDmmhhSS(item.getDateCreation()));
            return vo;
        }
    }
    
}
