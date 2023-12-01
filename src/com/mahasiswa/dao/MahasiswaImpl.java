/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mahasiswa.dao;

import com.mahasiswa.model.Mahasiswa;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Thinkpad
 */
public class MahasiswaImpl implements MahasiswaDao{
    private final SessionFactory sessionFactory;
    
    public MahasiswaImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    

    @Override
    public void save(Mahasiswa mahasiswa) {
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            session.save(mahasiswa);
            session.getTransaction().commit();
            
        }catch(Exception e){
            System.err.print("Tidak dapat menyimpan");
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Mahasiswa mahasiswa) {
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            session.update(mahasiswa);
            session.getTransaction().commit();
            
        }catch(Exception e){
            System.err.print("Tidak dapat update");
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Mahasiswa mahasiswa) {
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            session.delete(mahasiswa);
            session.getTransaction().commit();
            
        }catch(Exception e){
            System.err.print("Tidak dapat menghapus");
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Mahasiswa get(String kd_mahasiswa) {
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            Mahasiswa mahasiswa = (Mahasiswa) session.get(Mahasiswa.class, kd_mahasiswa);
            session.getTransaction().commit();
            return mahasiswa;
            
        }catch(Exception e){
            System.err.print("Tidak dapat menampilkan data mahasiswa");
            session.getTransaction().rollback();
            return null;
        }finally{
            session.close();
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Mahasiswa> getList() {
        
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            List<Mahasiswa> listmahasiswa = session.createCriteria(Mahasiswa.class).list();
            session.getTransaction().commit();
            return listmahasiswa;
            
        }catch(Exception e){
            System.err.print("Tidak ada data mahasiswa");
            session.getTransaction().rollback();
            return null;
        }finally{
            session.close();
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
