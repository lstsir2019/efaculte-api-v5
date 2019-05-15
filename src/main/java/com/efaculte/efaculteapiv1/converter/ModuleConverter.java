/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.efaculte.efaculteapiv1.converter;

import com.efaculte.efaculteapiv1.bean.Module;
import com.efaculte.efaculteapiv1.rest.vo.ModuleVo;

/**
 *
 * @author admin
 */
public class ModuleConverter extends AbstractConverter<Module, ModuleVo> {

    
   
    
    @Override
    public Module toItem(ModuleVo vo) {
        if (vo == null) {
            return null;
        } else {
            FiliereConverter filiereConverter = new FiliereConverter();
            Module item = new Module();
            item.setId(vo.getId());
            item.setLibelle(vo.getLibelle());
            item.setCinPersonnel(vo.getCinPersonnel());
            return item; 
        }
    }

    @Override
    public ModuleVo toVo(Module item) {
        if (item == null) {
            return null;
        }else{
            FiliereConverter filiereConverter = new FiliereConverter();
            ModuleVo vo = new ModuleVo();
            vo.setId(item.getId());
            vo.setLibelle(item.getLibelle());
            vo.setCinPersonnel(item.getCinPersonnel());
            return vo; 
        }
    }

}
