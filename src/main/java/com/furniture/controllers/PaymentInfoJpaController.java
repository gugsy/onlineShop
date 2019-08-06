/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.furniture.controllers;

import com.furniture.controllers.ProductsJpaController.BaseDao;
import com.furniture.controllers.exceptions.NonexistentEntityException;
import com.furniture.entities.PaymentInfo;
import com.furniture.models.SendMail;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.mail.MessagingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author mariona
 */
public class PaymentInfoJpaController implements Serializable {

     BaseDao pu=new BaseDao();
     
   //persisting payment info  
    public void create(List<PaymentInfo> paymentInfo) {
        paymentInfo = new ArrayList();
        EntityManager em = pu.getEntityManager();
        try {
            
            for(PaymentInfo p:paymentInfo){
            
            em.getTransaction().begin();
            em.persist(p);
            
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    
    public PaymentInfo addInfo(HttpServletRequest request) throws MessagingException{
    EntityManager em = pu.getEntityManager();
    
    String name = request.getParameter("name");
    String surname = request.getParameter("surname");
    String companyName = request.getParameter("companyName");
    String email = request.getParameter("email");
    String phoneNumber = request.getParameter("phoneNumber");
    String comment = request.getParameter("comment");
   String address = request.getParameter("address");
   em.getTransaction().begin();
   PaymentInfo pi = new PaymentInfo();
   pi.setName(name);
   pi.setAddress(address);
   pi.setComment(comment);
   pi.setCompanyName(companyName);
   pi.setEmail(email);
   pi.setSurame(surname);
   em.persist(pi);
   
   //Query sql1 = em.createNativeQuery("insert into paymentInfo  name="+name+", surname="+surname+",companyName="+companyName+",email="+email+",phoneNumber="+phoneNumber+",address="+address+",comment="+comment+"");
  // sql1.executeUpdate();
   em.getTransaction().commit();
   em.close();
   // SendMail sm = new SendMail();
   // sm.generateAndSendEmail(name, surname, comment);
    
    return pi;
    }
/*
    public void edit(List<PaymentInfo> paymentInfo) throws NonexistentEntityException, Exception {
        EntityManager em = pu.getEntityManager();
        try {
           
            for(PaymentInfo p : paymentInfo){
            em.getTransaction().begin();
            p = (PaymentInfo) em.merge(paymentInfo);
            
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = paymentInfo.get(0);
                if (findPaymentInfo(id) == null) {
                    throw new NonexistentEntityException("The paymentInfo with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
/*
    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PaymentInfo paymentInfo;
            try {
                paymentInfo = em.getReference(PaymentInfo.class, id);
                paymentInfo.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The paymentInfo with id " + id + " no longer exists.", enfe);
            }
            em.remove(paymentInfo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
*/
 /*   public List<PaymentInfo> findPaymentInfoEntities() {
        return findPaymentInfoEntities(true, -1, -1);
    }

    public List<PaymentInfo> findPaymentInfoEntities(int maxResults, int firstResult) {
        return findPaymentInfoEntities(false, maxResults, firstResult);
    }
/*
    private List<PaymentInfo> findPaymentInfoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PaymentInfo.class));
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

    public PaymentInfo findPaymentInfo(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PaymentInfo.class, id);
        } finally {
            em.close();
        }
    }

    public int getPaymentInfoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PaymentInfo> rt = cq.from(PaymentInfo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    */
    
        public class BaseDao {
    private static final String PERSISTENCE_UNIT_NAME = "com.furniture_SNAPSHOTPU";

    EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

    public EntityManager getEntityManager() {
      return factory.createEntityManager();
    } 
}
    
}
