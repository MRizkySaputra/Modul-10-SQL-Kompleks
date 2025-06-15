/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package modul10contoh2sorting.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml. Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import modul10contoh2sorting.dao.BukuDAO;
import modul10contoh2sorting.models.Buku;

/**
 *
 * @author Muhammad Rizky S
 */

public class MainController implements Initializable{
    
    @FXML private ComboBox<String> cbxSorting;
    @FXML private Button btnSorting;
    
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
    
    private void initComboboxSorting(){
        cbxSorting.setItems(
            FXCollections.observableArrayList(
                "",
                "Judul A-Z",
                "Judul Z-A",
                "Pengadaan Terbaru",
                "Pengadaan Lama"
            )
        );
        cbxSorting.getSelectionModel().selectFirst();
    }
    
    public String getSelectedComboboxSorting(){
        String sortingOption = cbxSorting.getSelectionModel().getSelectedItem();
        return sortingOption;
    }
    
    private void loadTableBuku(){
        bukuList = FXCollections.observableArrayList(BukuDAO.getAllBuku());
        tblViewBuku.setItems(bukuList);
    }
    
    @FXML
    private void handleButtonSorting(ActionEvent event){
        bukuList.clear();
        BukuDAO.sortingOption = getSelectedComboboxSorting();
        
        loadTableBuku();
    }
    
    public void initTableViewBuku(){
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
    public void initialize(URL location, ResourceBundle resources) {
        initComboboxSorting();
        initTableViewBuku();
        loadTableBuku();
    }
}