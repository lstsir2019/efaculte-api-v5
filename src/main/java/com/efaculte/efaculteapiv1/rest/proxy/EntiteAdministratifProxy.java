/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.efaculte.efaculteapiv1.rest.proxy;

import com.efaculte.efaculteapiv1.vo.exhange.EntiteAdministratifVo;
import com.efaculte.efaculteapiv1.vo.exhange.PersonnelVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author admin
 */

@FeignClient(name="microservice3-mandatPersonnel",url="localhost:9999")
public interface EntiteAdministratifProxy {      
 
    @GetMapping("/mandat/mandats/refEntite/{refEnti}/refType/{refType}")
    public EntiteAdministratifVo findByreferenceEntiteAdministratifAndTypeEntiteAdministratifReference(@PathVariable("refEnti") String refEnti,@PathVariable("refType") int refType);
    
  
}
