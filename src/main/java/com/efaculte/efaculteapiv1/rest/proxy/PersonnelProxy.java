/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.efaculte.efaculteapiv1.rest.proxy;

import com.efaculte.efaculteapiv1.vo.exhange.PersonnelVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author admin
 */

@FeignClient(name="microservice3-mandatPersonnel",url="localhost:8090")
public interface PersonnelProxy {      
    @GetMapping("/mandat/mandats/cin/{cin}")
    public PersonnelVo findByCin(@PathVariable("cin") String cin);
    
    @GetMapping("/mandat/mandats/personnel/typePersonnel/{libelle}")
    public PersonnelVo findByTypePersonnelLibelle(@PathVariable("libelle") String libelle);
    
    @GetMapping("/mandat/mandats/cin/{cin}/libelle/{libelle}")
    public PersonnelVo findByCinAndTypePersonnelLibelle(@PathVariable("cin") String cin,@PathVariable("libelle") String libelle);
    
}
