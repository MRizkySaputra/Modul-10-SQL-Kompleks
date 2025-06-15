/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package modul10contoh1filtering.controllers;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import modul10contoh1filtering.dao.BukuDAO;
import modul10contoh1filtering.dao.KategoriBukuDAO;
import modul10contoh1filtering.models.Buku;
import modul10contoh1filtering.models.KategoriBuku;

/**
 *
 * @author Muhammad Rizky S
 */
public class MainController implements Initializable {
    
    @FXML private ComboBox<KategoriBuku> cbxKategori;
    @FXML private DatePicker dpcDari;
    @FXML private DatePicker dpcSampai;
    @FXML private TextField txtJudul;
    @FXML private Button btnFilter;
    
    @FXML private TableView<Buku> tblViewBuku;
    @FXML private TableColumn<Buku, String> colJudul;
    @FXML private TableColumn<Buku, String> colKategori;
    @FXML private TableColumn<Buku, String> colKodeBuku;
    @FXML private TableColumn<Buku, String> colPenerbit;
    @FXML private TableColumn<Buku, String> colPengarang;
    @FXML private TableColumn<Buku, String> colTahun;
    @FXML private TableColumn<Buku, String> colEdisi;
    @FXML private TableColumn<Buku, String> colPengadaan;
    
    private ObservableList<Buku> bukuList;
    
    private void loadDataKategori() {
        KategoriBukuDAO kategoriBukuDAO = new KategoriBukuDAO();
        
        ObservableList<KategoriBuku> kategoriBukuList = FXCollections.observableArrayList(kategoriBukuDAO.getAllKategoriBuku());
        cbxKategori.setItems(kategoriBukuList);
    }
    
    public String getSelectedKodeKategori(){
        KategoriBuku selectedKategoriBuku = cbxKategori.getSelectionModel().getSelectedItem();
        
        if(selectedKategoriBuku !=null){
            return selectedKategoriBuku.getKodeKategori();
        }
        return null;
    }
    
    private void loadDataBuku(){
        bukuList = FXCollections.observableArrayList(BukuDAO.getAllBuku());
        tblViewBuku.setItems(bukuList);
    }
    
    @FXML
    private void handleBtnFilter(ActionEvent event){
        bukuList.clear();
        BukuDAO.filterJudul = txtJudul.getText();
        LocalDate dari = dpcDari.getValue();
        LocalDate sampai = dpcSampai.getValue();
        if (dari != null || sampai !=null){
            BukuDAO.filterTanggalDari = dari.toString();
            BukuDAO.filterTanggalSampai = sampai.toString();
        }
        
        if(getSelectedKodeKategori()!=null){
            BukuDAO.filterKategori = getSelectedKodeKategori();
        }
        
        loadDataBuku();
    }
    
    private void initTableViewBuku(){
        colKodeBuku.setCellValueFactory(
                new PropertyValueFactory<>("kodeBuku")
        );
        colKategori.setCellValueFactory(
                new PropertyValueFactory<>("namaKategori")
        );
        colJudul.setCellValueFactory(
                new PropertyValueFactory<>("judul")
        );
        colPengarang.setCellValueFactory(
                new PropertyValueFactory<>("pengarang")
        );
        colPenerbit.setCellValueFactory(
                new PropertyValueFactory<>("penerbit")
        );
        colTahun.setCellValueFactory(
                new PropertyValueFactory<>("tahun")
        );
        colEdisi.setCellValueFactory(
                new PropertyValueFactory<>("edisi")
        );
        colPengadaan.setCellValueFactory(
                new PropertyValueFactory<>("tanggalPengadaan")
        );
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadDataKategori();
        initTableViewBuku();
        loadDataBuku();
    }    
    
}
