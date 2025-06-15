/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modul10contoh1filtering.dao;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modul10contoh1filtering.models.KategoriBuku;

/**
 *
 * @author Muhammad Rizky S
 */
public class KategoriBukuDAO {
    
    public List<KategoriBuku> getAllKategoriBuku() {
        List<KategoriBuku> kategoriBukuList = new ArrayList<>();
        String query = "SELECT * FROM kategori_buku";

        try (
            Connection koneksi = DBConnection.getConnection();
            Statement stmt = koneksi.createStatement();
            ResultSet rs = stmt.executeQuery(query)
        ) {
            while (rs.next()) {
                String kodeKategori = rs.getString("kode_kategori");
                String namaKategori = rs.getString("nama_kategori");

                kategoriBukuList.add(new KategoriBuku(kodeKategori, namaKategori));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return kategoriBukuList;
    }
}
