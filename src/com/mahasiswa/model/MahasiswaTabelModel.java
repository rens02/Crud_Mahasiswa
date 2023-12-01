/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mahasiswa.model;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author Thinkpad
 */
public class MahasiswaTabelModel extends AbstractTableModel {
    private List<Mahasiswa> listMahasiswa = new ArrayList();
    private String HEADER[] = {"NPM","Nama Mahasiswa","Kelas","Nomor Telepon"};
    

    public MahasiswaTabelModel(List<Mahasiswa> listMahasiswa) {
        this.listMahasiswa = listMahasiswa;
    }

    @Override
    public int getRowCount() {
        return listMahasiswa.size();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getColumnCount() {
        return HEADER.length;
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Mahasiswa mahasiswa = listMahasiswa.get(rowIndex);
        
        switch(columnIndex){
            case 0:
                return mahasiswa.getKd_mahasiswa();
            case 1:
                return mahasiswa.getNama();
            case 2:
                return mahasiswa.getKelas();
            case 3:
                return mahasiswa.getNope();
            default:
                return null;
               
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public String getColumnName(int index, String[] getHEADER){
        return getHEADER[index];
    }
}
 