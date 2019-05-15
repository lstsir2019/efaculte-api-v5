/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.efaculte.efaculteapiv1.converter;

import com.efaculte.efaculteapiv1.bean.Semestre;
import com.efaculte.efaculteapiv1.rest.vo.SemestreVo;

/**
 *
 * @author admin
 */
public class SemestreConverter extends AbstractConverter<Semestre, SemestreVo> {

    @Override
    public Semestre toItem(SemestreVo vo) {

        if (vo == null) {
            return null;
        } else {
            Semestre item = new Semestre();
            item.setId(vo.getId());
            item.setLibelle(vo.getLibelle());
            item.setModules(new ModuleConverter().toItem(vo.getModuleVos()));
            return item;
        }

    }

    @Override
    public SemestreVo toVo(Semestre item) {
        if (item == null) {
            return null;
        } else {
            SemestreVo vo = new SemestreVo();
            vo.setId(item.getId());
            vo.setLibelle(item.getLibelle());
            vo.setModuleVos(new ModuleConverter().toVo(item.getModules()));
            return vo;
        }
    }

}
