/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.furniture.config;

/**
 *
 * @author gugulethu.ngwenya
 */
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author systems1
 */
public class PersitenceUnit {
    private static PersitenceUnit pu;
    public static PersitenceUnit getInstance(){
        if(pu==null){
            return new PersitenceUnit();
        }
        return pu;
    }
    
    public EntityManagerFactory enFactory = Persistence.createEntityManagerFactory("com.furniture_SNAPSHOTPU.0PU");
}