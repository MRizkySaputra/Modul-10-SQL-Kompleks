/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modul10contoh2sorting.models;

import java.time.LocalDate;

/**
 *
 * @author Muhammad Rizky S
 */
public class Buku {

    private String kodeBuku;
    private String kodeKategori;
    private String judul;
    private String pengarang;
    private String penerbit;
    private int tahun;
    private int edisi;
    private String tanggalPengadaan;
    private String namaKategori;

    public Buku(String kodeBuku, String kodeKategori, String judul, String pengarang, String penerbit, int tahun, int edisi, String tanggalPengadaan, String namaKategori) {
        this.kodeBuku = kodeBuku;
        this.kodeKategori = kodeKategori;
        this.judul = judul;
        this.pengarang = pengarang;
        this.penerbit = penerbit;
        this.tahun = tahun;
        this.edisi = edisi;
        this.tanggalPengadaan = tanggalPengadaan;
        this.namaKategori = namaKategori;
    }

    public String getKodeBuku() {
        return kodeBuku;
    }

    public void setKodeBuku(String kodeBuku) {
        this.kodeBuku = kodeBuku;
    }

    public String getKodeKategori() {
        return kodeKategori;
    }

    public void setKodeKategori(String kodeKategori) {
        this.kodeKategori = kodeKategori;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getPengarang() {
        return pengarang;
    }

    public void setPengarang(String pengarang) {
        this.pengarang = pengarang;
    }

    public String getPenerbit() {
        return penerbit;
    }

    public void setPenerbit(String penerbit) {
        this.penerbit = penerbit;
    }

    public int getTahun() {
        return tahun;
    }

    public void setTahun(int tahun) {
        this.tahun = tahun;
    }

    public int getEdisi() {
        return edisi;
    }

    public void setEdisi(int edisi) {
        this.edisi = edisi;
    }

    public String getTanggalPengadaan() {
        return tanggalPengadaan;
    }

    public void setTanggalPengdaan(String tanggalPengadaan) {
        this.tanggalPengadaan = tanggalPengadaan;
    }

    public String getNamaKategori() {
        return namaKategori;
    }

    public void setNamaKategori(String namaKategori) {
        this.namaKategori = namaKategori;
    }
}
