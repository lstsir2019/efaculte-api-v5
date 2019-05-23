/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.efaculte.efaculteapiv1.service;

import com.efaculte.efaculteapiv1.bean.Annonce;
import com.efaculte.efaculteapiv1.bean.Document;
import java.util.List;

/**
 *
 * @author admin
 */
public interface DocumentService {
    public int saveDocument(Annonce annonce, List<Document> documents) ;
}
