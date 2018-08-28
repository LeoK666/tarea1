/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.educlic.ticketsc.dao;

import java.util.List;
import mx.educlic.ticketsc.util.HibernateUtil;
import mx.educlic.ticketsc.vo.Usuario;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Leo
 */
public class UserDAO {
    static public long addUsuario(Usuario obj)
    {
        Session sesion = null;
        Transaction transaction = null;
        try{
            sesion = HibernateUtil.getSessionFactory().openSession();
            transaction = sesion.beginTransaction();
            sesion.saveOrUpdate(obj);
            transaction.commit();
        }catch (HibernateException e){
            if(transaction != null && transaction.isActive()){
                transaction.rollback();
            }
            if(sesion != null && sesion.isOpen()){
                sesion.close();
            }
        }
        return obj.getId();
    }
    
    static public void dropUsuario (int id)
    {
        Session sesion = null;
        Transaction transaction = null;
        try{
            sesion = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = sesion.beginTransaction();
            Usuario obj = (Usuario) sesion.get(Usuario.class, id);
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
    
    static public Usuario getUsuario (String user,String contrasena)
    {
        SessionFactory sf= HibernateUtil.getSessionFactory();
        Session sesion = null;
        Transaction transaction = null;
        Usuario obj=new Usuario();
        try{
            sesion = sf.openSession();
            transaction = sesion.beginTransaction();
            Query query = sesion.createSQLQuery("select * from Usuarios where correro ='"+ user +"' and contrasena ='"+contrasena+"';").addEntity(Usuario.class);
            obj = (Usuario) query.uniqueResult();
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
    
    public static List<Usuario> getUsuarios(String sql){
        List<Usuario> list= null;
        SessionFactory sf= HibernateUtil.getSessionFactory();
        Session sesion = null;
        Transaction transaction = null;
        Usuario obj=new Usuario();
        try{
            sesion = sf.openSession();
            transaction = sesion.beginTransaction();
            Query query = sesion.createSQLQuery(sql).addEntity(Usuario.class);
            list = query.list();
            transaction.commit();
        }catch (HibernateException e){
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
    
    
