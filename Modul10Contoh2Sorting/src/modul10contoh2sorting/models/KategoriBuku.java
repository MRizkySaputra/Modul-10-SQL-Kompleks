/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modul10contoh2sorting.models;

/**
 *
 * @author Muhammad Rizky S
 */
public class KategoriBuku {
    private String kodeKategori;
    private String namaKategori;
    
    public KategoriBuku(String kodeKategori, String namaKategori){
            this.kodeKategori = kodeKategori;
            this.namaKategori = namaKategori;
    }
    
    public String getKodeKategori(){
        return kodeKategori;
    }
    
    public void setKodeKategori(String kodeKategori){
        this.kodeKategori = kodeKategori;
    }
    
    public String getNamaKategori(){
        return namaKategori;
    }
    
    public void setNamaKategori (String namaKategori){
        this.namaKategori = namaKategori;
    }
    
    @Override
    public String toString(){
        return namaKategori;
    }
}