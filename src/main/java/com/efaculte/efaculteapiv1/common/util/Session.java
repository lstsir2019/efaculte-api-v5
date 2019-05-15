/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.ccisrms.app.ccisrms.Util;

/**
 *
 * @author Keita Moussa
 */


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.List;
public class Session {

    private static List<SessionItem> myMap = new ArrayList<>();


    public static Object getAttribut(String name) {
        for (int i = 0; i < myMap.size(); i++) {
            SessionItem sessionItem = myMap.get(i);
            if (sessionItem.getKey().equals(name)) {
                return sessionItem.getObject();
            }
        }
        return null;
    }
    
    public static void RegisterUser(Object obj){
        createAtrribute(obj, "user");
    }
    
    public static Object getConnectedUser(){
        Object obj = getAttribut("user");
        return obj;
    }

    public static int updateAttribute(Object obj, String name) {
        int index = indexOfAttribut(name);
        if (index == -1) {
            createAtrribute(obj,name );
            return 1;
        } else {
            myMap.get(index).setObject(obj);
            return 2;
        }
    }

    public static int delete(String name) {
        int index = indexOfAttribut(name);
        if (index != -1) {
            myMap.remove(index);
            return 1;
        }
        return -1;

    }

    public static void clear() {
        myMap.clear();
    }

    public static void createAtrribute(Object obj,String name ) {
        SessionItem sessionItem = new SessionItem();
        sessionItem.setKey(name);
        sessionItem.setObject(obj);
        myMap.add(sessionItem);
    }

    private static int indexOfAttribut(String name) {
        for (int i = 0; i < myMap.size(); i++) {
            SessionItem sessionItem = myMap.get(i);
            if (sessionItem.getKey().equals(name)) {
                return i;
            }
        }
        return -1;

    }
}

