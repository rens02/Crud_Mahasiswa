/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mahasiswa.config;

import com.mahasiswa.dao.MahasiswaDao;
import com.mahasiswa.dao.MahasiswaImpl;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Thinkpad
 */
public class HibernateUtil {
    private static final SessionFactory SESSION_FACTORY;
    private static final MahasiswaDao Mahasiswa_DAO;
    
    static{
        try{
            SESSION_FACTORY = new Configuration().configure().buildSessionFactory();
            Mahasiswa_DAO = new MahasiswaImpl(SESSION_FACTORY);
        }catch(Throwable e){
            System.err.println("Initial SessionFactory Creation Failed : "+e);
            throw new ExceptionInInitializerError(e);   
        }
    }
    
    public static SessionFactory getSessionFactory(){
    return SESSION_FACTORY;
    }
    
    public static MahasiswaDao getMahasiswaDao(){
    return Mahasiswa_DAO;
    }
    
}
