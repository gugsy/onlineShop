/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.furniture.controllers;

import com.furniture.config.PersitenceUnit;
import com.furniture.controllers.exceptions.NonexistentEntityException;
import com.furniture.entities.Products;
import com.furniture.entities.Users;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author gugulethu.ngwenya
 */
public class ProductsJpaController implements Serializable {
    BaseDao pu=new BaseDao();


    
    public List<Products> selectAll() {
        EntityManager em = pu.getEntityManager();
         List results= new ArrayList();
        try {
            em.getTransaction().begin();
            Query query = em.createNamedQuery("Products.findAll");
             results = query.getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return results;
    }    
    
    //////
 
  public void updateRate(Float rate){
    
        EntityManager em = pu.getEntityManager();
        List<Products>  ps = selectAll();
        for(Products prod: ps){
        em.getTransaction().begin();
        prod.setRate(rate);
        em.merge(prod);
        em.getTransaction().commit();
        }
        em.close();       
       
    }

    
    
    
    
    /////

    public List<Users> selectAllUsers() {
        EntityManager em = pu.getEntityManager();
         List<Users> results= new ArrayList();
        try {
            em.getTransaction().begin();
            Query query = em.createNamedQuery("Users.findAll");
             results = query.getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return results;
    }  

    
    public void create(List<Products> products) {
        EntityManager em = pu.getEntityManager();
        try {
            
            for(Products a: products){
            em.getTransaction().begin();
            em.persist(a);}
            
            
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    public int insertProduct(Products prod){
                       EntityManager em = pu.getEntityManager();
        Query query = em.createNativeQuery("INSERT INTO Products (description, price, productName, quantity, rate) VALUES (?, ?, ?, ?, ?)");
query.setParameter(1, prod.getDescription());
query.setParameter(2, prod.getPrice());
query.setParameter(3, prod.getProductName());
query.setParameter(4, prod.getQuantity());
query.setParameter(5, prod.getRate());

try{
    em.getTransaction().begin();
    query.executeUpdate();
    em.getTransaction().commit();
    }
        
finally {
            if (em != null) {
                em.close();
            }
        }
        return 0;
    }

    public void edit(Products products) throws NonexistentEntityException, Exception {
        EntityManager em = pu.getEntityManager();
        try {
            em.getTransaction().begin();
            products = em.merge(products);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = products.getProductId();
                if (findProducts(id) == null) {
                    throw new NonexistentEntityException("The products with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = pu.getEntityManager();
        try {
            em.getTransaction().begin();
            Products products;
            try {
                products = em.getReference(Products.class, id);
                products.getProductId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The products with id " + id + " no longer exists.", enfe);
            }
            em.remove(products);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Products> findProductsEntities() {
        return findProductsEntities(true, -1, -1);
    }

    public List<Products> findProductsEntities(int maxResults, int firstResult) {
        return findProductsEntities(false, maxResults, firstResult);
    }

    private List<Products> findProductsEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = pu.getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Products.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Products findProducts(Integer id) {
        EntityManager em = pu.getEntityManager();
        try {
            return em.find(Products.class, id);
        } finally {
            em.close();
        }
    }
  
    public int getProductsCount() {
        EntityManager em = pu.getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Products> rt = cq.from(Products.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public class BaseDao {
    private static final String PERSISTENCE_UNIT_NAME = "com.furniture_SNAPSHOTPU";

    EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

    public EntityManager getEntityManager() {
      return factory.createEntityManager();
    } 
}
    
}
