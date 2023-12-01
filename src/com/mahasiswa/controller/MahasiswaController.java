/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mahasiswa.controller;

import com.mahasiswa.config.HibernateUtil;
import com.mahasiswa.dao.MahasiswaDao;
import com.mahasiswa.model.Mahasiswa;
import com.mahasiswa.model.MahasiswaTabelModel;
import com.mahasiswa.view.MahasiswaView;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Thinkpad
 */
public class MahasiswaController {
    private MahasiswaView mahasiswaView;
    private List<Mahasiswa> listMahasiswa;
    private MahasiswaTabelModel MahasiswaTabelModel;
    private final MahasiswaDao mahasiswaDao = HibernateUtil.getMahasiswaDao();

    public MahasiswaController(MahasiswaView mahasiswaView) {
        this.mahasiswaView = mahasiswaView;
    }

    public void clear(){
        this.mahasiswaView.getTxtNpm().setText("");
        this.mahasiswaView.getTxtNama().setText("");
        this.mahasiswaView.getTxtKelas().setText("");
        this.mahasiswaView.getTxtNope().setText("");    
    }
    
    public void saveMahasiswa(){
        Mahasiswa mahasiswa = new Mahasiswa();
        mahasiswa.setKd_mahasiswa(this.mahasiswaView.getTxtNpm().getText());
        mahasiswa.setNama(this.mahasiswaView.getTxtNama().getText());
        mahasiswa.setKelas(this.mahasiswaView.getTxtKelas().getText());
        mahasiswa.setNope((this.mahasiswaView.getTxtNope().getText()));
        
        try{
            mahasiswaDao.save(mahasiswa);
            JOptionPane.showMessageDialog(null, "Berhasil menyimpan Data", "Success", JOptionPane.INFORMATION_MESSAGE);
            clear();
            getAllData();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Gagal menyimpan Data", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void updateMahasiswa(){
        Mahasiswa mahasiswa = new Mahasiswa();
        mahasiswa.setKd_mahasiswa(this.mahasiswaView.getTxtNpm().getText());
        mahasiswa.setNama(this.mahasiswaView.getTxtNama().getText());
        mahasiswa.setKelas(this.mahasiswaView.getTxtKelas().getText());
        mahasiswa.setNope((this.mahasiswaView.getTxtNope().getText()));
        
        try{
            mahasiswaDao.update(mahasiswa);
            JOptionPane.showMessageDialog(null, "Berhasil mengubah Data", "Success", JOptionPane.INFORMATION_MESSAGE);
            clear();
            getAllData();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Gagal mengubah Data", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public void deleteMahasiswa(){
        if(this.mahasiswaView.getTxtNpm().getText() == null){
            JOptionPane.showMessageDialog(null, "Data Belum Dipilih", "Error", JOptionPane.INFORMATION_MESSAGE);
        }else{
            Mahasiswa mahasiswa = new Mahasiswa();
            mahasiswa.setKd_mahasiswa(this.mahasiswaView.getTxtNpm().getText());
            
            int option = JOptionPane.showConfirmDialog(null, "Apakah ingin menghapus ini ?","Warning", JOptionPane.YES_OPTION, JOptionPane.WARNING_MESSAGE);
            if(option == JOptionPane.YES_OPTION){
                try{
                    mahasiswaDao.delete(mahasiswa);
                    JOptionPane.showMessageDialog(null, "Berhasil menghapus Data", "Success", JOptionPane.INFORMATION_MESSAGE);
                    clear();
                    getAllData();
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Gagal mengubah Data", "Error", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }
    
    public void getAllData(){
        listMahasiswa = mahasiswaDao.getList();
        MahasiswaTabelModel = new MahasiswaTabelModel(listMahasiswa);
        this.mahasiswaView.getTblMahasiswa().setModel(MahasiswaTabelModel);
    }
    
    public void getdata(){
        int rowIndex = this.mahasiswaView.getTblMahasiswa().getSelectedRow();
        this.mahasiswaView.getTxtNpm().setText(String.valueOf(this.mahasiswaView.getTblMahasiswa().getValueAt(rowIndex, 0)));
        this.mahasiswaView.getTxtNama().setText(String.valueOf(this.mahasiswaView.getTblMahasiswa().getValueAt(rowIndex, 1)));
        this.mahasiswaView.getTxtKelas().setText(String.valueOf(this.mahasiswaView.getTblMahasiswa().getValueAt(rowIndex, 2)));
        this.mahasiswaView.getTxtNope().setText(String.valueOf(this.mahasiswaView.getTblMahasiswa().getValueAt(rowIndex, 3)));
    }
}
