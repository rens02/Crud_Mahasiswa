/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mahasiswa.model;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 *
 * @author Thinkpad
 */
@Entity
@Table(name = "mahasiswa")
public class Mahasiswa implements Serializable{
    @Id
    @Column(name = "NPM", length = 15)
    private String kd_mahasiswa;
    @Column(name = "nama", length = 99)
    private String nama;
    @Column(name = "kelas", length = 20)
    private String kelas;
    @Column(name = "NomorTelepon", length = 99)
    private String nope;

    public String getKd_mahasiswa() {
        return kd_mahasiswa;
    }

    public void setKd_mahasiswa(String kd_mahasiswa) {
        this.kd_mahasiswa = kd_mahasiswa;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public String getNope() {
        return nope;
    }

    public void setNope(String nope) {
        this.nope = nope;
    } 
}


