/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modul10contoh1filtering.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import modul10contoh1filtering.models.Buku;

/**
 *
 * @author Muhammad Rizky S
 */
public class BukuDAO {

    public static String filterTanggalDari;
    public static String filterTanggalSampai;
    public static String filterJudul;
    public static String filterKategori;

    public static List<Buku> getAllBuku() {
        List<Buku> bukuList = new ArrayList<>();
        String sql = "SELECT buku.*, kategori_buku.nama_kategori "
                + "FROM buku "
                + "LEFT JOIN kategori_buku ON buku.kode_kategori = kategori_buku.kode_kategori "
                + "WHERE 1=1";

        if (filterTanggalDari != null && !filterTanggalDari.isEmpty()) {
            sql += " AND buku.tanggal_pengadaan BETWEEN '" + filterTanggalDari + "' AND '" + filterTanggalSampai + "' ";
        }

        if (filterJudul != null && !filterJudul.isEmpty()) {
            sql += " AND buku.judul LIKE '%" + filterJudul + "%' ";
        }

        if (filterKategori != null && !filterKategori.isEmpty()) {
            sql += " AND buku.kode_kategori = '" + filterKategori + "' ";
        }

        try (
                Connection koneksi = DBConnection.getConnection(); Statement stmt = koneksi.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String kodeBuku = rs.getString("kode_buku");
                String kodeKategori = rs.getString("kode_kategori");
                String judul = rs.getString("judul");
                String pengarang = rs.getString("pengarang");
                String penerbit = rs.getString("penerbit");
                int tahun = rs.getInt("tahun_terbit");
                int edisi = rs.getInt("edisi");
                String tanggalPengadaan = rs.getString("tanggal_pengadaan");
                String namaKategori = rs.getString("nama_kategori");

                bukuList.add(new Buku(
                        kodeBuku, kodeKategori, judul, pengarang, penerbit, tahun, edisi, tanggalPengadaan, namaKategori
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bukuList;
    }
}
