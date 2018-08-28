/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.educlic.ticketsc.dao;

import java.util.List;
import mx.educlic.ticketsc.util.HibernateUtil;
import mx.educlic.ticketsc.vo.Account;
import mx.educlic.ticketsc.vo.User;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Leo
 */
public class safeDAO {
    static public long addAccount(Account obj)
    {
        Session sesion= null;
        Transaction transaction = null;
        try{
            sesion = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = sesion.beginTransaction();
            sesion.saveOrUpdate(obj);
            transaction.commit();
        }catch(HibernateException e){
            if (transaction != null && transaction.isActive()){
            transaction.rollback();
            }
            if(sesion != null && sesion.isOpen())
            {
                sesion.close();
            }
        }
        return obj.getId();
    }
    
    static public void dropAccount (Long id)
    {
        Session sesion = null;
        Transaction transaction = null;
        try{
            sesion = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = sesion.beginTransaction();
            Account obj = (Account) sesion.get(Account.class, id);
            obj.setStatus(new Byte("0"));
            sesion.update(obj);
            transaction.commit();
        }catch (HibernateException e){
            if(transaction != null && transaction.isActive()){
                transaction.rollback();
            }
            if(sesion != null && sesion.isOpen()){
                sesion.close();
            }
        }
    }
    
    static public Account getAccount (Long id)
    {
        Session sesion = null;
        Transaction transaction = null;
        Account obj = null;
        try{
            sesion = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = sesion.beginTransaction();
            obj = (Account) sesion.get(Account.class, id);
            transaction.commit();
        }catch (HibernateException e){
            if(transaction != null && transaction.isActive()){
                transaction.rollback();
            }
            if(sesion != null && sesion.isOpen()){
                sesion.close();
            }
        }
        return obj;
    }
    
    static public List<Account> getAccounts (String sql, Integer displaylength, Integer displaystart)
    {
      Session sesion = null;
      Transaction transaction = null;
      List<Account> list = null;
      try{
          sesion = HibernateUtil.getSessionFactory().getCurrentSession();
          transaction = sesion.beginTransaction();
          Query query = sesion.createSQLQuery(sql).addEntity(Account.class);
          query.setMaxResults(displaylength);
          query.setFirstResult(displaystart);
          list = query.list();
          transaction.commit();
          
      }catch(HibernateException e){
          if(transaction != null && transaction.isActive()){
              transaction.rollback();
          }
          if(sesion != null && sesion.isOpen()){
              sesion.close();
          }
      }
      return list;
    }
    static public long addUser(User obj)
    {
        Session sesion= null;
        Transaction transaction = null;
        try{
            sesion = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = sesion.beginTransaction();
            sesion.saveOrUpdate(obj);
            transaction.commit();
        }catch(HibernateException e){
            if (transaction != null && transaction.isActive()){
            transaction.rollback();
            }
            if(sesion != null && sesion.isOpen())
            {
                sesion.close();
            }
        }
        return obj.getId();
    }
    
    static public void dropUser (Long id)
    {
        Session sesion = null;
        Transaction transaction = null;
        try{
            sesion = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = sesion.beginTransaction();
            Account obj = (Account) sesion.get(Account.class, id);
            obj.setStatus(new Byte("0"));
            sesion.update(obj);
            transaction.commit();
        }catch (HibernateException e){
            if(transaction != null && transaction.isActive()){
                transaction.rollback();
            }
            if(sesion != null && sesion.isOpen()){
                sesion.close();
            }
        }
    }
    
    static public Account getUser (Long id)
    {
        Session sesion = null;
        Transaction transaction = null;
        Account obj = null;
        try{
            sesion = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = sesion.beginTransaction();
            obj = (Account) sesion.get(Account.class, id);
            transaction.commit();
        }catch (HibernateException e){
            if(transaction != null && transaction.isActive()){
                transaction.rollback();
            }
            if(sesion != null && sesion.isOpen()){
                sesion.close();
            }
        }
        return obj;
    }
    
    static public List<Account> getUsers (String sql, Integer displaylength, Integer displaystart)
    {
      Session sesion = null;
      Transaction transaction = null;
      List<Account> list = null;
      try{
          sesion = HibernateUtil.getSessionFactory().getCurrentSession();
          transaction = sesion.beginTransaction();
          Query query = sesion.createSQLQuery(sql).addEntity(Account.class);
          query.setMaxResults(displaylength);
          query.setFirstResult(displaystart);
          list = query.list();
          transaction.commit();
          
      }catch(HibernateException e){
          if(transaction != null && transaction.isActive()){
              transaction.rollback();
          }
          if(sesion != null && sesion.isOpen()){
              sesion.close();
          }
      }
      return list;
    }
    
    
    
}
