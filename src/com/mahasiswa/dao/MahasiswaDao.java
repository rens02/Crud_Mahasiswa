/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mahasiswa.dao;

import com.mahasiswa.model.Mahasiswa;
import java.util.List;

/**
 *
 * @author Thinkpad
 */
public interface MahasiswaDao {
    public void save(Mahasiswa mahasiswa);
    public void update(Mahasiswa mahasiswa);
    public void delete(Mahasiswa mahasiswa);
    public Mahasiswa get(String kd_mahasiswa);
    public List<Mahasiswa> getList();
}
