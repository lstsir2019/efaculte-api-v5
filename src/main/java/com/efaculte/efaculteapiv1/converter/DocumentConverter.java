/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.efaculte.efaculteapiv1.converter;

import com.efaculte.efaculteapiv1.bean.Document;
import com.efaculte.efaculteapiv1.rest.vo.DocumentVo;

/**
 *
 * @author admin
 */
public class DocumentConverter extends AbstractConverter<Document, DocumentVo>{

    @Override
    public Document toItem(DocumentVo vo) {
         if (vo == null) {
            return null;
        } else {
            DocumentConverter documentConverter = new DocumentConverter();
            Document item = new Document();
            item.setId(vo.getId());
            item.setLibelle(vo.getLibelle());
            item.setPathe(vo.getPathe());
            return item;
        }

    }

    @Override
    public DocumentVo toVo(Document item) {
                if (item == null) {
            return null;
        } else {
            DocumentConverter documentConverter = new DocumentConverter();
            DocumentVo vo = new DocumentVo();
            vo.setId(item.getId());
            vo.setLibelle(vo.getLibelle());
            vo.setPathe(vo.getPathe());
            return vo;
        }
    }
    
}
